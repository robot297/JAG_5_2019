package week_4;

import static input.InputUtils.*;

/**
 *
 You are a runner, and you are in training for a race. You'd like to keep track of all of your
 times for your training runs. You only like to run around lakes. Here's some example data,
 Cedar, 45.15
 Cedar, 43.32
 Harriet, 49.34
 Harriet, 44.43
 Harriet, 46.22
 Como, 32.11
 Como, 28.14

 Write a program that enables you to enter the names of lakes and times, and store it all of this
 data in data structure(s). You'll need to save every time entered for each lake.

 Don't store it in individual variables. Your program should still work if you started running
 around another lake too (e.g. Lake of the Isles, or Lake Phalen).

 Your program should be able to analyze the data that you have stored, and print your fastest
 time for each lake you ran around. So, for the data above, your program will display something like

 Cedar, 43.32
 Harriet, 44.43
 Como, 32.11

 Your program should be case-insensitive. So "Como" is the same lake as "como" or "COMO".

 Your program should use the generic types of data structures.
 You should use methods to organize your program.
 Hint: you may need to combine more than one type of data structure.

 */
public class Question_5_Lake_Running {

    // TODO create a global data structure to store all of your lakes and times here.
    // You methods will read and write to this data structure.


    public static void main(String[] args) {
        new Question_5_Lake_Running().running();
    }

    public void running() {

        while (moreLakes())  {
            String name = stringInput("Enter lake name");
            double time = doubleInput("Enter time for running lake " + name);
            addLake(name, time);
        }

        printFastestTimeForAllLakes();

    }




    public void printFastestTimeForAllLakes() {
        // TODO read data from your data structure, and print the fastest time for each lake.
        // Your output should look something like this

        // Lake Harriet, 50.12 minutes
        // Como Lake, 45.12 minutes
        // ....
        // Use the fastestTimeForLake method to help.


    }


    public double fastestTimeForLake(String lakeName) {
        // TODO read data from your data structure, and find the fastest time for the lake of this name.

        // Your lake name should not be case sensitive. "Como" is the same as "como".

        // If the lake is not in your data structure, return -1 to indicate it was not found.

        return 0; // replace with your code

    }


    public void addLake(String name, double time) {
        // TODO Add the data for this lake to your data structure
        // Your lake name should not be case sensitive. "Como" is the same as "como".
    }




    // You don't need to modify this method.
    private boolean moreLakes() {
        return yesNoInput("More lake data to add?");
    }


}