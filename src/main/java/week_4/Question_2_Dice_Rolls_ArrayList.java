package week_4;

import input.InputUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import static input.InputUtils.positiveIntInput;
import static input.InputUtils.yesNoInput;

/**

 Write a program to roll a set of dice. Generate a random number between 1 and 6 for
 each dice to be rolled, and save the values in an ArrayList.

 Display the total of all the dice rolled.

 In some games, rolling the same number on all dice has a special meaning.
 In your program, check if all dice have the same value, and print a message
 if all the dice show the same value.  In other words, you'll need a method that
 tests if all of the values in an ArrayList are the same.
 */

public class Question_2_Dice_Rolls_ArrayList {
    
    public final String SAME_VALUES = "All the dice have the same value!";
    
    Random rnd = new Random();   // Use this Random number generator in your code.
    
    public static void main(String[] args) {
        Question_2_Dice_Rolls_ArrayList dice = new Question_2_Dice_Rolls_ArrayList();
        dice.rollDice();
    }
    
    
    public void rollDice() {
    
        // How many dice to roll?
        int numberOfDice = positiveIntInput("How many dice would you like to roll?");
    
        // A do loop is similar to a while loop, but the condition is
        // checked at the end of one loop iteration.
        // So the set of dice are always rolled at least one time.
        
        do {
            
            // Roll the dice
            ArrayList<Integer> diceValues = roll(numberOfDice);
            
            // Print the dice values rolled
            System.out.println("The dice have the values: " + diceValues);
            System.out.println("The total of all dice: " + diceTotal(diceValues));
          
            if (allSameValue(diceValues)) {
                System.out.println(SAME_VALUES);
            }
            
        } while (yesNoInput("Do you want to roll again?"));
    }
    


    public ArrayList<Integer> roll(int numberOfDice) {

        // TODO Roll the given number of dice. Store the values in an ArrayList and return it.
        // Use the global Random rnd to generate random numbers

       return null;  // Replace with your code
    }


    public int diceTotal(ArrayList<Integer> diceValues) {

        // TODO add up all of the values in the ArrayList and return this total.
        // TODO this should still work for any number of dice in the diceValues ArrayList.
        // TODO if the diceValues ArrayList is empty or null, return 0 (zero). Hint: test if the ArrayList is null first

        return 0;  // Replace with your code.
        
    }


    public boolean allSameValue(ArrayList<Integer> diceValues) {

        // TODO return true if all of the values in the diceValues ArrayList are the same.
        // TODO return false for an empty or null ArrayList.
        // TODO this method should work for 0 dice, 1 dice, 2 dice, 3 dice, 100 dice...
        // TODO if the diceValues ArrayList is empty or null, return false.

       return false; // Replace with your code

    }
    
    
}
