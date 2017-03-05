package game.socket;

import java.io.IOException;

import javax.ejb.Singleton;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/games/{gameId}/{playerId}")
public class ServerEndPoint {

	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("Event @OnOpen du serverEndPoint");
		session.getBasicRemote().sendText("onOpen");
	}

	@OnMessage
	public String onReceiveMessage(String message) {
		System.out.println("Event @OnMessage du serverEndPoint");
		return message + " (from your server)";
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
