package cardGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map.Entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import DATATYPE.Card;
import DATATYPE.Player;

@DisplayName("Integaraton Testing")

public class TestCardGame {

	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class CardGameSetup {

		SetupGame game  = new SetupGame();
		/*@Test
		@Order(1)
		@DisplayName("Create Player 4 player with 3 card each")
		void createUser() {
			
			assertEquals(true,game.createUser());
			assertEquals(game.getNumberOfPlayers(), game.getPlayers().size());
			//game.getCardsPlayerMap().entrySet().stream().forEach(System.out::println);
		}

		@Test
		@Order(2)
		@DisplayName("Distributed card to player each player equally")
		void distributedCard() {
			
			game.createUser();
			game.getCardsPlayerMap().entrySet().stream().forEach(System.out::println);
			System.out.println(game.getCardsPlayerMap().entrySet());
			for (Entry<Player, List<Card>> player : game.getCardsPlayerMap().entrySet()) {
				assertEquals(game.getNumberOfCardsPerPlayer(),player.getValue().size());
			}
			
		}
		*/
		@Test
		@Order(3)
		@DisplayName("check same number of card ")
		void checkAnySameNumberCard() {
			game.createUser();
			System.out.println(game.getCardsPlayerMap().entrySet());
			game.getCardsPlayerMap().entrySet().stream().forEach(System.out::println);
			game.validateAllRule();
			
		}
		
    }
/*
	@Nested
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class CardNotDistributedEqually {

		SetupGame game  = new SetupGame(10,6);
		@Test
		@Order(1)
		@DisplayName("Create Player 6 player with 10 card each")
		void createUser() {
			
			assertEquals(false,game.createUser());
			assertEquals(game.getNumberOfPlayers(), game.getPlayers().size());
		}

    }
*/
	

	
	
}
