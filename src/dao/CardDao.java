package dao;

import java.util.Set;

import entities.Card;

public interface CardDao extends QueryDslEntities {
	
	public void insertAll(Set<Card> cards);

}
