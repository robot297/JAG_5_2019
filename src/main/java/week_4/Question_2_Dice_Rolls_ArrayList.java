package week_4;

import input.InputUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**

 Write a program to roll a set of dice. Generate a random number between 1 and 6 for
 each dice to be rolled, and save the values in an ArrayList.

 Display the total of all the dice rolled.

 In some games, rolling the same number on all dice has a special meaning.
 In your program, check if all die have the same value, and print a message
 if all dice show the same value.
 */
public class Question_2_Dice_Rolls_ArrayList {
    
    public final String SAME_VALUES = "All the dice have the same value!";

    public int numberOfDice = 2;

    Random rnd = new Random();   // Use this Random number generator in your code.

    
    public static void main(String[] args) {
        Question_2_Dice_Rolls_ArrayList dice = new Question_2_Dice_Rolls_ArrayList();
        dice.rollDice();
    }
    
    public void rollDice() {
        
        while (userWantsToContinue()) {
            
            // Roll the dice
            ArrayList<Integer> diceValues = roll(numberOfDice);
            
            // Print the dice values rolled
            System.out.println("The dice have the values: " + diceValues);
            System.out.println("The total of all dice: " + diceTotal(diceValues));
            if (allSameValue(diceValues)) {
                System.out.println(SAME_VALUES);
            }
        }
    }
    
    public boolean userWantsToContinue() {

        // TODO Ask the user if they want to roll again. Return true if so, return false if not
        // Use the yesNoInput method in InputUtils.

        return false;    // Replace with your code

    }


    public ArrayList<Integer> roll(int numberOfDice) {

        // TODO Roll the given number of dice. Store the values in an ArrayList and return.
        // Use the global Random rnd to generate random numbers

       return null;  // Replace with your code
    }


    public int diceTotal(ArrayList<Integer> diceValues) {

        // TODO add up all of the values in the ArrayList and return this total.
        // TODO this should still work if there are more or less than 2 dice.
        // TODO if the diceValues ArrayList is empty or null, return 0 (zero)

        return 0;  // Replace with your code.
        
    }


    public boolean allSameValue(ArrayList<Integer> diceValues) {

        // TODO return true if all of the values in the diceValues ArrayList are the same.
        // TODO return false for an empty or null ArrayList.
        // TODO this method should work for 1 dice, 2 dice, 3 dice, 100 dice...

       return false; // Replace with your code

    }
    
    
}
