package game;

import java.util.List;

import entities.Card;
import entities.Deck;

public class Player {
	
	private Long playerId;
	
	private String name;
	private int lifePoints;
	private List<Card> cardsInHand;
	private Deck deck;
	
	public Long getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLifePoints() {
		return lifePoints;
	}
	
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	public List<Card> getCardsInHand() {
		return cardsInHand;
	}
	
	public void setCardsInHand(List<Card> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
}
