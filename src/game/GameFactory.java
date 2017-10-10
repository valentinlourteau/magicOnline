package game;

import java.util.Arrays;

public class GameFactory {
	
	public static Game game(Long player1, Long player2) {
		Game game = new Game();
		game.setPlayers(Arrays.asList(PlayerFactory.player(player1), PlayerFactory.player(player2)));
		return game;
	}

}
