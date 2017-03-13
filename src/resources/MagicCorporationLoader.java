package resources;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import entities.Card;
import mtg.objects.MtgCard;
import service.MagicCorporationService;

@Singleton
@Startup
public class MagicCorporationLoader {
	
	private Set<Card> allCards = new HashSet<>();
	
	@Inject
	MagicCorporationService magicCorporationService;

	@PostConstruct
	void init() {
		List<MtgCard> mtgCards = loadCards();
		System.out.println("je commence le traitement");
		allCards = convertMtgCardsToCards(mtgCards);
		System.out.println("le traitement est fini");
	}

	private Set<Card> convertMtgCardsToCards(List<MtgCard> mtgCards) {
		return magicCorporationService.convertMtgCardsToCards(mtgCards);
	}

	private List<MtgCard> loadCards() {
		StringBuilder builder = new StringBuilder();
		builder.append("?set=RAV");
		return magicCorporationService.getAllCardsWithParameters(builder.toString());
	}

	public Set<Card> getAllCards() {
		return allCards;
	}

}
