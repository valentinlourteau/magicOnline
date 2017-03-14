package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.DeckDao;
import dao.QueryDslEntities;
import entities.Deck;

@Stateless
@LocalBean
public class DeckServiceImpl implements DeckService {
	
	@Inject
	private DeckDao deckDao;

	@Override
	public List<Deck> findAll() {
		return deckDao.findAll();
	}

	@Override
	public void persist(Deck deck) {
		deckDao.persist(deck);
	}

}
