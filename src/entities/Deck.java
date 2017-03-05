package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	private List<Card> cards;

	public long getId() {
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

}
