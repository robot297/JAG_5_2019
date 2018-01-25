package week_4;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Question_3_Recycling_Truck_ArraysTest {

    @Test(timeout=3000)
    public void testGetRecyclingPerHouse() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();

        int[] crateInput = {4, 3, 6, 2};

        String input = "";
        for (Integer i : crateInput) {
            input += i + "\n";
        }

        //input = elements of array separated by \n e.g. {4, 3, 6} becomes  "4\n3\n\6\n"

        //Where does the user input come from? This is a different approach to mocking the InputUtil classes.
        //Can replace the System.in input stream with an input stream of our creation
        //credit to this Stack Overflow http://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[] recycling = q3.getRecyclingPerHouse(crateInput.length);
        assertArrayEquals("Save all of the user input in an array. If there are 3 houses, and the user enters 4, 1, 3, return an array [4, 1, 3]. \nRemember that this method should work with any length of array.", crateInput, recycling);

        //And reset the System.in input stream when done
        System.setIn(System.in);

    }

    @Test(timeout=3000)
    public void testCalculateTotal() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();

        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Totals 12
        assertEquals("Add up the total of all the integers in the array. Example: If the array contains [3, 1, 2] then return 6. \nRemember that this method should work with any length of array.", 12, q3.calculateTotal(testHouseCrates));

    }

    @Test(timeout=3000)
    public void testCalculateMax() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();

        String msg = "Figure out the largest number in the array and return that. Remember that this method should work with any length of array. ";
        
        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Max is 5
        assertEquals(msg + "\n For the array [4, 2, 0, 1, 5], the max is 5. ", 5, q3.calculateMax(testHouseCrates));

        int[] testHouseCrates2 = { 4, 6, 0, 1, 6 } ;  // Joint equal max
        assertEquals(msg + "\n For the array [4, 6, 0, 1, 6], the max is 6. ", 6, q3.calculateMax(testHouseCrates2));

        int[] testHouseCrates3 = { 0, 0, 0, 0, 0 } ;  // All zeros
        assertEquals(msg + "\n For the array [0, 0, 0, 0, 0], the max is 0. ", 0, q3.calculateMax(testHouseCrates3));

    }

    @Test(timeout=3000)
    public void testCalculateMin() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();
    
        String msg = "Figure out the smallest number in the array and return that. Remember that this method should work with any length of array. ";

        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Min is 0
        assertEquals(msg + "\n For the array [4, 2, 0, 1, 5], the min is 0. ", 0, q3.calculateMin(testHouseCrates));

        int[] testHouseCrates2 = { 4, 6, 2, 3, 2 } ;  // Joint equal min
        assertEquals(msg + "\n For the array [4, 6, 2, 3, 2], the min is 2. ", 2, q3.calculateMin(testHouseCrates2));

        int[] testHouseCrates3 = { 0, 0, 0, 0 } ;  // All zeros
        assertEquals(msg + "\n For the array [0, 0, 0, 0], the min is 0. ", 0, q3.calculateMin(testHouseCrates3));

    }


    @Test(timeout=3000)
    public void testCalculateHouseWithMostRecycling() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();


        int[] testHouseCrates = { 2, 4, 0, 1, 5, 3} ;  // House with max is house 4
        assertEquals("For the array [2, 4, 0, 1, 5, 3], the largest value is in element 4. This method should return 4", 4, q3.calculateHouseWithMostRecycling(testHouseCrates));

        int[] testHouseCrates2 = { 4, 2, 10, 1, 5} ;  // House with max is house 2
        assertEquals("For the array [4, 2, 10, 1, 5], the largest value is in element 2. This method should return 2", 2, q3.calculateHouseWithMostRecycling(testHouseCrates2));

        int[] testHouseCrates3 = { 4, 7, 0, 7, 5} ;  // 1 and 3 are both max, can pick either
        int calcMaxHouse = q3.calculateHouseWithMostRecycling(testHouseCrates3);

        assertTrue("For the array [4, 7, 0, 7, 5], the joint largest values are in 1 and 3. Return either 1 or 3", calcMaxHouse == 1 || calcMaxHouse == 3);


    }
}