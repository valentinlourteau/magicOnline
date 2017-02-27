package resources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import entities.Card;
import service.MagicCorporationService;

@Singleton
@Startup
public class MagicCorporationLoader {
	
	private List<Card> allCards;
	
	@Inject
	MagicCorporationService magicCorporationService;

	@PostConstruct
	void init() {
		StringBuilder builder = new StringBuilder();
		builder.append("?set=RAV");
		allCards = magicCorporationService.getAllCardsWithParameters(builder.toString());
	}

	public List<Card> getAllCards() {
		return allCards;
	}

	public void setAllCards(List<Card> allCards) {
		this.allCards = allCards;
	}

}
