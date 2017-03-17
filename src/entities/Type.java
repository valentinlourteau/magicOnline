package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import combo.Combo;
import combo.provider.ComboProvider;

@Entity
@Table(name = "TYPE")
public class Type extends Combo implements Serializable {
	
	@Id
	@GeneratedValue(generator = "TYPE_UID", strategy= GenerationType.SEQUENCE)
	@SequenceGenerator(name = "TYPE_UID")
	@Column(name = "TYPE_ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
