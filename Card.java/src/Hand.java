import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getHandValue() {
        int sum = 0;
        int numAces = 0;

        for (Card card : cards) {
            sum += card.getValue();
            if (card.getValue() == 11) {
                numAces++;
            }
        }

        while (sum > 21 && numAces > 0) {
            sum -= 10;
            numAces--;
        }

        return sum;
    }

    public void showHand() {
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println("Total value: " + getHandValue());
    }
}
