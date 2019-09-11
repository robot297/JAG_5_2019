package week_4;

import static input.InputUtils.*;

/**
 *
 You are a runner, and you are in training for a race. You'd like to keep track of all of your
 times for your training runs. You only like to run around lakes. Here's some example data.
 
 For this program, we'll assume that these are decimal values of minutes, not minutes and seconds,
 and the math will be more straightforward.
 
 
 Cedar, 45.15
 Cedar, 43.32
 Harriet, 49.34
 Harriet, 44.43
 Harriet, 46.22
 Como, 32.11
 Como, 28.14

 Write a program that enables you to enter the names of lakes and times, and store it all of this
 data in data structure(s).
 
 Your data structure should save EVERY time entered for each lake.

 Don't store it in individual variables. Your program should still work if you started running
 around another lake too (e.g. Lake of the Isles, or Lake Phalen).

 Your program should be able to analyze the data that you have stored.
 
 You should be able to print your fastest time for each lake you ran around.
 So, for the data above, your program will calculate something like

 Cedar, 43.32
 Harriet, 44.43
 Como, 28.14

 You should also be able to calculate the average time. So, for the same data as above,
 your program will calculate something like this (you may truncate, or round numbers to 2 decimal places)
 Again, we'll assume that these are decimal values of minutes, so you can figure out the regular average of the numbers.
 
 Cedar, 44.23
 Harriet, 46.66
 Como, 30.12
 
 Your program should be case-insensitive. So "Como" is the same lake as "como" or "COMO".

 
 Print all of the the data - Lake Name, Average, and Fastest Time, in a table.

 The tests don't know what type of data structure you'll use, so they can't test this program very easily.
 So, the way the tests work is to add data, and then try to calculate the fastest time and see if everything seems
 to be working. So, *none of the tests will pass until you've finished the testFastestTimeForLake method*.

 Your program should use the generic types of data structures.
 You should use methods to organize your program.
 Hint: you may need to combine more than one type of data structure.
 
 

 */
public class Question_5_Lake_Running {

    // TODO create a global data structure to store all of your lakes and times here.
    // You methods will read and write to this data structure.


    public static void main(String[] args) {
        new Question_5_Lake_Running().getRunData();
    }

    public void getRunData() {

        while (yesNoInput("More data to add?"))  {
            String name = stringInput("Enter lake name");
            double time = positiveDoubleInput("Enter time for running lake " + name);
            addLake(name, time);
        }
    
        printReportForAllLakes();

    }
    
    


    public double fastestTimeForLake(String lakeName) {
        // TODO read data from your data structure, and find the fastest time for the lake of this name.

        // Your lake name should not be case sensitive. "Como" is the same as "como".

        // If the lake is not in your data structure, return -1 to indicate it was not found.

        return 0; // replace with your code

    }
    
    
    public double averageTimeForLake(String lakeName) {
        // TODO read data from your data structure, and find the average time for the lake of this name.
        
        // Your lake name should not be case sensitive. "Como" is the same as "como".
        
        // If the lake is not in your data structure, return -1 to indicate it was not found.
        
        return 0; // replace with your code
        
    }
    
    
    
    public void addLake(String name, double time) {
        // TODO Add the data for this lake to your data structure
        // Your lake name should not be case sensitive. "Como" is the same as "como".
    }

    
    public void printReportForAllLakes() {
    
    }
    
}
