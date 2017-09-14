package service;

import java.util.Map;

import javax.ejb.Local;
import javax.faces.context.FacesContext;
import javax.websocket.Session;

import game.Player;

@Local
public interface GameService {
	
	public void instantiateNewGame(Map<String, Session> playerMap);

	public Player createPlayer();

}
