package service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.DeckDao;
import dao.QueryDslEntities;
import entities.Deck;
import utils.CardUtils;

@Stateless
@LocalBean
public class DeckServiceImpl implements DeckService {
	
	@Inject
	private DeckDao deckDao;

	@Override
	public List<Deck> findAll() {
		List<Deck> decks = deckDao.findAll();
		decks = decks.stream().distinct().collect(Collectors.toList());
		decks.forEach(deck -> {
			deck.setCardMap(CardUtils.getMapFromCards(deck.getCards()));
		});
		return decks;
	}

	@Override
	public void persist(Deck deck) {
		deckDao.persist(deck);
	}

	@Override
	public void save(Deck deck) {
		if (deck.getId() == null)
			deckDao.persist(deck);
		else
			deckDao.merge(deck);
	}

}
