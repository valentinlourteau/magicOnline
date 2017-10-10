package controller;

import java.io.Serializable;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import game.Game;
import game.Player;
import game.socket.GameProvider;

@Named
@ViewScoped
public class PlayController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long gamePlayerId;
	private Game game;

	@Inject
	GameProvider gameProvider;

	/**
	 * this is me !
	 */
	private Player player;

	public void initView() {
		gamePlayerId = new Random().nextLong();
	}

	public void onStartToPlay() {
		game = gameProvider.getPreparedGame(gamePlayerId);
	}
	
	public void onNotifyGameIsReady() {
		game = gameProvider.getPreparedGame(gamePlayerId);
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
