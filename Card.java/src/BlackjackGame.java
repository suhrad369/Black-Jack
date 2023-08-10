import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int playerScore = 0;
            int dealerScore = 0;

            while (true) {
                System.out.println("\n--- New Round ---");

                Deck deck = new Deck();
                Hand playerHand = new Hand();
                Hand dealerHand = new Hand();

                // Deal initial cards
                playerHand.addCard(deck.drawCard());
                dealerHand.addCard(deck.drawCard());
                playerHand.addCard(deck.drawCard());
                dealerHand.addCard(deck.drawCard());

                // Show initial hands
                System.out.println("Your hand:");
                playerHand.showHand();
                System.out.println("\nDealer's hand:");
                dealerHand.showHand();

                // Player's turn
                while (playerHand.getHandValue() < 21) {
                    System.out.print("Do you want to hit (H) or stand (S)? ");
                    String choice = scanner.next().toUpperCase();

                    if (choice.equals("H")) {
                        playerHand.addCard(deck.drawCard());
                        System.out.println("Your hand:");
                        playerHand.showHand();
                    } else if (choice.equals("S")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                }

                // Dealer's turn
                while (dealerHand.getHandValue() < 17) {
                    dealerHand.addCard(deck.drawCard());
                }
                System.out.println("\nDealer's hand:");
                dealerHand.showHand();

                // Determine the winner
                int playerValue = playerHand.getHandValue();
                int dealerValue = dealerHand.getHandValue();

                if (playerValue > 21 || (dealerValue <= 21 && dealerValue > playerValue)) {
                    System.out.println("\nDealer wins!");
                    dealerScore++;
                } else if (dealerValue > 21 || playerValue > dealerValue) {
                    System.out.println("\nYou win!");
                    playerScore++;
                } else {
                    System.out.println("\nIt's a tie!");
                }

                System.out.println("\n--- Scores ---");
                System.out.println("Your Score: " + playerScore);
                System.out.println("Dealer's Score: " + dealerScore);

                // Ask the player to play again
                System.out.print("Do you want to play again? (Y/N) ");
                String playAgain = scanner.next().toUpperCase();
                if (!playAgain.equals("Y")) {
                    break;
                }
            }
        }
    }
}
