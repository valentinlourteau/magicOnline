package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.TabChangeEvent;

import entities.Card;
import entities.Deck;
import resources.MagicCorporationLoader;
import service.ClientProviderService;
import service.DeckService;

@Named
@ViewScoped
public class EditeurController implements Serializable {
	
	@Inject
	ClientProviderService clientProviderService;
	
	@Inject
	MagicCorporationLoader magicCorporationLoader;
	
	@Inject
	DeckService deckService;
	
	private List<Card> cards = new ArrayList<>();
	private List<Deck> decks = new ArrayList<>();
	
	private Deck selectedDeck = new Deck();

	public void initView() {
		decks = deckService.findAll();
		if (decks.isEmpty()) {
		selectedDeck = new Deck();
		selectedDeck.setName("Mon deck par défaut");
		decks.add(selectedDeck);
		}
		else {
			selectedDeck = decks.get(0);
		}		
		cards = magicCorporationLoader.getAllCards().stream().limit(30l).collect(Collectors.toList());
	}
	
	public void onAddNewDeck() {
		Deck newDeck = new Deck();
		newDeck.setName("Mon deck");
		selectedDeck = newDeck;
		decks.add(newDeck);
	}
	
	public void onDeckChange(TabChangeEvent event) {
		long deckId = (long) event.getTab().getAttributes().get("deckId");
		selectedDeck = decks.stream().filter(deck -> deck.getId() == deckId).findFirst().orElse(new Deck());
	}
	
	public void onAddCardToSelectedDeck(Card selectedCard) {
		selectedDeck.getCards().add(selectedCard);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Deck> getDecks() {
		return decks;
	}

	public void setDecks(List<Deck> decks) {
		this.decks = decks;
	}

	public Deck getSelectedDeck() {
		return selectedDeck;
	}

	public void setSelectedDeck(Deck selectedDeck) {
		this.selectedDeck = selectedDeck;
	}
	
}
