package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Card;
import resources.CardAPI;

@Stateless
@LocalBean
public class MagicCorporationServiceImpl implements MagicCorporationService {

	@Override
	public List<Card> getAllCards() {
		return CardAPI.getAllCards();
	}

	@Override
	public List<Card> getAllCardsWithParameters(String parameters) {
		return CardAPI.getAllCards(parameters);
	}
	
}
