package service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;

import entities.Card;
import mtg.objects.MtgCard;
import resources.CardAPI;

@Stateless
@LocalBean
public class MagicCorporationServiceImpl implements MagicCorporationService {

	@Override
	public List<MtgCard> getAllCards() {
		return CardAPI.getAllCards();
	}

	@Override
	public List<MtgCard> getAllCardsWithParameters(String parameters) {
		return CardAPI.getAllCards(parameters);
	}

	@Override
	public Set<Card> convertMtgCardsToCards(List<MtgCard> mtgCards) {
		Set<Card> cards = new HashSet<>();
		System.out.println("nombre de cartes à convertir " + mtgCards.size());
		for (MtgCard item : mtgCards) {
			Card card = new Card();
			card.setArtist(item.getArtist());
			// card.setBorder(border);
			card.setCmc(item.getCmc());
			// card.setColorIdentity(colorIdentity);
			// card.setColors(colors);
			card.setFlavor(item.getFlavor());
			card.setHand(item.getHand());
			card.setId(item.getId());
			card.setImageName(item.getImageName());
			card.setImageUrl(item.getImageUrl());
			/*try {
				card.setImage(getImageFromUrl(card.getImageUrl()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			card.setLayout(item.getLayout());
			card.setLife(item.getLife());
			card.setLoyalty(item.getLoyalty());
			card.setManaCost(item.getManaCost());
			card.setMultiverseid(item.getMultiverseid());
			card.setName(item.getName());
//			Arrays.asList(item.getNames()).stream().forEach(itemCardName -> {
//				CardNames cardName = new CardNames();
//				cardName.setCard(card);
//				cardName.setLibelle(itemCardName);
//				card.getNames().add(cardName);
//			});
			card.setNumber(item.getNumber());
			card.setPower(item.getPower());
			card.setRarity(item.getRarity());
			card.setReleaseDate(item.getReleaseDate() != null ? new Date(item.getReleaseDate()) : null);
//			card.setSubtypes(subtypes);
//			card.setSupertypes(supertypes);
			card.setText(item.getText());
			card.setToughness(item.getToughness());
//			card.setType(new Type(item.getType()));
//			card.setTypes(types);
//			card.setVariations(variations);
			card.setWatermark(item.getWatermark());
			cards.add(card);
		}
		System.out.println("fin de la conversion des cartes");
		return cards;
	}
	
	private byte[] getImageFromUrl(String stringUrl) throws IOException {
		URL url = new URL(stringUrl);
		InputStream inputStream      = url.openStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte [] buffer               = new byte[ 1024 ];

        int n = 0;
        while (-1 != (n = inputStream.read(buffer))) {
           output.write(buffer, 0, n);
        }
        inputStream.close();

        // Here's the content of the image...
        byte [] data = output.toByteArray();
		return data;
		
	}

}
