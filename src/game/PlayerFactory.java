package game;

public class PlayerFactory {
	
	public static Player player(Long playerId) {
		Player player = new Player();
		player.setPlayerId(playerId);
		player.setLifePoints(20);
		player.setName("Dobby");
		return player;
	}

}
