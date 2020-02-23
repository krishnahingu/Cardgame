package DATATYPE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Card implements Comparable<Card> {

	private CardNumber number;
	private CardType type;

	public Card(CardNumber number,CardType type) {
		this.number = number;
		this.type= type;
	}
	
	public CardNumber getNumber() {
		return number;
	}

	public CardType getType() {
		return type;
	}

	public static Stack<Card> getPackOfCards() {
		Stack<Card> cardList = new Stack<Card>();

		for (CardType type : CardType.values()) {
			for (CardNumber number : CardNumber.values()) {
				Card card= new Card(number,type);
				cardList.add(card);
			}
		}
		return cardList;
	}

	public static void shuffleCards(List<Card> cards) {
		Collections.shuffle(cards);
	}

	public int compareTo(Card o) {
		if (this.getNumber() == o.getNumber()) {
			return 0;
		} else if (this.getNumber().getCardOrder() > o.getNumber().getCardOrder()) {
			return -1;
		} else
			return 1;
	}

	@Override
	public String toString() {
		return "CARD [ Number=" + number + "]";
	}

}
