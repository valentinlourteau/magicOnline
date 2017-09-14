package service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.websocket.Session;

import game.Player;
import singleton.ChannelProvider;

@LocalBean
@Stateless
public class GameServiceImpl implements GameService {

	@Override
	public void instantiateNewGame(Map<String, Session> playerMap) {
	}

	@Override
	public Player createPlayer() {
		try {
			return new Player(new URI(ChannelProvider.getUri()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
