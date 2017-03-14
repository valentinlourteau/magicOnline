package service;

import java.util.Set;

import javax.ejb.Local;

import dao.GenericJpaDao;
import entities.Card;

@Local
public interface CardService extends GenericJpaDao<Card> {
	
	public long countAll();

	public void removeAll();

	public Set<Card> findAllToSet();

}
