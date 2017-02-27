package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * This file is part of mtgsdk.
 * https://github.com/MagicTheGathering/mtg-sdk-java
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT-license
 *
 * Created by thechucklingatom on 2/16/2016.
 *
 * Card class that is created from the JSON set representation.
 *
 * @author thechucklingatom
 */
@Entity
@Table(name = "CARD")
public class Card implements Serializable {
	
	@Id
	@GeneratedValue(generator = "CARD_UID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CARD_UID")
	private Long myId;
	
	@Column(name = "MAGIC_ID")
	private String id;
	
	@Column(name = "LAYOUT")
	private String layout;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy = "card", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<CardNames> names;
	
	@Column(name = "MANA_COST")
	private String manaCost;
	
	@Column(name = "CMC")
	private double cmc;
	
	@JoinTable(name = "CARD_COLOR", joinColumns=@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID"),
			inverseJoinColumns=@JoinColumn(name = "COLOR_ID", referencedColumnName = "COLOR_ID"))
	private List<Color> colors;
	
	@JoinTable(name = "CARD_COLOR_IDENTITY", joinColumns=@JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID"),
			inverseJoinColumns=@JoinColumn(name = "COLOR_IDENTITY_ID", referencedColumnName = "COLOR_IDENTITY_ID"))
	private List<ColorIdentity> colorIdentity;
	
	@Column(name = "TYPE")
	private Type type;
	
	@OneToMany(mappedBy = "card")
	private List<SuperType> supertypes;
	
	@OneToMany(mappedBy = "card")
	List<Type> types;
	
	@OneToMany(mappedBy = "card")
	private List<SubType> subtypes;
	
	@Column(name = "RARITY")
	private String rarity;
	
	@Column(name = "TEXT")
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
	private List<Variation> variations;
	
	@Column(name = "IMAGE_NAME")
	private String imageName;
	
	@Column(name = "WATERMARK")
	private String watermark;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BORDER")
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

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public List<ColorIdentity> getColorIdentity() {
		return colorIdentity;
	}

	public void setColorIdentity(List<ColorIdentity> colorIdentity) {
		this.colorIdentity = colorIdentity;
	}

	public List<SuperType> getSupertypes() {
		return supertypes;
	}

	public void setSupertypes(List<SuperType> supertypes) {
		this.supertypes = supertypes;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
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

	
}