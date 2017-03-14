package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Deck;

@Stateless
@LocalBean
public class DeckDaoImpl extends GenericJpaDaoImpl<Deck> implements DeckDao {

	@Override
	public Deck findById(long id) {
		return queryFactory().selectFrom(DECK).where(DECK.id.eq(id)).fetchOne();
	}

	@Override
	public List<Deck> findAll() {
		return queryFactory().selectFrom(DECK).fetch();
	}

}
