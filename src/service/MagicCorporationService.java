package service;

import java.util.List;

import javax.ejb.Local;

import entities.Card;

@Local
public interface MagicCorporationService {
	
	public List<Card> getAllCards();
	
	public List<Card> getAllCardsWithParameters(String parameters);

}
