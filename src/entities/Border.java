package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BORDER")
public class Border implements Serializable {
	
	@Id
	@GeneratedValue(generator = "BORDER_UID", strategy= GenerationType.SEQUENCE)
	@SequenceGenerator(name = "BORDER_UID")
	@Column(name = "BORDER_ID")
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARD_ID")
	private List<Card> card;

}
