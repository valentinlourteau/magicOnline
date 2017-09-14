package game.socket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import service.GameService;

@Singleton
@ServerEndpoint(value = "/games/{gameId}/{playerId}")
public class ServerEndPoint {

	/**
	 * Key = GAMEID Value = MAP de <PLAYERID, SESSION>
	 */
	private Map<String, Map<String, Session>> gamePlayerMap = new ConcurrentHashMap<>();

	@OnOpen
	public void onOpen(Session session, @PathParam("gameId") String game, @PathParam("playerId") String player)
			throws IOException {
		System.out.println("Event @OnOpen du serverEndPoint");
		gamePlayerMap.putIfAbsent(game, new HashMap<>());
		gamePlayerMap.get(game).put(player, session);
		if (gamePlayerMap.get(game).values().size() == 2)
			System.out.println("Deux players connectés");
	}

	@OnMessage
	public String onReceiveMessage(String message, Session session, @PathParam("gameId") String game, @PathParam("playerId") String player) {
		System.out.println("Event @OnMessage du serverEndPoint");
		gamePlayerMap.get(game).forEach((k, v) -> {
			if (!player.equals(k))
				try {
					gamePlayerMap.get(game).get(k).getBasicRemote().sendText(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
		return "accusé de reception du serveur";
	}

	@OnError
	public void onError(Throwable t) {
		System.out.println("Event @OnError du serverEndPoint");
		t.printStackTrace();
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("Event @OnClose du serverEndPoint");
	}

}
