package week_5;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by clara on 2019-09-10.
 */
public class Question_3_Make_HashMap_CountryTest {
    
    static final int TIMEOUT = 3000;
    
    @Test(timeout = TIMEOUT)
    public void testMakeMap() {
        
        String[] exampleKeys = {"A", "B", "C"};
        String[] exampleValues = {"Armadillo", "Bat", "Capybara"};
        
        Map<String, String> expected = Map.of("A", "Armadillo", "B", "Bat", "C", "Capybara");
        
        Map<String, String> actual = Question_3_Make_HashMap_Country.createCountryCodesMap(exampleKeys, exampleValues);
        assertNotNull("Finish the createCountryCodesMap method", actual);
        
        assertEquals("Hashmap should have the same number of key-value pairs, as the length of the array", expected.size(), actual.size());
        
        for (Map.Entry<String, String> entry: expected.entrySet()) {
            assertTrue("Add all of the Strings in the codes array as keys to the Hashmap", actual.containsKey(entry.getKey()) );
            assertEquals("Add all of the String names to the hashmap", expected.get(entry.getKey()), actual.get(entry.getKey()));
        }
    }
    
    @Test(timeout = TIMEOUT)
    public void testSearchMapFound() {
    
        Map<String, String> example = Map.of("A", "Armadillo", "B", "Bat", "C", "Capybara");
    
        String result = Question_3_Make_HashMap_Country.searchCountry("B", example);
        assertEquals("Searching for a country code should return the country name", "Bat", result);
    }
    
    @Test(timeout = TIMEOUT)
    public void testSearchMapNotFound() {
        
        Map<String, String> example = Map.of("A", "Armadillo", "B", "Bat", "C", "Capybara");
        
        String result = Question_3_Make_HashMap_Country.searchCountry("F", example);
        assertEquals("Searching for a country code that is not in the map should return the exact string \"Code not found\".",
                "Code not found", result);
    }
    
    
    
    @Test(timeout = TIMEOUT)
    public void testSearchMapForCountryNotFound() {
        
        Map<String, String> example = Map.of("A", "Armadillo", "B", "Bat", "C", "Capybara");
        
        String result = Question_3_Make_HashMap_Country.searchCountry("Armadillo", example);  // Is a country, but not a code. Should return "Code not found"
        assertEquals("Searching for a country code that is not in the map should return the exact string \"Code not found\". Don't search by country. ",
                "Code not found", result);
    }
    
    
}