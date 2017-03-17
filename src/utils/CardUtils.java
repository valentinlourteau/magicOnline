package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Card;
import entities.Deck;

public class CardUtils {

	public static void addCard(Deck selectedDeck, Card cardToAdd) {
		if (selectedDeck.getCardMap().containsKey(cardToAdd) && selectedDeck.getCardMap().get(cardToAdd) < cardToAdd.getLimit())
			selectedDeck.getCardMap().replace(cardToAdd, selectedDeck.getCardMap().get(cardToAdd) + 1);
		selectedDeck.getCardMap().putIfAbsent(cardToAdd, 1);
	}

	public static void removeCard(Deck selectedDeck, Card cardToRemove) {
		if (selectedDeck.getCardMap().get(cardToRemove) != null) {
			if (selectedDeck.getCardMap().get(cardToRemove) == 1)
				selectedDeck.getCardMap().remove(cardToRemove);
			else
				selectedDeck.getCardMap().replace(cardToRemove, selectedDeck.getCardMap().get(cardToRemove) - 1);
		}
	}

	public static List<Card> getCardsFromMap(Map<Card, Integer> cardMap) {
		List<Card> cards = new ArrayList<>();
		cardMap.forEach((k, v) -> {
			for (int i = 0; i < v; i++) {
				cards.add(k);
			}
		});
		return cards;
	}

	public static Map<Card, Integer> getMapFromCards(List<Card> cards) {
		Map<Card, Integer> cardMap = new HashMap<>();
		cards.forEach(card -> {
			if (cardMap.containsKey(card) && cardMap.get(card) < card.getLimit())
				cardMap.replace(card, cardMap.get(card) + 1);
			cardMap.putIfAbsent(card, 1);
		});
		return cardMap;
	}

}
