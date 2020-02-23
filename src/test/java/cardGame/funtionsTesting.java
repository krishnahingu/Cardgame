package cardGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import DATATYPE.Card;
import DATATYPE.CardNumber;
import DATATYPE.CardType;
import DATATYPE.Player;

@DisplayName("funtionsTesting of Rules")
public class funtionsTesting {
	
	
	@Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class twoCardSame {
		
		@Test
		@DisplayName("check 4 card 5,5,3,2 ")
		void test1() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.FIVE,CardType.CLUB));
			card.add(new Card(CardNumber.FIVE,CardType.SPADE));
			card.add(new Card(CardNumber.THREE,CardType.HEARTS));
			card.add(new Card(CardNumber.FOUR,CardType.DIAMOND));
			assertEquals(true,checkRule.twoCardSame(card));
		}
		
		@Test
		@DisplayName("check 4 card 1,3,2,1 ")
		void test2() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.TWO,CardType.SPADE));
			card.add(new Card(CardNumber.THREE,CardType.HEARTS));
			card.add(new Card(CardNumber.ACE,CardType.DIAMOND));
			assertEquals(true,checkRule.twoCardSame(card));
		}
		
		@Test
		@DisplayName("check 4 card 1,13,13,1 ")
		void test3() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.KING,CardType.SPADE));
			card.add(new Card(CardNumber.KING,CardType.HEARTS));
			card.add(new Card(CardNumber.ACE,CardType.DIAMOND));
			assertEquals(true,checkRule.twoCardSame(card));
		}
		
		@Test
		@DisplayName("check 4 card 1,8,12,11 ")
		void test4() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.EIGHT,CardType.SPADE));
			card.add(new Card(CardNumber.QUEEN,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(false,checkRule.twoCardSame(card));
		}
		
		
		@Test
		@DisplayName("check 3 card 11,12,11 ")
		void test5() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.JACK,CardType.CLUB));
			card.add(new Card(CardNumber.QUEEN,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(true,checkRule.twoCardSame(card));
		}
		@Test
		@DisplayName("check 3 card 5,5,11 ")
		void test6() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.FIVE,CardType.CLUB));
			card.add(new Card(CardNumber.FIVE,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(true,checkRule.twoCardSame(card));
		}
		@Test
		@DisplayName("check 3 card 8,5,11 ")
		void test7() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.EIGHT,CardType.CLUB));
			card.add(new Card(CardNumber.FIVE,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(false,checkRule.twoCardSame(card));
		}
		
		
    }
	
	
	
	@Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class checkCardSequence {
		
		@Test
		@DisplayName("check 4 card 5,4,3,2 ")
		void test1() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.FIVE,CardType.CLUB));
			card.add(new Card(CardNumber.TWO,CardType.SPADE));
			card.add(new Card(CardNumber.THREE,CardType.HEARTS));
			card.add(new Card(CardNumber.FOUR,CardType.DIAMOND));
			assertEquals(true,checkRule.isCardInSequence(card));
		}
		
		@Test
		@DisplayName("check 4 card 4,3,2,1 ")
		void test2() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.TWO,CardType.SPADE));
			card.add(new Card(CardNumber.THREE,CardType.HEARTS));
			card.add(new Card(CardNumber.FOUR,CardType.DIAMOND));
			assertEquals(true,checkRule.isCardInSequence(card));
		}
		
		@Test
		@DisplayName("check 4 card 1,13,12,11 ")
		void test3() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.KING,CardType.SPADE));
			card.add(new Card(CardNumber.QUEEN,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(true,checkRule.isCardInSequence(card));
		}
		
		@Test
		@DisplayName("check 4 card 1,1,12,11 ")
		void test4() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.ACE,CardType.SPADE));
			card.add(new Card(CardNumber.QUEEN,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(false,checkRule.isCardInSequence(card));
		}
		
		
		@Test
		@DisplayName("check 3 card 1,12,11 ")
		void test5() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.QUEEN,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(false,checkRule.isCardInSequence(card));
		}
		@Test
		@DisplayName("check 3 card 13,11,11 ")
		void test6() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.KING,CardType.CLUB));
			card.add(new Card(CardNumber.JACK,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(false,checkRule.isCardInSequence(card));
		}
		@Test
		@DisplayName("check 3 card 13,12,11 ")
		void test7() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.KING,CardType.CLUB));
			card.add(new Card(CardNumber.QUEEN,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.DIAMOND));
			assertEquals(true,checkRule.isCardInSequence(card));
		}
		@Test
		@DisplayName("check 3 card 5,6,7 ")
		void test8() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.FIVE,CardType.CLUB));
			card.add(new Card(CardNumber.SEVEN,CardType.HEARTS));
			card.add(new Card(CardNumber.SIX,CardType.DIAMOND));
			assertEquals(true,checkRule.isCardInSequence(card));
		}
		
    }
	
	
	@Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class AllCardsSame {

		@Test
		@DisplayName("check 0 card is same")
		void checzeroCardSame() {
			List<Card> card= new ArrayList<Card>();
			checkRule.isAllCardSame(card);
			assertEquals(false,checkRule.isAllCardSame(card));
		}
		
		@Test
		@DisplayName("check 1 card is same")
		void checkOneCardSame() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			checkRule.isAllCardSame(card);
			assertEquals(false,checkRule.isAllCardSame(card));
		}
		
		@Test
		@DisplayName("check 2 card is same")
		void checkTwoCardSame() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.ACE,CardType.SPADE));
			checkRule.isAllCardSame(card);
			assertEquals(true,checkRule.isAllCardSame(card));
		}
		
		@Test
		@DisplayName("check 3 card is same")
		void checkThreeCardSame() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.ACE,CardType.SPADE));
			card.add(new Card(CardNumber.ACE,CardType.HEARTS));
			checkRule.isAllCardSame(card);
			assertEquals(true,checkRule.isAllCardSame(card));
		}

		@Test
		@DisplayName("check 4 card is same")
		void checkFourCardSame() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.ACE,CardType.SPADE));
			card.add(new Card(CardNumber.ACE,CardType.HEARTS));
			card.add(new Card(CardNumber.ACE,CardType.DIAMOND));
			checkRule.isAllCardSame(card);
			assertEquals(true,checkRule.isAllCardSame(card));
		}
		
		
		@Test
		@DisplayName("check 4 card is same out of 6")
		void check4CardOFof6CardSame() {
			List<Card> card= new ArrayList<Card>();
			card.add(new Card(CardNumber.ACE,CardType.CLUB));
			card.add(new Card(CardNumber.ACE,CardType.SPADE));
			card.add(new Card(CardNumber.FIVE,CardType.HEARTS));
			card.add(new Card(CardNumber.ACE,CardType.HEARTS));
			card.add(new Card(CardNumber.JACK,CardType.HEARTS));
			card.add(new Card(CardNumber.ACE,CardType.DIAMOND));
			checkRule.isAllCardSame(card);
			assertEquals(true,checkRule.isAllCardSame(card));
		}
		
    }
	
}
