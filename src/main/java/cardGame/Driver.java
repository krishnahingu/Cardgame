package cardGame;

import java.util.List;

import DATATYPE.Card;
import DATATYPE.CardNumber;



public class Driver {
	
	public static void main(String[] args) {
		
		SetupGame setup = new SetupGame();
		setup.createUser();
		setup.getPlayers().stream().forEach(System.out::println);
		setup.getCards().stream().forEach(System.out::println);
		System.out.println(setup.getCards().size());
		setup.distributeCardToPlayer();
		setup.getCardsPlayerMap().entrySet().stream().forEach(System.out::println);
		System.out.println(setup.getCards().size());
		setup.validateAllRule();
		setup.getCardsPlayerMap().entrySet().stream().forEach(System.out::println);
		//System.out.println(new SetupGame());
		//System.out.println(new SetupGame(2,3));
		
		 for (CardNumber r : CardNumber.values()) {
			 
	           System.out.println((r.getCardOrder()%14==0) );
	        }
		
	}

}
