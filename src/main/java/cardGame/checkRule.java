package cardGame;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import DATATYPE.Card;
import DATATYPE.CardNumber;
import DATATYPE.Player;

public class checkRule {

	public static boolean isAllCardSame(List<Card> card) {

		if (card.size() <= 1)
			return false;

		int numberSame = (card.size() >= 4) ? 4 : card.size();
		Collections.sort(card);

		Card c = card.get(0);
		boolean isallMatch = true;
		for (int i = 1; i < numberSame; i++) {
			if (!c.getNumber().equals(card.get(i).getNumber())) {
				isallMatch = false;
				break;
			}
		}
		
		return isallMatch;

	}

	public static boolean isCardInSequence(List<Card> card) {

		if (card.size() <= 1)
			return false;

		Collections.sort(card);
		boolean isallMatch = true;
		int cardOrder = card.get(0).getNumber().getCardOrder();
		for (int k = 1; k < card.size(); k++) {
			int p = card.get(k).getNumber().getCardOrder();
			//System.out.println("cardOrder"+ cardOrder);
			//System.out.println("p"+ p);
			if (cardOrder == 14) {
				if (p == 4 || p == 13) {
					cardOrder = p;
				} else {
					isallMatch = false;
					break;
				}
			} else if ( (cardOrder - 1) !=p ){
				isallMatch = false;
				break;
				
			} else {
				cardOrder = p;
			}

		}
		return isallMatch;

	}

	public static boolean twoCardSame(List<Card> card) {

		if (card.size() <= 1)
			return false;

		Collections.sort(card);
		boolean isallMatch = false;
		//System.out.println();
		for (int k = 1 ; k < card.size() ; k++) {
			int cardOrder = card.get(k-1).getNumber().getCardOrder();
			int p = card.get(k).getNumber().getCardOrder();
			if(cardOrder == p) {
				isallMatch= true;
				break;
			}
			
		}
		return isallMatch;

	}
	
	
}
