package resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import combo.enums.EditionEnum;
import entities.Card;
import mtg.objects.MtgCard;
import service.CardService;
import service.MagicCorporationService;

@Singleton
@Startup
public class MagicCorporationLoader {

	private Set<Card> allCards = new HashSet<>();

	@Inject
	private MagicCorporationService magicCorporationService;

	@Inject
	private CardService cardService;

	@PostConstruct
	void init() {
		List<MtgCard> mtgCards = loadCards(EditionEnum.RAVNICA);
		long amountOfCardsInDatabase = cardService.countAll();
		if (mtgCards.size() != (int) amountOfCardsInDatabase && mtgCards.size() > amountOfCardsInDatabase) {
			cardService.removeAll();
			System.out.println("je commence le traitement");
			allCards = convertMtgCardsToCards(mtgCards);
			allCards.forEach(card -> cardService.persist(card));
			System.out.println("le traitement est fini");
		}
		else
			allCards = cardService.findAllToSet();
	}

	private Set<Card> convertMtgCardsToCards(List<MtgCard> mtgCards) {
		return magicCorporationService.convertMtgCardsToCards(mtgCards);
	}

	private List<MtgCard> loadCards(EditionEnum edition) {
		List<MtgCard> allCards = new ArrayList<>();
		int page = 0;
		int cardListSize = 0;
		do {
			page++;
			cardListSize = allCards.size();
			allCards.addAll(magicCorporationService.getAllCardsWithParameters(buildUrl(edition.getLabel(), page)));
		} while (cardListSize != allCards.size() && allCards.size() - cardListSize == 100);
		return allCards;
	}

	private String buildUrl(String edition, int page) {
		StringBuilder builder = new StringBuilder();
		builder.append("?set=" + edition);
		builder.append("&page=" + page);
		return builder.toString();
	}

	public Set<Card> getAllCards() {
		return allCards;
	}

}
