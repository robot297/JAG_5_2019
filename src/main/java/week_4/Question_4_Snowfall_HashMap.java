package week_4;

import java.util.HashMap;

import static input.InputUtils.*;

/**
 *
 Extend this program to:

 *	Ask user for a month, and snowfall amount, and add this data to HashMap
 *	Check if month is already in HashMap before adding data.
        If so, warn user that they will overwrite data, and ask for confirmation before writing.

 *  For month names, assume that all month names will be the full name, with the
 *  initial letter capitalized, and will always be spelled the same, example "May" or "September"
 
 *  Optional: add input validation if you like.
 
 *	Identify the month with the most snowfall
 *	Add up all of the snowfall amounts and display the total

 */

public class Question_4_Snowfall_HashMap {

    // Global HashMap, your methods will read and modify this.
    HashMap<String, Double> snowfall = new HashMap<String, Double>();


    public static void main(String[] args) {
        new Question_4_Snowfall_HashMap().snow();
    }


    public void snow() {

        // Add some example data

        snowfall.put("January", 3.7);
        snowfall.put("February", 10.2);
        snowfall.put("March", 6.5);
        snowfall.put("April", 0.1);
        snowfall.put("May", 0.0);
        
        
        getNewMonthData();

        String monthWithMostSnow = maxSnow();
        System.out.println("The month with most snow was " + monthWithMostSnow);

        double totalSnow = totalSnow();
        System.out.println("The total snow was " + totalSnow);

        System.out.println("All of the data: ");
        
        for (String month : snowfall.keySet()) {
            System.out.println("Month: " + month + ", Snowfall (inches): " + snowfall.get(month));
        }


    }
    
    
    // You don't need to modify this method.
    public void getNewMonthData() {
        String month = stringInput("Enter month name");
        double snow = doubleInput("Enter amount of snow");
        addToHashMap(month, snow);
    }


    public void addToHashMap(String month, double snow) {

        // TODO finish this method

        // Check if data is in HashMap
        if (monthInHashMap(month)) {

            // If so, confirm if user wants to overwrite it
            if (yesNoInput("Do you want to overwrite your data?")) {
                // TODO what should happen here?

            } else {
                // TODO what should happen here?
            }
        }

        else {
            // TODO what should happen here?
        }
    }

    public boolean monthInHashMap(String month) {

        //TODO check if month is already a key in the in HashMap.
        return false;  // replace with your code
    }


    public double totalSnow() {
        // TODO add up the snow in the HashMap, and return the total.
        return 0;  // replace with your code
    }


    public String maxSnow() {
        // TODO figure out the month with the most snow, and return that month's name.

        return null; // replace with your code
    }


}
