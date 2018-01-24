package week_4;

import input.InputUtils;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;   //  Guava utility library

// Mocking libraries for creating a mock InputUtils class, for generating example user input
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.*;


import static test_utils.ArrayListUtils.arrayListEqual;
import static test_utils.ArrayListUtils.arrayListEqual;
import static test_utils.ArrayListUtils.stringArrayListSameElementsAnyOrder;
import static week_4.Question_6_Go_Fish.*;

/** Tests for GoFish.
 * Uses mocks to create mock/pretend methods that provide example user input.
 * http://easymock.org/user-guide.html is a general mocking library
 * https://github.com/powermock/powermock/wiki/MockStatic  needed to mock the static methods in InputUtils
 *
 */


@RunWith(PowerMockRunner.class)
@PrepareForTest({InputUtils.class, Question_6_Go_Fish.class})
public class Question_6_Go_FishTest extends TestCase {
    
    
    public void testCreateDeck() throws Exception {

        ArrayList<String> deck = createDeck();
        assertEquals("The deck should contain 52 cards", 52, deck.size());

        int expectedSize = 52;
        
        // Remove each card value from cardValues, verify that
        // the correct number are removed after each of 4 loops.
        for (int x = 0 ; x <= 4 ; x++) {

            assertEquals("The deck should contain 4 of each card value, e.g. 4 cards of value A, 4 cards of value 2, 4 cards of value 3...", deck.size(), expectedSize);

            for (String v : cardValues) {
                deck.remove(v);
            }
            
            expectedSize -= 13;
        }

        // TODO how to check if deck is shuffled?

    }

    public void testCreatePool() throws Exception {

        ArrayList<String> originalExampleDeck = newArrayList("Q", "J", "4");
        ArrayList<String> exampleDeck = newArrayList("Q", "J", "4");

        createPool(exampleDeck);
        assertTrue("This method move all cards from the deck to the pool.", stringArrayListSameElementsAnyOrder(originalExampleDeck, pool));

    }

    public void testDealHand() throws Exception {

        ArrayList<String> exampleDeck = newArrayList("Q", "J", "4", "5", "3", "2", "4", "Q", "A");

        ArrayList<String> hand = dealHand(exampleDeck);

        // deck should contain ["Q", "A"]
        // hand should be ["Q", "J", "4", "5", "3", "2", "4"]

        ArrayList<String> deckAfterDeal = newArrayList("Q", "A");
        ArrayList<String> handAfterDeal = newArrayList("Q", "J", "4", "5", "3", "2", "4");

        assertTrue("When dealing cards, move cards from the deck to the player's hand. The deck does not contain the expected cards after an example deal.", arrayListEqual(exampleDeck, deckAfterDeal));
        assertTrue("When dealing cards, move cards from the deck to the player's hand. The hand does not contain the expected cards after an example deal.", arrayListEqual(hand, handAfterDeal));

    }
    
    /*

        Example plays covering various scenarios.

         1. Player requests card Opponent does not have. Player fishes.

         2. Player requests card Opponent has. Card is transferred.
               -- Player requests a card Opponent does not have. Player fishes. No book.

         3. Player requests card Opponent has. Card is transferred.
               -- Player requests another card Opponent has, card is transferred
               -- Player requests a card Opponent does have. Player fishes.  No books made.

         4. Opponent does not have card, Player fishes, Player makes book

         5. Opponent does have card, transfer, Player does not make book.
                -- Player requests card Opponent does not have. Player fishes and makes one book
         
         6. Opponent does have card, transfer, Player makes book.
                -- Player requests second card Opponent does not have, Player fishes, does not make book.

         7. Opponent does have card, transfers, Player makes book.
                -- Player requests second card Opponent does not have, Player fishes, makes second book.
        
         8. Opponent does have card, transferred, Player makes book.
                -- Player requests second card opponent has, transferred, no book.
                -- Player requests third card Opponent does not have. Player fishes, makes second book.

         9. Opponent does have card, transferred, Player makes book.
                -- Player requests second card, transferred, makes book.
                -- Player requests third card Opponent does not have. Player fishes, no book.
*/

    public void testTurn_OpponentDoesNotHave_PlayerFishesNoBook_1() throws Exception {
        
        playScenario(new String[]{"A"},         /* Cards player will request */
                "Player requests card opponent doesn't have, and has to fish. Does not make book.",  /* Description of play */
                newArrayList("A", "2", "3"),            /* initial player hand */
                newArrayList("7", "8", "9"),            /* initial opponent hand */
                newArrayList("Q", "A", "3"),            /* initial pool */
                newArrayList(),                         /* initial player books */
                newArrayList(),                         /* initial opponent books */
                newArrayList("A", "2", "3", "Q"),       /* Expected player hand after turn */
                newArrayList("7", "8", "9"),            /* Expected opponent hand after turn */
                newArrayList("A", "3"),                 /* Expected pool after turn */
                newArrayList(),                         /* Expected player books after turn */
                newArrayList()                          /* Expected opponent books after turn */
        );
    }
    
    public void testTurn_OpponentDoesHave_ThenDoesNotHave_PlayerFishesNoBook_2() throws Exception {
        
        playScenario(new String[]{"3", "7"},         /* Cards player will request */
                "Player requests card opponent does have. Card transferred. Player requests card opponent doesn't have, and has to fish. Does not make book.",  /* Description of play */
                newArrayList("A", "2", "3"),            /* initial player hand */
                newArrayList("3", "8", "9"),            /* initial opponent hand */
                newArrayList("A", "2", "3"),            /* initial pool */
                newArrayList(),                         /* initial player books */
                newArrayList(),                         /* initial opponent books */
                newArrayList("A", "2", "3", "3", "A"),       /* Expected player hand after turn */
                newArrayList("8", "9"),            /* Expected opponent hand after turn */
                newArrayList("2", "3"),                 /* Expected pool after turn */
                newArrayList(),                         /* Expected player books after turn */
                newArrayList()                          /* Expected opponent books after turn */
        );
    }
    
    public void testTurn_OpponentDoesHave_ThenDoesHave_ThenDoesNotHave_PlayerFishesNoBook_3() throws Exception {
        
        playScenario(new String[]{"2", "3", "A"},         /* Cards player will request */
                "Player requests card opponent does have. Card transferred. Player requests another card opponent has, card is transferred. Player requests card opponent doesn't have, and has to fish. Does not make book.",  /* Description of play */
                newArrayList("A", "2", "3", "Q"),            /* initial player hand */
                newArrayList("3", "8", "9", "2", "2"),            /* initial opponent hand */
                newArrayList("A", "2", "3"),            /* initial pool */
                newArrayList(),                         /* initial books */
                newArrayList(),                         /* initial opponent books */
                newArrayList("A", "2", "3", "Q", "2", "2", "3", "A"),       /* Expected player hand after turn */
                newArrayList("8", "9"),            /* Expected opponent hand after turn */
                newArrayList("2", "3"),                 /* Expected pool after turn */
                newArrayList(),                         /* Expected player books after turn */
                newArrayList()                          /* Expected opponent books after turn */
        );
    }
    
    public void testTurn_OpponentDoesNotHave_PlayerFishesMakesBook_4() throws Exception {
        
        playScenario(new String[]{"5"},         /* Cards player will request */
                "Player requests a card opponent doesn't have, goes fishing, and makes book.",  /* Description of play */
                newArrayList("A", "2", "3", "2", "2", "Q"),            /* initial player hand */
                newArrayList("8", "9", "4"),            /* initial opponent hand */
                newArrayList("2", "A", "3"),            /* initial pool */
                newArrayList(),                         /* initial books */
                newArrayList(),                         /* initial opponent books */
                newArrayList("A", "3", "Q"),       /* Expected player hand after turn */
                newArrayList("8", "9", "4"),            /* Expected opponent hand after turn */
                newArrayList("2", "3"),                 /* Expected pool after turn */
                newArrayList("2"),                         /* Expected player books after turn */
                newArrayList()                          /* Expected opponent books after turn */
        );
    }
    
    public void testTurn_OpponentDoesHave_ThenDoesNotHave_PlayerFishesMakesBook_5() {
    
        playScenario(new String[]{"7", "A"},         /* Cards player will request */
                "Player requests card opponent does have. Card transferred. Player requests card opponent doesn't have, and has to fish, makes book.",
                newArrayList("A", "Q", "Q", "8", "7", "Q"),  /* initial player hand */
                newArrayList("3", "7", "9"),            /* initial opponent hand */
                newArrayList("Q", "A", "3"),            /* initial pool */
                newArrayList(),                         /* initial player books */
                newArrayList(),                         /* initial opponent books */
                newArrayList("A", "8", "7", "7"),                 /* Expected player hand after turn */
                newArrayList("3", "9"),            /* Expected opponent hand after turn */
                newArrayList("A", "3"), /* Expected pool after turn */
                newArrayList("Q"), /* Expected player books after turn */
                newArrayList() /* Expected computer books after turn */
        );
    
    }
    
    public void testTurn_OpponentDoesHave_MakeBook_ThenDoesNotHave_PlayerFish_NoBook_6() {
    
        playScenario(new String[]{"Q", "A"},         /* Cards player will request */
                "Player requests card opponent does have. Card transferred. Player makes book. Player requests card opponent doesn't have, and has to fish, no book.",
                newArrayList("A", "Q", "Q", "8", "7", "Q"),  /* initial player hand */
                newArrayList("3", "Q", "9"),            /* initial opponent hand */
                newArrayList("9", "A", "3"),            /* initial pool */
                newArrayList(),                         /* initial player books */
                newArrayList(),                         /* initial opponent books */
                newArrayList("A", "8", "7", "9"),                 /* Expected player hand after turn */
                newArrayList("3", "9"),            /* Expected opponent hand after turn */
                newArrayList("A", "3"), /* Expected pool after turn */
                newArrayList("Q"), /* Expected player books after turn */
                newArrayList() /* Expected computer books after turn */
        );
    
    }
    

    public void testTurn_OpponentDoesHave_MakeBook_ThenDoesNotHave_PlayerFish_MakeBook_7() {
//        7. Opponent does have card, transfers, Player makes book.
//        --Player requests second card Opponent does not have, Player fishes, makes second book.
        playScenario(new String[]{"Q", "7"},         /* Cards player will request */
                "Player requests card opponent does have. Card transferred. Player makes book. Player requests card opponent doesn't have, and has to fish, no book.",
                newArrayList("A", "Q", "7", "Q", "7", "7", "Q"),  /* initial player hand */
                newArrayList("3", "Q", "9"),            /* initial opponent hand */
                newArrayList("7", "A", "3"),            /* initial pool */
                newArrayList(),                         /* initial player books */
                newArrayList(),                         /* initial opponent books */
                newArrayList("A"),                 /* Expected player hand after turn */
                newArrayList("3", "9"),            /* Expected opponent hand after turn */
                newArrayList("A", "3"), /* Expected pool after turn */
                newArrayList("Q"), /* Expected player books after turn */
                newArrayList() /* Expected computer books after turn */
        );
    }
    
    
    public void testTurn_OpponentDoesHave_MakeBook_ThenDoesHaveNoBook_PlayerFish_MakeBook_8() {

//         8. Opponent does have card, transferred, Player makes book.
//            -- Player requests second card opponent has, transferred, no book.
//                -- Player requests third card Opponent does not have. Player fishes, makes second book.
    
        fail();
        
    }
    
    public void testTurn_OpponentDoesHave_MakeBook_ThenDoesHaveMakeSecondBook_PlayerFish_NoBook_9() {
    
//        9. Opponent does have card, transferred, Player makes book.
//        -- Player requests second card, transferred, makes book.
//                -- Player requests third card Opponent does not have. Player fishes, no book.
//
        fail();
        
    }
    
    
    
    private void playScenario(String[] inputs, String playDescription, ArrayList<String> startPlayerHand, ArrayList<String> startOpponentHand, ArrayList<String> startPool, ArrayList<String> startBooks, ArrayList<String> startOpponentBooks,
                              ArrayList<String> expectedPlayerHand, ArrayList<String> expectedOpponentHand, ArrayList<String> expectedPool, ArrayList<String> expectedPlayerBooks, ArrayList<String> expectedOpponentBooks) {
        
        
        // Player is the player.
    
        reset(Question_6_Go_Fish.class);
    
        // Set up expected computer card selections
        for (String i : inputs) {
            expect(InputUtils.stringInput(anyString())).andReturn(i);
        }
    
        replay(Question_6_Go_Fish.class);
    
    
        pool = startPool;
        playerHand = startPlayerHand;
        computerHand = startOpponentHand;
        playerBooks = startBooks;
        computerBooks = startOpponentBooks;
        
        playerTurn();
    
        String msg = "Human player is playing. Computer is their opponent. " + playDescription + "\n";
        
        assertTrue(msg + " The player's hand was not as expected.", arrayListEqual(expectedPlayerHand, playerHand, true));
        assertTrue(msg + " The computers's hand was not as expected.", arrayListEqual(expectedOpponentHand, computerHand, true));
        assertTrue(msg + " The pool was not as expected.", arrayListEqual(expectedPool, pool, true));
        assertTrue(msg + " The player's books are not as expected.", arrayListEqual(expectedPlayerBooks, playerBooks, true));
        assertTrue(msg + " The computers's books are not as expected.", arrayListEqual(expectedOpponentBooks, computerBooks, true));
        
        
        // Computer is the player.
    
        mockStaticPartial(Question_6_Go_Fish.class, "selectComputerCardValue");
    
        reset(Question_6_Go_Fish.class);
    
        // Set up expected computer card selections
        for (String i : inputs) {
            expect(Question_6_Go_Fish.selectComputerCardValue()).andReturn(i);
        }
    
        replay(Question_6_Go_Fish.class);
        
        pool = startPool;
        computerHand = startPlayerHand;
        playerHand = startOpponentHand;
        computerBooks = startBooks;
        playerBooks = startOpponentBooks;
        
        
        computerTurn();
    
        msg = "Computer is playing. Human is their opponent. " + playDescription + "\n";
    
        assertTrue(msg + " The computer's hand was not as expected.", arrayListEqual(expectedPlayerHand, playerHand, true));
        assertTrue(msg + " The player's hand was not as expected.", arrayListEqual(expectedOpponentHand, computerHand, true));
        assertTrue(msg + " The pool was not as expected.", arrayListEqual(expectedPool, pool, true));
        assertTrue(msg + " The computer's books are not as expected.", arrayListEqual(expectedPlayerBooks, computerBooks, true));
        assertTrue(msg + " The player's books are not as expected.", arrayListEqual(expectedOpponentBooks, computerBooks, true));
    
    
    
    
    }
    
    
    
    public void testSelectComputerCardValue() throws Exception {


        // This is not a very satisfactory test, since the details of how
        // the computer chooses are not yet implemented. 
        // You'll need to write this test after you implementing your selectComputerCardValue method,
        // TODO to write another test to check the behavior of your solution.

        computerHand = newArrayList("A", "2", "4");

        // Select 100 times, ensure card selected is one from the hand.
        for (int x = 0 ; x < 100 ; x++) {
            String card = selectComputerCardValue();
            assertTrue(computerHand.contains(card));
        }


        fail("Replace this test with one that tests your own selectComputerCardValue method");

    }

    public void testGoFish() throws Exception {

        pool = newArrayList("Q", "J", "3");
        ArrayList<String> poolAfterFish = newArrayList("J", "3");

        ArrayList<String> exampleHand = newArrayList("4", "2", "5");
        ArrayList<String> exampleHandAfterFish = newArrayList("4", "2", "5", "Q");

        goFish(exampleHand);

        assertTrue(arrayListEqual(exampleHand, exampleHandAfterFish));
        assertTrue(arrayListEqual(pool, poolAfterFish));

        // Test with empty pool. Don't modify hand or pool. Should not crash :)

        pool = new ArrayList<String>();
        exampleHand = newArrayList("4", "2", "5");
        exampleHandAfterFish = newArrayList("4", "2", "5");

        goFish(exampleHand);

        assertTrue(arrayListEqual(exampleHand, exampleHandAfterFish));


    }

    public void testHandHasCard() throws Exception {

        ArrayList<String> exampleHand = newArrayList("4", "2", "5");
        assertTrue(handHasCard(exampleHand, "4"));
        assertTrue(handHasCard(exampleHand, "2"));
        assertTrue(handHasCard(exampleHand, "5"));

        assertFalse(handHasCard(exampleHand, "Q"));
        assertFalse(handHasCard(exampleHand, "6"));

    }

    public void testTransfer() throws Exception {

        //Transfer 4

        ArrayList<String> fromHand = newArrayList("4", "2", "2", "5", "2");
        ArrayList<String> expectedFromHandAfter = newArrayList("2", "2", "5", "2");

        ArrayList<String> toHand = newArrayList("J", "Q", "8");
        ArrayList<String> expectedToHandAfter = newArrayList("J", "Q", "8", "4");

        transfer("4", fromHand, toHand);
        assertTrue(arrayListEqual(fromHand, expectedFromHandAfter));
        assertTrue(arrayListEqual(toHand, expectedToHandAfter));



        //Transfer more than one card "2"

        fromHand = newArrayList("4", "2", "2", "5", "2");
        expectedFromHandAfter = newArrayList("4", "5");

        toHand = newArrayList("J", "Q", "8");
        expectedToHandAfter = newArrayList("J", "Q", "8", "2", "2", "2");

        transfer("2", fromHand, toHand);
        assertTrue(arrayListEqual(fromHand, expectedFromHandAfter));
        assertTrue(arrayListEqual(toHand, expectedToHandAfter));



    }

    public void testMakeBooks() throws Exception {

        ArrayList<String> hand = newArrayList("2", "4", "2", "2", "5", "2");
        ArrayList<String> books = new ArrayList<String>();

        ArrayList<String> expectedHand = newArrayList("4", "5");
        ArrayList<String> expectedBooks = newArrayList("2");

        ArrayList<String> expectedHand2 = newArrayList("4", "5");
        ArrayList<String> expectedBooks2 = newArrayList("2");
        
        makeBooks(hand, books);

        assertTrue(arrayListEqual(hand, expectedHand));
        assertTrue(arrayListEqual(books, expectedBooks));

        // No books left to make. Verify nothing changes.
        makeBooks(hand, books);

        assertTrue(arrayListEqual(hand, expectedHand2));
        assertTrue(arrayListEqual(books, expectedBooks2));
        
        // Make more than one book

        ArrayList<String> hand2books = newArrayList("2", "3", "3", "4", "2", "2", "3", "3", "5", "2");
        ArrayList<String> books2books = new ArrayList<String>();

        ArrayList<String> expectedHand2books = newArrayList("4", "5");
        ArrayList<String> expectedBooks2books = newArrayList("2", "3");

        makeBooks(hand2books, books2books);

        assertTrue(arrayListEqual(hand2books, expectedHand2books));
        assertTrue(arrayListEqual(books2books, expectedBooks2books));


    }

    public void testGameOver() throws Exception {
        // pool empty?

        pool = new ArrayList<>();
        assertTrue(gameOver());
    }

    public void testIdentifyWinner() throws Exception {

        computerBooks = newArrayList("A", "2", "4", "7", "9", "K", "Q", "J");
        playerBooks = newArrayList("3", "5", "6", "8", "10");

        assertEquals(COMPUTER, identifyWinner());

        computerBooks = newArrayList("A", "2", "4", "7", "9");
        playerBooks = newArrayList("3", "5", "6", "8", "10" , "K", "Q", "J");

        assertEquals(HUMAN, identifyWinner());

    }

    
    public void testDisplayHand() throws Exception {
        //pass - look at the output and decide if it looks ok.
    }

    
    public void testPrintGameStats() throws Exception {
        //TODO is a test needed? Look at your program output and decide if it looks ok.
    }

    
    public void testCardValueInputValidInput() throws Exception {

        playerHand = newArrayList("A", "2", "4", "7", "9");

        mockStatic(InputUtils.class);
        expect(InputUtils.stringInput(anyString())).andReturn("7");
        replay(InputUtils.class);

        String cardSelection = cardValueInput();

        assertEquals("7", cardSelection);

    }


    public void testCardValueInputInvalidInput() throws Exception {


        playerHand = newArrayList("A", "2", "4", "7", "9");

        mockStatic(InputUtils.class);
        expect(InputUtils.stringInput(anyString()))
                .andReturn("10")     // Not in the hand
                .andReturn("pizza")  // Not a card value
                .andReturn("100")    // Not a card value
                .andReturn("")       // Empty
                .andReturn("7");     // Finish with a valid input

        replay(InputUtils.class);


        String cardSelection = cardValueInput();

        // All of the invalid input should be ignored, and the last, valid, input will be returned.
        assertEquals("7", cardSelection);

    }
    

}