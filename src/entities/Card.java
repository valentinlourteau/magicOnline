package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Le format de cartes converti en entité
 * @author oktamèr
 *
 */
@Entity
@Table(name = "CARD")
public class Card implements Serializable {
	
	@Id
	@GeneratedValue(generator = "CARD_UID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CARD_UID")
	@Column(name = "CARD_ID")
	private Long myId;
	
	@Column(name = "MAGIC_ID")
	private String id;
	
	@Column(name = "LAYOUT")
	private String layout;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy = "card", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<CardNames> names = new HashSet<>();
	
	@Column(name = "MANA_COST")
	private String manaCost;
	
	@Column(name = "CMC")
	private double cmc;
	
	@ManyToMany()
	@JoinTable(name = "CARD_COLOR", joinColumns=@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID"),
			inverseJoinColumns=@JoinColumn(name = "COLOR_ID", referencedColumnName = "COLOR_ID"))
	private Set<Color> colors = new HashSet<>();
	
	@ManyToMany()
	@JoinTable(name = "CARD_COLOR_IDENTITY", joinColumns=@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID"),
			inverseJoinColumns=@JoinColumn(name = "COLOR_IDENTITY_ID", referencedColumnName = "COLOR_IDENTITY_ID"))
	private Set<ColorIdentity> colorIdentity = new HashSet<>();
	
	@Column(name = "TYPE")
	private Type type;
	
	@ManyToMany()
	@JoinTable(name = "CARD_SUPERTYPE", joinColumns=@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID"),
			inverseJoinColumns=@JoinColumn(name = "SUPERTYPE_ID", referencedColumnName = "SUPERTYPE_ID"))
	private Set<SuperType> supertypes = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "CARD_TYPE", joinColumns=@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID"),
			inverseJoinColumns=@JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID"))
	private Set<Type> types = new HashSet<>();
	
	@OneToMany(mappedBy = "card")
	private Set<SubType> subtypes = new HashSet<>();
	
	@Column(name = "RARITY")
	private String rarity;
	
	@Column(name = "TEXT", length = 600)
	private String text;
	
	@Column(name = "FLAVOR")
	private String flavor;
	
	@Column(name = "ARTIST")
	private String artist;
	
	@Column(name = "NUMBER")
	private String number;
	
	@Column(name = "POWER")
	private String power;
	
	@Column(name = "TOUGHNESS")
	private String toughness;
	
	@Column(name = "LOYALTY")
	private int loyalty;
	
	@Column(name = "MULTIVERSE_ID")
	private int multiverseid = -1;
	
	@OneToMany(mappedBy = "card")
	private Set<Variation> variations = new HashSet<>();
	
	@Column(name = "IMAGE_NAME")
	private String imageName;
	
	@Column(name = "WATERMARK")
	private String watermark;
	
	@ManyToOne()
	@JoinColumn(name = "BORDER", nullable = true)
	private Border border;
	
	@Column(name = "TIMESHIFTED")
	private boolean timeshifted;
	
	@Column(name = "HAND")
	private int hand;
	
	@Column(name = "LIFE")
	private int life;
	
	@Column(name = "RESERVED")
	private boolean reserved;
	
	@Column(name = "RELEASE_DATE")
	private Date releaseDate;
	
	@Column(name = "STARTER")
	private boolean starter;
	
	@Column(name = "IMAGE_URL")
	private String imageUrl;
	
	@Lob
	@Column(name = "IMAGE")
	private byte[] image;

	/**
	 * dirty compare to in order to start testing. Just comparing the MultiverseId
	 * which should be unique.
	 * @param toCompare A {@link Card} object hopefully
	 * @return true if the same set, false if different.
	 */
	@Override
	public boolean equals(Object toCompare){
		if(toCompare instanceof Card){
			Card cardCompare = (Card)toCompare;
			return getMultiverseid() == cardCompare.getMultiverseid();
		}else{
			return false;
		}
	}

	/**
	 * Prints the Card name and multiverseId which should give enough info for debug testing.
	 * @return The cards name and Id
	 */
	@Override
	public String toString(){
		return "Card Name: " + getName() +
				"\nMultiverseId: " + getMultiverseid();
	}

	public Long getMyId() {
		return myId;
	}

	public void setMyId(Long myId) {
		this.myId = myId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public double getCmc() {
		return cmc;
	}

	public void setCmc(double cmc) {
		this.cmc = cmc;
	}

	public Set<CardNames> getNames() {
		return names;
	}

	public void setNames(Set<CardNames> names) {
		this.names = names;
	}

	public Set<Color> getColors() {
		return colors;
	}

	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}

	public Set<ColorIdentity> getColorIdentity() {
		return colorIdentity;
	}

	public void setColorIdentity(Set<ColorIdentity> colorIdentity) {
		this.colorIdentity = colorIdentity;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<SuperType> getSupertypes() {
		return supertypes;
	}

	public void setSupertypes(Set<SuperType> supertypes) {
		this.supertypes = supertypes;
	}

	public Set<Type> getTypes() {
		return types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	public Set<SubType> getSubtypes() {
		return subtypes;
	}

	public void setSubtypes(Set<SubType> subtypes) {
		this.subtypes = subtypes;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getToughness() {
		return toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}

	public int getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}

	public int getMultiverseid() {
		return multiverseid;
	}

	public void setMultiverseid(int multiverseid) {
		this.multiverseid = multiverseid;
	}

	public Set<Variation> getVariations() {
		return variations;
	}

	public void setVariations(Set<Variation> variations) {
		this.variations = variations;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	public Border getBorder() {
		return border;
	}

	public void setBorder(Border border) {
		this.border = border;
	}

	public boolean isTimeshifted() {
		return timeshifted;
	}

	public void setTimeshifted(boolean timeshifted) {
		this.timeshifted = timeshifted;
	}

	public int getHand() {
		return hand;
	}

	public void setHand(int hand) {
		this.hand = hand;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isStarter() {
		return starter;
	}

	public void setStarter(boolean starter) {
		this.starter = starter;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getLimit() {
		if (this.types.stream().anyMatch(type -> type.getLibelle().equals("Land")))
			return 60;
		else 
			return 4;
	}

	
	
}
