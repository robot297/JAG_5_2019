package week_4;

import org.junit.Test;
import sun.dc.pr.PRError;
import test_utils.PrintUtils;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class Question_5_Lake_RunningTest {
    
    @Test(timeout=3000)
    public void testPrintFastestAndAverageTimeForAllLakes() throws Exception {

        Question_5_Lake_Running q5 = new Question_5_Lake_Running();

        q5.addLake("Como", 5);
        q5.addLake("Como", 8);
        q5.addLake("CoMo", 2);   // average 5
        
        q5.addLake("Harriet", 5);
        q5.addLake("HaRRiet", 17);  // Average 11
        
        q5.addLake("Superior", 45345);
        q5.addLake("Superior", 1121229);  // Average 583287
        
        PrintUtils.catchStandardOut();

        q5.printReportForAllLakes();

        String out = PrintUtils.resetStandardOut();
        out = out.replace("\n", " ").toLowerCase();  // remove newlines
        out = out.replace("\r", "");   // Remove carriage return

        /* Check that lowercased output contains
         como ....5 ..... 3 ...
         harriet ... 11 ..... 5 ...
         superior ... 583287..... 45345
         In any order
        */
        
        String msg = "Ensure you print the lake name, the average time, and the fastest time, for every lake";
    
    
        Pattern como = Pattern.compile(".*como.*5.*2.*", Pattern.CASE_INSENSITIVE);
        assertTrue(msg, como.matcher(out).matches());
    
        Pattern harriet = Pattern.compile(".*harriet.*11.*5.*", Pattern.CASE_INSENSITIVE);
        assertTrue(msg, harriet.matcher(out).matches());
    
        Pattern superior = Pattern.compile(".*superior.*583287.*45345.*", Pattern.CASE_INSENSITIVE);
        assertTrue(msg, superior.matcher(out).matches());
    
        
    }

    @Test(timeout=3000)
    public void testFastestTimeForLake() throws Exception {


        Question_5_Lake_Running q5 = new Question_5_Lake_Running();


        q5.addLake("Lake Como", 5);
        q5.addLake("Lake Como", 6);
        q5.addLake("Lake Como", 3);

        q5.addLake("Harriet", 5);
        q5.addLake("Harriet", 16);


        q5.addLake("Superior", 45345);
        q5.addLake("Superior", 1121226);

        double delta = 0.000001;

        assertEquals("If the times for Lake Como are 5, 6, 3, then 3 should be the fastest. \nThe lake name should not be case sensitive.", 3, q5.fastestTimeForLake("Lake Como"), delta);
        assertEquals("If the times for Lake Como are 5, 6, 3, then 3 should be the fastest. \nThe lake name should not be case sensitive.", 3, q5.fastestTimeForLake("lake como"), delta);

        assertEquals("If the times for Harriet are 5, 16, the fastest should be 5. \nThe lake name should not be case sensitive.", 5, q5.fastestTimeForLake("Harriet"), delta);
        assertEquals("If the times for Harriet are 5, 16, the fastest should be 5. \nThe lake name should not be case sensitive.", 5, q5.fastestTimeForLake("HARrIET"), delta);
    
        assertEquals("If the times for Superior are 45345 and 1121226 then 45345 should be fastest. \nThe lake name should not be case sensitive.", 45345, q5.fastestTimeForLake("SUPERIOR"), delta);
        assertEquals("If the times for Superior are 45345 and 1121226 then 45345 should be fastest. \nThe lake name should not be case sensitive.", 45345, q5.fastestTimeForLake("SuPeRiOr"), delta);
    
        assertEquals("This method should return -1 if a lake is not found", -1, q5.fastestTimeForLake("Not There"), delta);

    }
    
    
    @Test(timeout=3000)
    public void testAverageTimeForLake() throws Exception {
        
        
        Question_5_Lake_Running q5 = new Question_5_Lake_Running();
    
    
        q5.addLake("Como", 5);
        q5.addLake("Como", 8);
        q5.addLake("CoMo", 2);   // average 5
    
        q5.addLake("Harriet", 5);
        q5.addLake("HaRRiet", 17);  // Average 11
    
        q5.addLake("Superior", 45345);
        q5.addLake("Superior", 1121229);  // Average 583287
    
    
        double delta = 0.1;
        
        assertEquals("For times 5, 8, 2, the average should be 5. The lake name should not be case sensitive.", 5, q5.averageTimeForLake("Como"), delta);
        assertEquals("For times 5, 8, 2, the average should be 5. The lake name should not be case sensitive.", 5, q5.averageTimeForLake("coMo"), delta);
        
        assertEquals("For times 5, 17, the average should be 11. The lake name should not be case sensitive.", 11, q5.averageTimeForLake("Harriet"), delta);
        assertEquals("For times 5, 17, the average should be 11. The lake name should not be case sensitive.", 11, q5.averageTimeForLake("HARRiet"), delta);
        
        assertEquals("For times 45345, 1121229, the average should be 583287. The lake name should not be case sensitive.", 583287, q5.averageTimeForLake("Superior"), delta);
        assertEquals("For times 45345, 1121229, the average should be 583287. The lake name should not be case sensitive.", 583287, q5.averageTimeForLake("superior"), delta);
        
        
        assertEquals("This method should return -1 if a lake is not found", -1, q5.fastestTimeForLake("Not There"), delta);
        
    }
    
    
    
    @Test(timeout=3000)
    public void testAddLake() throws Exception {

        Question_5_Lake_Running q5 = new Question_5_Lake_Running();


        q5.addLake("Como", 5);
        q5.addLake("CoMo", 2);
        q5.addLake("COMO", 3);    // Should all be considered the same lake.


        double delta = 0.000001;
        assertEquals(2, q5.fastestTimeForLake("Como"), delta);
        assertEquals(2, q5.fastestTimeForLake("CoMo"), delta);
        assertEquals(2, q5.fastestTimeForLake("cOMO"), delta);
        assertEquals(2, q5.fastestTimeForLake("coMO"), delta);


    }
}