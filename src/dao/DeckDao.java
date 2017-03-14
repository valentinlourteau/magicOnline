package dao;

import javax.ejb.Local;

import entities.Deck;

@Local
public interface DeckDao extends GenericJpaDao<Deck> {

}
