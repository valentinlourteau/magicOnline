package service;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import entities.Card;
import mtg.objects.MtgCard;

@Local
public interface MagicCorporationService {
	
	public List<MtgCard> getAllCards();
	
	public List<MtgCard> getAllCardsWithParameters(String parameters);

	public Set<Card> convertMtgCardsToCards(List<MtgCard> mtgCards);

}
