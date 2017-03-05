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
@Table(name = "COLOR_IDENTITY")
public class ColorIdentity implements Serializable {
	
	@Id
	@GeneratedValue(generator = "COLOR_IDENTITY_UID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "COLOR_IDENTITY_UID")
	@Column(name = "COLOR_IDENTITY_ID")
	private Long id;

}
