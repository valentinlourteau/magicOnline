package service;

import java.util.List;

import javax.ejb.Local;

import entities.Deck;

@Local
public interface DeckService {
	
	public List<Deck> findAll();
	
	public void persist(Deck deck);

	public void save(Deck deck);

}
