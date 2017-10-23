package controller;

import java.io.Serializable;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

import game.Game;
import game.Player;
import game.socket.GameProvider;

@Named
@ViewScoped
public class PlayController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long gamePlayerId;
	private Game game;
	
	@Inject @Push
	private PushContext gameSocket;

	@Inject
	GameProvider gameProvider;

	/**
	 * this is me !
	 */
	private Player player;
	
	private Player opponent;

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

	public void initView() {
		gamePlayerId = new Random().nextLong();
	}

	public void onStartToPlay() {
		game = gameProvider.getPreparedGame(gamePlayerId);
		if (game != null) {
			opponent = game.getPlayers().stream().filter(player -> !player.getPlayerId().equals(gamePlayerId)).findFirst().get();
			player = game.getPlayers().stream().filter(player -> player.getPlayerId().equals(gamePlayerId)).findFirst().get();
		}
			
	}

	public void onNotifyGameIsReady() {
		onStartToPlay();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Long getGamePlayerId() {
		return gamePlayerId;
	}

}
