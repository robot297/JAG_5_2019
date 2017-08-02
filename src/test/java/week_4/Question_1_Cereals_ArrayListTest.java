package week_4;

import org.junit.Test;
import test_utils.PrintUtils;

import static org.junit.Assert.*;

public class Question_1_Cereals_ArrayListTest {
    
    @Test
    public void testCereals() throws Exception {

        Question_1_Cereals_ArrayList q1 = new Question_1_Cereals_ArrayList();

        PrintUtils.catchStandardOut();

        q1.cereals();

        String out = PrintUtils.resetStandardOut();
        
        // Test that 'Cornflakes" was added
        assertTrue("Add 'Cornflakes' to the ArrayList", q1.cereals.contains("Cornflakes"));
        // Test that "Oatmeal" was removed
        assertFalse("Remove 'Oatmeal' from the ArrayList", q1.cereals.contains("Oatmeal"));

        
        // And when the favorite breakfast is added, there should be 4 items in the list
        assertEquals("Add your favorite breakfast food to the ArrayList", 4, q1.cereals.size());
        
        // Check that all elements of ArrayList are printed
        for (String c : q1.cereals) {
            assertTrue("Print all of the items in the ArrayList", out.contains(c));
        }
        

        // Is a message confirming "Special K is in the ArrayList" is printed
        assertTrue("Test if Special K is in the array list and print the exact message requested if so", out.toLowerCase().contains("special k is in the arraylist"));

    }
}