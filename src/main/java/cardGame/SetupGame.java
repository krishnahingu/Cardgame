package cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import DATATYPE.Card;
import DATATYPE.Player;

public class SetupGame {

	private Stack<Card> cards;
	private List<Player> players = new ArrayList<Player>();
	private Map<Player, List<Card>> cardsPlayerMap = new HashMap<Player, List<Card>>();
	private int numberOfCardsPerPlayer = 3;
	private int numberOfPlayers = 4;

	public SetupGame() {

		cards = Card.getPackOfCards();
		Card.shuffleCards(cards);

	}

	public SetupGame(int numberOfCardsPerPlayer, int NumberOfPlayer) {

		this();
		this.numberOfCardsPerPlayer = numberOfCardsPerPlayer;
		this.numberOfPlayers = NumberOfPlayer;

	}

	public boolean createUser() {

		if (players.size() != 0) {
			players.clear();
		}

		for (int i = 1; i <= numberOfPlayers; i++) {
			Player user = new Player(i);
			user.setPlayerName("P" + i);
			players.add(user);
		}

		return distributeCardToPlayer();
	}

	public boolean distributeCardToPlayer() {

		try {
			for (Player player : players) {

				List<Card> temp = new ArrayList<Card>();
				for (int i = 1; i <= numberOfCardsPerPlayer; i++) {
					temp.add(cards.pop());
				}
				Collections.sort(temp);
				cardsPlayerMap.put(player, temp);
			}
		} catch (EmptyStackException e) {
			System.out.println("Not able to distrubte card to each player equally");
			return false;
		}
		return true;
	}

	public void validateAllRule() {

		boolean isSame = allAreSame();
		if(!isSame) {
			System.out.println("Winnder not decide yet same card");
			if(!isSequence()) {
				System.out.println("Winnder not decide yet in isSequence ");
				if(!isTwoCardSame()) {
					System.out.println("Winnder not decide yet in isTwoCardSame ");
					System.out.println("in toporder car "+TopOrderCard());
				} else {
					System.out.println("Winnder in isTwoCardSame ");
					getWinner();
				}
				
			} else {
				System.out.println("Winnder in isSequence ");
				getWinner();
			}
			
		} else {
			System.out.println("Winnder in same card ");
			getWinner();
		}

	}
	
	public Player TopOrderCard() {
		
		
		int highvalue=-1;
		Player highPlayer=null;
		for(int i=0;i<numberOfCardsPerPlayer;i++) {
			
			for (Entry<Player, List<Card>> player :getCardsPlayerMap().entrySet()) {
				Player p = player.getKey();
				List<Card> cards = player.getValue();
				int value = cards.get(i).getNumber().getCardOrder();
				if(value > highvalue)  {
					highvalue=value;
					highPlayer=p;
				}
				for (Entry<Player, List<Card>> inPlayer :getCardsPlayerMap().entrySet()) {
					Player p1 = inPlayer.getKey();
					List<Card> incards = player.getValue();
					if(p1.equals(p)) {
						int value2 = incards.get(i).getNumber().getCardOrder();
						if(value==value2 && highvalue < value2) {
							highvalue=value;
							highPlayer=p1;
						} else if(value!=value2 && value < value2) {
							highvalue=value2;
							highPlayer=p1;
						} 
					}
				}
				
			}
			
		}
		
		
		return highPlayer;
	}
	public void getWinner() {
		
		for (Player player : getCardsPlayerMap().keySet()) {
			if (player.getResult() != null && player.getResult().equals("W")) {
				System.out.println("winner is :"+player.toString());
				break;
			}
			
		}
		
	}
	
	private boolean allAreSame() {
		
		for (Entry<Player, List<Card>> player :this.getCardsPlayerMap().entrySet()) {

			Player p = player.getKey();
			List<Card> cards = player.getValue();
			if (checkRule.isAllCardSame(cards)) {
				p.setResult("W");
				return true;
			
			}
			
		}
		
		return false;
	}
	private boolean isSequence() {
		
		for (Entry<Player, List<Card>> player :getCardsPlayerMap().entrySet()) {

			Player p = player.getKey();
			List<Card> cards = player.getValue();
			if (checkRule.isCardInSequence(cards)) {
				p.setResult("W");
				return true;
			
			}
			
		}
		
		return false;
	}
	
	private boolean isTwoCardSame() {
		
		for (Entry<Player, List<Card>> player :this.getCardsPlayerMap().entrySet()) {
			Player p = player.getKey();
			List<Card> cards = player.getValue();
			if (checkRule.twoCardSame(cards)) {
				p.setResult("W");
				return true;
			
			}
			
		}
		
		return false;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Card> getCards() {
		return cards;
	}

	public Map<Player, List<Card>> getCardsPlayerMap() {
		return cardsPlayerMap;
	}

	public int getNumberOfCardsPerPlayer() {
		return numberOfCardsPerPlayer;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

}
