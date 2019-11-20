package week_5;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test_utils.ArrayListUtils;

import static org.junit.Assert.*;

public class Question_2_Lake_QualityTest {
    
    static final int TIMEOUT = 3000;
    
    @Test(timeout = TIMEOUT)
    public void testAddNewLakeClarity() throws Exception {
    
        Map<String, Double> lakeClarities = new HashMap<>();
        lakeClarities.put("Bde Maka Ska", 49.1);
        lakeClarities.put("Harriet", 42.4);
        lakeClarities.put("Nokomis", 37.2);
        
        Question_2_Lake_Quality.updateClarity(lakeClarities, "Como", 50.7);
    
        Map<String, Double> updatedLakeClarities = new HashMap<>();
        updatedLakeClarities.put("Bde Maka Ska", 49.1);
        updatedLakeClarities.put("Harriet", 42.4);
        updatedLakeClarities.put("Nokomis", 37.2);
        updatedLakeClarities.put("Como", 50.7);
        
        assertEquals("Add a new lake to the HashMap. Your hashmap is not the expected size.",
                updatedLakeClarities.size(), lakeClarities.size());
        
        for (Map.Entry<String, Double> entry : updatedLakeClarities.entrySet()) {
            assertTrue("Add the new data to the HashMap. Overwrite if key is already present.", lakeClarities.containsKey(entry.getKey()));
            assertEquals("Add the new data to the HashMap. Overwrite if key is already present.", entry.getValue(), lakeClarities.get(entry.getKey()));
        }

    }
    
    
    @Test(timeout = TIMEOUT)
    public void testEditNewLakeClarity() {
        
        Map<String, Double> lakeClarities = new HashMap<>();
        lakeClarities.put("Bde Maka Ska", 49.1);
        lakeClarities.put("Harriet", 42.4);
        lakeClarities.put("Nokomis", 37.2);
        
        Question_2_Lake_Quality.updateClarity(lakeClarities, "Harriet", 50.7);
        
        Map<String, Double> updatedLakeClarities = new HashMap<>();
        updatedLakeClarities.put("Bde Maka Ska", 49.1);
        updatedLakeClarities.put("Harriet", 50.7);
        updatedLakeClarities.put("Nokomis", 37.2);

        
        assertEquals("Add a new lake to the HashMap. Your hashmap is not the expected size.",
                updatedLakeClarities.size(), lakeClarities.size());
        
        for (Map.Entry<String, Double> entry : updatedLakeClarities.entrySet()) {
            assertTrue("Add the new data to the HashMap. Overwrite if key is already present.", lakeClarities.containsKey(entry.getKey()));
            assertEquals("Add the new data to the HashMap. Overwrite if key is already present.", entry.getValue(), lakeClarities.get(entry.getKey()));
        }
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testAddNewLakeClarityDifferentDataSet()  {
    
        Map<String, Double> lakeClarities = new HashMap<>();
        lakeClarities.put("Hat", 100.0);
        lakeClarities.put("Bird", 200.0);
        lakeClarities.put("Triangle", 300.0);
    
        Question_2_Lake_Quality.updateClarity(lakeClarities, "Moose", 500.0);
    
        Map<String, Double> updatedLakeClarities = new HashMap<>();
        updatedLakeClarities.put("Hat", 100.0);
        updatedLakeClarities.put("Bird", 200.0);
        updatedLakeClarities.put("Triangle", 300.0);
        updatedLakeClarities.put("Moose", 500.0);
        
        assertEquals("Edit an existing lake to the HashMap. Your hashmap is not the expected size.",
                updatedLakeClarities.size(), lakeClarities.size());
        
        for (Map.Entry<String, Double> entry : updatedLakeClarities.entrySet()) {
            assertTrue("Add the new data to the HashMap. Overwrite if key is already present.", lakeClarities.containsKey(entry.getKey()));
            assertEquals("Add the new data to the HashMap. Overwrite if key is already present.", entry.getValue(), lakeClarities.get(entry.getKey()));
        }
    
    }
    
    
    @Test(timeout = TIMEOUT)
    public void testEditNewLakeClarityDifferentDataSet() throws Exception {
        
        Map<String, Double> lakeClarities = new HashMap<>();
        lakeClarities.put("Hat", 100.0);
        lakeClarities.put("Bird", 200.0);
        lakeClarities.put("Triangle", 300.0);
        
        Question_2_Lake_Quality.updateClarity(lakeClarities, "Bird", 500.0);
        
        Map<String, Double> updatedLakeClarities = new HashMap<>();
        updatedLakeClarities.put("Hat", 100.0);
        updatedLakeClarities.put("Bird", 500.0);
        updatedLakeClarities.put("Triangle", 300.0);
        
        assertEquals("Edit an existing lake to the HashMap. Your hashmap is not the expected size.",
                updatedLakeClarities.size(), lakeClarities.size());
        
        for (Map.Entry<String, Double> entry : updatedLakeClarities.entrySet()) {
            assertTrue("Add the new data to the HashMap. Overwrite if key is already present.", lakeClarities.containsKey(entry.getKey()));
            assertEquals("Add the new data to the HashMap. Overwrite if key is already present.", entry.getValue(), lakeClarities.get(entry.getKey()));
        }
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testGetLakesForSwimming48() throws Exception {
    
        Map<String, Double> lakeClarities = new HashMap<>();
        lakeClarities.put("Bde Maka Ska", 49.1);
        lakeClarities.put("Harriet", 42.4);
        lakeClarities.put("Nokomis", 37.2);
        lakeClarities.put("Como", 48.0);
        
        List<String> swimming = Question_2_Lake_Quality.getSwimmingLakes(lakeClarities, 48);
    
        List<String> expectedLakes = List.of("Bde Maka Ska", "Como");
    
        boolean equal = ArrayListUtils.stringListSameElementsAnyOrder(swimming, expectedLakes, true);
        assertTrue("Return a list of all of the lake names with clarity at or above the clarity given.", equal);
        
    }
    
    @Test(timeout = TIMEOUT)
    public void testGetLakesForSwimmingDifferentClarity() throws Exception {
        
        Map<String, Double> lakeClarities = new HashMap<>();
        lakeClarities.put("Hat", 70000.0);
        lakeClarities.put("Bird", 20000.0);
        lakeClarities.put("Triangle", 30000.0);
        lakeClarities.put("Moose", 50000.0);
        
        List<String> swimming = Question_2_Lake_Quality.getSwimmingLakes(lakeClarities, 30000);

        List<String> expectedLakes = List.of("Hat", "Triangle", "Moose");
    
        boolean equal = ArrayListUtils.stringListSameElementsAnyOrder(swimming, expectedLakes, true);
        assertTrue("Return a list of all of the lake names with clarity at or above the clarity given.", equal);
        
    }
    
}