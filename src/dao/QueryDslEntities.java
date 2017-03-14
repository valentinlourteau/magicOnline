package dao;

import entities.QCard;
import entities.QDeck;

public interface QueryDslEntities {
	
	public static final QCard CARD = QCard.card;
	public static final QDeck DECK = QDeck.deck;
	
}
