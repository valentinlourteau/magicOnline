package dao;

import entities.QCard;
import entities.QDeck;
import entities.QType;

public interface QueryDslEntities {
	
	public static final QCard CARD = QCard.card;
	public static final QDeck DECK = QDeck.deck;
	public static final QType TYPE = QType.type;
	
}
