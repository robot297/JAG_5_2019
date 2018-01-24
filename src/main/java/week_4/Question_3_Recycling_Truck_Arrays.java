package week_4;

/**
 *
 You work for a recycling company.
 You’d like to collect some statistics on how much each of the
 houses on a certain street is recycling.

 Each house has to use crates for their recycling. Your program will
 count the number of crates set out by each house.

 This street is a little unusual since it only has 8 houses, and the city planner
 must have been a computer programmer, since the house numbers are 0, 1, 2, 3, 4, 5, 6, and 7.

 (Hint – the house numbers are the same as array element indexes.)

 Write a program that asks for the number of recycling crates set out by each house.
 You should store, and process this data, in an array.
 DON'T use an ArrayList or LinkedList!

 Analyse your data and determine:
 •	How many recycling crates, in total, from all the houses on the street?
 •	What is the largest number of crates set out by any house?
 •	What is the smallest number of crates set out by any house?
 •	Which house had the most recycling? Display that house number.

 */
public class Question_3_Recycling_Truck_Arrays {

    public static void main(String[] args) {
        new Question_3_Recycling_Truck_Arrays().recycling();
    }

    public void recycling() {

        int numberOfHouses = 8;

        int[] cratesPerHouse = getRecyclingPerHouse(numberOfHouses);

        int totalCrates = calculateTotal(cratesPerHouse);

        int maxCrates = calculateMax(cratesPerHouse);

        int minCrates = calculateMin(cratesPerHouse);

        int houseWithMostRecycling = calculateHouseWithMostRecycling(cratesPerHouse);

        System.out.println("Total crates from all houses = " + totalCrates);
        System.out.println("Max crates at any house = " + maxCrates);
        System.out.println("Min crates at any house = " + minCrates);
        System.out.println("House with most recycling = " + houseWithMostRecycling);

    }

    // Create a new int[] array. The array should be the same size, as number of houses.
    // Ask user for number of crates for each house. Save in the array.
    // Return this array.
    // This method should work for any number of houses.
    public int[] getRecyclingPerHouse(int houses) {

        // TODO ask user for input.
        return null;  // Replace with your code
    }

    //Add up all of the numbers in the array and return that
    public int calculateTotal(int[] cratesPerHouse) {

        // TODO calculate and return the total.
        return 0;   // Replace with your code
    }

    //Which is the largest number in the array?
    public int calculateMax(int[] cratesPerHouse) {

        // TODO identify the largest number in the array.
        return 0; // Replace with your code
    }

    //Which is the smallest number in the array?
    public int calculateMin(int[] cratesPerHouse) {

        // TODO identify the smallest number
        return 0; // Replace with your code
    }

    //Use the array to figure out which house number - or array element number - has the most recycling
    public int calculateHouseWithMostRecycling(int[] cratesPerHouse) {

        // TODO which house had the most recycling? If more than one house
        // had the max number, return either house number.

        return 0; // Replace with your code
    }
}
