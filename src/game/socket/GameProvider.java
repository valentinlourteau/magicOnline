package game.socket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

import game.Game;
import game.GameFactory;

@Singleton
@Startup
public class GameProvider {

	@Inject
	@Push(channel = "play")
	private PushContext webSocket;

	private List<Game> games;
	private Set<Long> playersWaiting;

	@PostConstruct
	public void init() {
		games = new ArrayList<>();
		playersWaiting = new HashSet<>();
	}

	@Schedule(second = "*/10", minute = "*", hour = "*", persistent = false)
	public void cleanPlayersWaiting() {
			if (playersWaiting.size() >= 2) {
				System.out.println(playersWaiting.size());
				System.out.println("Y a des joueurs !");
				// débute l'affectation des parties
				Long player1 = playersWaiting.stream().findAny().get();
				playersWaiting.remove(player1);
				Long player2 = playersWaiting.stream().findAny().get();
				playersWaiting.remove(player2);
				System.out.println(playersWaiting.size());
				games.add(GameFactory.game(player1, player2));
				// notification des deux tanches qui vont jouer, 1 est le code
				webSocket.send("1", Arrays.asList(player1, player2));
				cleanPlayersWaiting();
		}
	}

	/**
	 * Permet de récupérer une partie initialisée
	 * 
	 * @return
	 */
	public Game getPreparedGame(Long playerId) {
		for (Game game : games) {
			if (game.hasPlayer(playerId))
				return game;
		}
		addPlayerToQueueList(playerId);
		return null;
//		return games.stream().filter(game -> game.hasPlayer(playerId)).findFirst()
//				.orElse(addPlayerToQueueList(playerId));
	}

	/**
	 * Permet d'ajouter un playerId dans la file
	 * 
	 * @param playerId
	 * @return
	 */
	private void addPlayerToQueueList(Long playerId) {
		playersWaiting.add(playerId);
	}

}
