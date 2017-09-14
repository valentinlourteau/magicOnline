package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import game.Player;
import service.GameService;

@Named
@ViewScoped
public class PlayController implements Serializable {

	@Inject
	GameService gameService;

	private Player player;

	public void initView() {
	}

	public void onGetPlayer() {
		player = gameService.createPlayer();
	}

	public void onSendMessageToOpponent() {
		try {
			player.getSession().getBasicRemote().sendText("Envoie d'un message à l'adversaire");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
