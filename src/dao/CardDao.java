package dao;

import java.util.Set;

import javax.ejb.Local;

import entities.Card;

@Local
public interface CardDao extends GenericJpaDao<Card> {
	
	public void insertAll(Set<Card> cards);
	
	public long countAll();

	public void removeAll();

}
