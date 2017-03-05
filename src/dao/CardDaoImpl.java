package dao;

import java.util.List;
import java.util.Set;

import entities.Card;

public class CardDaoImpl extends GenericJpaDaoImpl<Card> implements CardDao {

	@Override
	public Card findById(long id) {
		return queryFactory().selectFrom(CARD).where(CARD.myId.eq(id)).fetchOne();
	}

	@Override
	public List<Card> findAll() {
		return queryFactory().selectFrom(CARD).fetch();
	}

	@Override
	public void insertAll(Set<Card> cards) {
		cards.forEach(card -> persist(card));
	}

}
