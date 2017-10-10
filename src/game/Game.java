package game;

import java.util.List;

public class Game {
	
	private List<Player> players;

	public boolean hasPlayer(Long playerId) {
		return players.stream().anyMatch(player -> player.getPlayerId().equals(playerId));
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
