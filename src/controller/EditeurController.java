package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Card;
import resources.MagicCorporationLoader;
import service.ClientProviderService;

@Named
@ViewScoped
public class EditeurController implements Serializable {
	
	@Inject
	ClientProviderService clientProviderService;
	
	@Inject
	MagicCorporationLoader magicCorporationLoader;
	
	private List<Card> cards = new ArrayList<>();

	public void initView() {
		cards = magicCorporationLoader.getAllCards().stream().collect(Collectors.toList());
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
}
