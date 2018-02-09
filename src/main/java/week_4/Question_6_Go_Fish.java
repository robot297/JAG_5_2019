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
 over all cards of that rank if possible.
 
 Alice may then request another card from Bob.
 
 If he has none, Bob tells Alice to "go fish" and Alice draws a card from the pool and places it in her own hand.

 Then it is the next player's turn – unless the card Alice drew from the pool is the card she asked for,
 in which case she shows it to the other players, and she gets another turn. When any player at
 any time has all four cards of one face value, it forms a book, and the cards must be placed
 face up in front of that player.

 Play proceeds to the left. When all sets of cards have been laid down in books, the game ends.
 The player with the most books wins."


 Your tasks: finish the incomplete methods. Run and test the program. Also run the unit tests.
 You might want to add some extra System.out.println() statements to update the player on the status of the game.
 
 
 Optional extra challenge: Write your own test to check the behavior of your selectComputerCardValue method.
 
 Known bug: if the computer runs out of cards during the game, it will crash. Disregard this error.
 
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
        createPool(deck);

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
        // TODO create an ArrayList with 52 strings, each representing a card value in a standard deck.
        // Your strings should be "A" "2", "3", "4" ... since suits don't matter in this game.
        // There will be 4 "A" and 4 "2" and 4 "3" ....
        // You may use the static cardValues ArrayList, which has a list of the card values.
        
        // TODO Shuffle the deck.
        return null;
    }


    public static void createPool(ArrayList<String> deck) {
        // TODO copy all cards from deck to pool
        // This method should modify the global pool variable. It does not need to return anything.
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
        // and add to hand. Player gets another chance to request cards from computer.

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
        
        // If the computer's hand is empty, return null.
        
        // Optional: write your own test for this method.
        return null;
    }


    public static void goFish(ArrayList<String> hand) {
        //TODO remove card from pool and add to this hand.
        // The cards should already be shuffled.
        // Take the FIRST card from the pool and add it to the end of the hand.
        //TODO test that the pool is not empty. If pool is empty, don't modify hand or pool.
        //This method does not need to return anything.
        // Pass-by-reference means that any modifications made to hand are the same changes made to hand in the calling method.
    }


    public static boolean handHasCard(ArrayList<String> hand, String cardRequested) {
        // TODO Check if any cards of this value are present in the hand. Return true if so.
        // If cardRequested is null, return false.
        return false;
    }


    public static void transfer(String card, ArrayList<String> fromHand, ArrayList<String> toHand) {
        // TODO transfer all cards of the given value from one hand to the other.
        // example: if card = "5" then remove all "5" from fromHand and add them to toHand.
        // example: card = "5" , fromHand = [ 5, 6, 7, 2, 5 ],  toHand = [ 1, 2 ]
        // After transfer, fromHand = [ 6, 7, 2 ], toHand = [ 1, 2, 5, 5 ]
        // You do not need to return anything - just modify the fromHand and toHand.
    }


    public static void makeBooks(ArrayList<String> hand, ArrayList<String> books) {

        // TODO make books for this hand. Remove cards from the hand, and add one entry to the books list.
        // example: hand has 4 "6" values in, so a book of 6s. Remove all "6" from hand, and add one "6" to books.
        // example: hand starts as ["6","6","6","2","6","7"], books starts as ["4", "Q"]
        // After transfer, hand = ["2","7"] and books = ["4","Q","6"]
        
        // Your method should work if there is more than one book in the hand
        // Example: ["6","6","A","6","2","A","6","A","7","A"] and books is ["4", "Q"]
        // Hand should become ["2","7"] and books = ["4","Q","6", "A"]
        
        // You don't need to return anything.
    }


    public static boolean gameOver() {
        // TODO test if the pool is empty. Return true if the pool is empty, false otherwise.
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
        
        // TODO Display a list of books each player has.
        // TODO Display the total number of books for each player.
        
        // TODO display the name of the winning player in this format: "Human is the winner" or "Computer is the winner".
        
        

    }


}
