package week_4;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static input.InputUtils.*;

/**
 *

 A first prototype of a program that plays a simplified version of the children's card
 game Go Fish against you.  This version is based from the rules given at

 https://en.wikipedia.org/wiki/Go_Fish

 "Seven cards are dealt from a standard 52-card deck to each player.
 The remaining cards are spread out in a disorderly pile referred to as the "pool".
 The player whose turn it is to play asks another player for his or her cards of a
 particular face value. For example Alice may ask, "Bob, do you have any threes?"
 Alice must have at least one card of the rank she requested. Bob must hand
 over all cards of that rank if possible. If he has none, Bob tells Alice to "go fish"
 and Alice draws a card from the pool and places it in her own hand.

 Then it is the next player's turn – unless the card Alice drew is the card she asked for,
 in which case she shows it to the other players, and she gets another turn. When any player at
 any time has all four cards of one face value, it forms a book, and the cards must be placed
 face up in front of that player.

 Play proceeds to the left. When all sets of cards have been laid down in books, the game ends.
 The player with the most books wins."


 Your tasks: finish the incomplete methods. Run and test the program. Also run the unit tests.
 You might want to add some extra System.out.println() statements to update the player on the status of the game.
 */

public class Question_6_Go_Fish {

    static ArrayList<String> pool;

    // Uses a Google Guava utility method to create an ArrayList from a set of values.
    static final ArrayList<String> cardValues = newArrayList( "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" );

    // List of player's cards, list of computer's cards
    static ArrayList<String> playerHand, computerHand;

    // List of values that the player and computer have books of. For example,
    // if the player has made a book of 6s and a book of Qs, then playerBooks = [ "6", "Q" ]
    static ArrayList<String> playerBooks, computerBooks;

    // Players' names
    final static String HUMAN = "Human";
    final static String COMPUTER = "Computer";

    public static void main(String[] args) {

        // Create a deck of cards,
        ArrayList<String> deck = createDeck();

        // Deal cards to two players
        playerHand = dealHand(deck);
        computerHand = dealHand(deck);

        // Empty lists for storing books made
        playerBooks = new ArrayList<>();
        computerBooks = new ArrayList<>();

        // Set up the pool
        pool = createPool(deck);

        // Play game - players take turns to play
        while (!gameOver()) {
            playerTurn();
            computerTurn();
        }

        // Game is over, identify the winner and display message.
        System.out.println("The winner is " + identifyWinner());
        printGameStats();

    }



    /** Methods to set up game */

    public static ArrayList<String> createDeck() {
        // TODO create an array with 52 strings, each representing a card value in a standard deck.
        // Your strings can be "A" "2", "3", "4" ... since suits don't matter in this game.
        // Use the static cardValues ArrayList.
        // Shuffle the deck.
        return null;
    }


    public static ArrayList<String> createPool(ArrayList<String> deck) {
        // TODO copy all remaining cards from deck to pool
        return null;
    }


    public static ArrayList<String> dealHand(ArrayList<String> deck) {
        // TODO create a new ArrayList to represent a hand of cards.
        // Deal from the *start* of the ArrayList.
        // TODO how should you handle with running out of cards to deal?
        // deal seven cards from the deck - remove from deck, add to the hand.
        return null;
    }



    /** Game play methods */

    public static void playerTurn() {

        // human plays turn.

        // Ask computer for a card.
        // If computer does not have this card, human goes fishing

        // If computer does have card, take all cards of this values from computer
        // and add to hand. Player gets another go.

        // TODO add some messages for the user so they know what's happening.

        while (true) {

            // Show the player their current cards
            displayHand(playerHand);

            // What card does the human want to request from the computer?
            String cardRequested = cardValueInput();

            if (handHasCard(computerHand, cardRequested)) {
                transfer(cardRequested, computerHand, playerHand);
                makeBooks(playerHand, playerBooks);

            } else {
                goFish(playerHand);
                makeBooks(playerHand, playerBooks);
                return;   // end turn
            }
        }
    }


    public static void computerTurn() {

        // Similar to playerTurn, but calls a different method for computer to select their card.

        // TODO add some messages for the user so they know it's the computer's turn, and which card the computer requests etc..

        while (true) {
            // Select card value to request from player
            String cardRequested = selectComputerCardValue();

            // Request this card from human player
            if (handHasCard(playerHand, cardRequested)) {
                transfer(cardRequested, playerHand, computerHand);
                makeBooks(computerHand, computerBooks);

            } else {
                goFish(computerHand);
                makeBooks(computerHand, computerBooks);
                return;   // end turn
            }
        }
    }



    /** Helper methods to break down game logic into discreet steps  */


    public static String selectComputerCardValue() {
        // TODO Select a valid card value from computerHand. A basic computer
        // strategy could be to select a card at random, or to request the value of the first card in their hand.
        return null;
    }


    public static void goFish(ArrayList<String> hand) {
        //TODO remove card from pool and add to this hand.
        // The cards should be shuffled.
        // you can take the first card from the pool and add it to the end of the hand.
        //TODO test that the pool is not empty. If pool is empty, don't modify hand or pool.
    }


    public static boolean handHasCard(ArrayList<String> hand, String cardRequested) {
        // TODO Check if any cards of this value are present in the hand. Return true if so.
        return false;
    }


    public static void transfer(String card, ArrayList<String> fromHand, ArrayList<String> toHand) {
        // TODO transfer all cards of the given value from one hand to the other.
        // example: if card = "5" then remove all "5" from fromHand and add them to toHand.

    }


    public static void makeBooks(ArrayList<String> hand, ArrayList<String> books) {

        // TODO make books for this hand. Remove cards from the hand, and add one entry to the books list.
        // example: hand has 4 "6" values in, so a book of 6s. Remove all "6" from hand, and add one "6" to books.
        // example: hand starts as ["6","6","6","2","6","7"], books starts as ["4", "Q"]
        // After transfer, hand = ["2","7"] and books = ["4","Q","6"]

    }


    public static boolean gameOver() {
        // TODO test if the pool is empty.
        return false;

    }



    public static String identifyWinner() {
        // TODO return "Computer" if computer wins, return "Human" if human player wins. Use the global static player name Strings.
        // Count the number of books each player has made, the player with the most books is the winner.
        return null;
    }




    /** Input and output methods */

    public static void displayHand(ArrayList<String> hand) {
        // TODO Display all of the cards in this hand.
    }


    /** Ask player for a card. Checks to see if the value is a valid value for a card, in the range A, 2, 3 .... J , Q , K
     * Also checks to see if the player does already have a card of that value in their hand. Players can only request
     * cards that they already have one of that value in their hand.
     */
    public static String cardValueInput() {

        while (true) {
            String card = stringInput("Enter the card value to request").toUpperCase();

            // Is this a valid value A - K ?
            if (!cardValues.contains(card)) {
                System.out.println("Enter a valid card value.");
                continue;
            }

            // If this a value that the human player has in their hand? No cheating!
            if (!handHasCard(playerHand, card)){
                System.out.println("You don't have a " + card + " in your hand. Try again.");
                continue;
            }

            return card;
        }
    }

    public static void printGameStats() {

        // TODO Display if human or computer wins by examining computerBooks and playerBooks. - who has the most books?
        // Display list of books each player has, and the total number of books.

    }


}
