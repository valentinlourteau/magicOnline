package resources;

import java.util.List;

import entities.Card;

public class CardAPI extends MTGAPI {
	
	private static final String RESOURCE_PATH = "cards";

	/**
	 * Returns a {@link Card} based on the given multiverseid
	 */
	public static Card getCard(int multiverseId) {
		String path = String.format("%s/%s/", RESOURCE_PATH, multiverseId);
		return get(path, "card", Card.class);
	}

	/**
	 * Returns all the available {@link Card}s as a list.
	 */
	public static List<Card> getAllCards() {
		return getList(RESOURCE_PATH, "cards", Card.class);
	}

	/**
	 * Returns a {@link List} of all card types as {@link String}s.
	 * 
	 * @see <a href="https://docs.magicthegathering.io/#card-types">
	 * 		https://docs.magicthegathering.io/#card-types</a>
	 */
	public static List<String> getAllCardTypes() {
		String path = "types";
		List<String> cardTypes = getList(path, "types", String.class);
		return cardTypes;
	}

	public static List<Card> getAllCards(String parameters) {
		String path = RESOURCE_PATH + parameters;
		return getList(path, "cards", Card.class);
	}

}
