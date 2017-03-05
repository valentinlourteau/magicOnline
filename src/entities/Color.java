package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COLOR")
public class Color implements Serializable {

	@Id
	@GeneratedValue(generator = "COLOR_UID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "COLOR_UID")
	@Column(name = "COLOR_ID")
	private Long id;
	
}
