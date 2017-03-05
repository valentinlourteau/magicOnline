package dao;

import java.util.List;

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

}
