package singleton;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.ejb.Singleton;

@Singleton
public class ChannelProvider {

	static Map<String, String> listURI = new ConcurrentHashMap<>();

	public static synchronized String getUri() {
		String game = null;
		String user = UUID.randomUUID().toString();
		if (listURI.isEmpty()) {
			game = UUID.randomUUID().toString();
			listURI.put(game, user);
		} else {
			game = listURI.keySet().stream().findAny().get().toString();
		}
		String toReturn = "ws://localhost:8080/magicOnline/games/" + game + '/' + user;
		System.out.println(toReturn);
		return toReturn;
	}

}
