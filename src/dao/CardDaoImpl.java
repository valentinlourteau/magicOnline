package dao;

import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Card;

@Stateless
@LocalBean
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

	@Override
	public long countAll() {
		return queryFactory().selectFrom(CARD).fetchCount();
	}

	@Override
	public void removeAll() {
		queryFactory().delete(CARD).execute();
	}
}
