package week_4;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Question_3_Recycling_Truck_ArraysTest {

    @Test
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
        assertArrayEquals(crateInput, recycling);

        //And reset the System.in input stream when done
        System.setIn(System.in);

    }

    @Test
    public void testCalculateTotal() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();

        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Totals 12
        assertEquals(12, q3.calculateTotal(testHouseCrates));

    }

    @Test
    public void testCalculateMax() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();

        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Max is 5
        assertEquals(5, q3.calculateMax(testHouseCrates));

        int[] testHouseCrates2 = { 4, 6, 0, 1, 6 } ;  // Joint equal max
        assertEquals(6, q3.calculateMax(testHouseCrates2));

        int[] testHouseCrates3 = { 0, 0, 0, 0, 0 } ;  // All zeros
        assertEquals(0, q3.calculateMax(testHouseCrates3));

    }

    @Test
    public void testCalculateMin() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();


        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Min is 0
        assertEquals(0, q3.calculateMin(testHouseCrates));

        int[] testHouseCrates2 = { 4, 6, 2, 3, 2 } ;  // Joint equal min
        assertEquals(2, q3.calculateMin(testHouseCrates2));

        int[] testHouseCrates3 = { 0, 0, 0, 0, 0 } ;  // All zeros
        assertEquals(0, q3.calculateMin(testHouseCrates3));

    }


    @Test
    public void testCalculateHouseWithMostRecycling() {

        Question_3_Recycling_Truck_Arrays q3 = new Question_3_Recycling_Truck_Arrays();


        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // House with max is house 4
        assertEquals(4, q3.calculateHouseWithMostRecycling(testHouseCrates));

        int[] testHouseCrates2 = { 4, 2, 10, 1, 5} ;  // House with max is house 2
        assertEquals(2, q3.calculateHouseWithMostRecycling(testHouseCrates2));

        int[] testHouseCrates3 = { 4, 7, 0, 7, 5} ;  // 1 and 3 are both max, can pick either

        int calcMaxHouse = q3.calculateHouseWithMostRecycling(testHouseCrates3);

        assertTrue(calcMaxHouse == 1 || calcMaxHouse == 3);


    }
}