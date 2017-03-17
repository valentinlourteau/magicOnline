package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "DECK")
public class Deck implements Serializable {
	
	@Id
	@GeneratedValue(generator = "DECK_UID", strategy= GenerationType.SEQUENCE)
	@SequenceGenerator(name = "DECK_UID")
	@Column(name = "DECK_ID")
	private Long id;
	
	@ManyToMany
	@JoinTable(name = "DECK_CARD", joinColumns = @JoinColumn(name = "DECK_ID", referencedColumnName = "DECK_ID"),
	inverseJoinColumns=@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID"))
	private List<Card> cards = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User user;
	
	@Column(name = "NAME")
	private String name;
	
	@Transient
	private Map<Card, Integer> cardMap = new HashMap<>();
	
	@Transient
	private int cardsSize;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getCardsSize() {
		return cardMap.values().stream().mapToInt(Integer::intValue).sum();
	}

	public void setCardsSize(int cardsSize) {
		this.cardsSize = cardsSize;
	}

	public Map<Card, Integer> getCardMap() {
		return cardMap;
	}

	public void setCardMap(Map<Card, Integer> cardMap) {
		this.cardMap = cardMap;
	}

}
