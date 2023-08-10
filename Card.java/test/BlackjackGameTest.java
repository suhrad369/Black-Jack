import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BlackjackGameTest {

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    @Before
    public void setUp() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
    }

    @Test
    public void testPlayerWins() {
        playerHand.addCard(new Card("Hearts", "7", 7));
        dealerHand.addCard(new Card("Spades", "6", 6));

        int playerScore = playerHand.getHandValue();
        int dealerScore = dealerHand.getHandValue();

        assertTrue(playerScore > dealerScore);
    }

    @Test
    public void testDealerWins() {
        playerHand.addCard(new Card("Hearts", "10", 10));
        dealerHand.addCard(new Card("Spades", "Ace", 11));
        dealerHand.addCard(new Card("Clubs", "5", 5));

        int playerScore = playerHand.getHandValue();
        int dealerScore = dealerHand.getHandValue();

        assertTrue(dealerScore > playerScore);
    }

    @Test
    public void testTie() {
        playerHand.addCard(new Card("Hearts", "7", 7));
        dealerHand.addCard(new Card("Spades", "7", 7));

        int playerScore = playerHand.getHandValue();
        int dealerScore = dealerHand.getHandValue();

        assertEquals(playerScore, dealerScore);
    }

    @Test
    public void testPlayerBusts() {
        playerHand.addCard(new Card("Hearts", "Queen", 10));
        playerHand.addCard(new Card("Spades", "King", 10));
        playerHand.addCard(new Card("Diamonds", "3", 3));

        int playerScore = playerHand.getHandValue();

        assertTrue(playerScore > 21);
    }

    @Test
    public void testBlackjack() {
        playerHand.addCard(new Card("Hearts", "Ace", 11));
        playerHand.addCard(new Card("Spades", "10", 10));

        int playerScore = playerHand.getHandValue();

        assertEquals(21, playerScore);
    }

    @Test
    public void testPlayerWinsWithBlackjack() {
        playerHand.addCard(new Card("Hearts", "Ace", 11));
        playerHand.addCard(new Card("Spades", "King", 10));
        dealerHand.addCard(new Card("Diamonds", "8", 8));

        int playerScore = playerHand.getHandValue();
        int dealerScore = dealerHand.getHandValue();

        assertTrue(playerScore == 21 && dealerScore < playerScore);
    }

    // Add more test methods for different scenarios

}
