package week_5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by clara on 2019-09-10.
 */
public class Question_1_Paint_ColorsTest {
    
    static final int TIMEOUT = 3000;
    
    @Test(timeout = TIMEOUT)
    public void testKitchenColor() {
    
        Map<String, String> paintColors = new HashMap<>();
        paintColors.put("Kitchen", "Light Blue");
        paintColors.put("Dining Room", "Yellow");
        paintColors.put("Living Room", "Yellow");
        paintColors.put("Bedroom 1", "Purple");
        paintColors.put("Bedroom 2", "Green");
        
        assertEquals("getKitchenColor should return the value for the key \"Kitchen\"", "Light Blue", Question_1_Paint_Colors.getKitchenColor(paintColors));
        
    }
    
    
    @Test(timeout = TIMEOUT)
    public void testKitchenColorDifferentColorScheme() {
        
        Map<String, String> paintColors = new HashMap<>();
        paintColors.put("Kitchen", "Bright Orange");
        paintColors.put("Dining Room", "Yellow");
        paintColors.put("Living Room", "Yellow");
        paintColors.put("Bedroom 1", "Purple");
        paintColors.put("Bedroom 2", "Green");
        
        assertEquals("getKitchenColor should return the value for the key \"Kitchen\". Make sure you get for the value by key.",
                "Bright Orange", Question_1_Paint_Colors.getKitchenColor(paintColors));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void testCountYellowColor() {
    
        Map<String, String> paintColors = new HashMap<>();
        paintColors.put("Kitchen", "Light Blue");
        paintColors.put("Dining Room", "Yellow");
        paintColors.put("Living Room", "Yellow");
        paintColors.put("Bedroom 1", "Purple");
        paintColors.put("Bedroom 2", "Green");
        paintColors.put("Bedroom 3", "Yellow");
        
        assertEquals("Count the number of values that are equal to \"Yellow\".", 3, Question_1_Paint_Colors.howManyYellowRooms(paintColors));
        
    }
    
    
    @Test(timeout = TIMEOUT)
    public void testCountYellowColorDifferentColorScheme() {
        Map<String, String> paintColors = new HashMap<>();
        paintColors.put("Kitchen", "Yellow");
        paintColors.put("Dining Room", "Yellow");
        paintColors.put("Living Room", "Yellow");
        paintColors.put("Bedroom 1", "Yellow");
        paintColors.put("Bedroom 2", "Yellow");
        paintColors.put("Bedroom 3", "Yellow");
    
        assertEquals("Count the number of values that are equal to \"Yellow\".", 6, Question_1_Paint_Colors.howManyYellowRooms(paintColors));
    
    }
    
    
    
    @Test(timeout = TIMEOUT)
    public void testCountYellowColorAnotherDifferentColorScheme() {
        
        Map<String, String> paintColors = new HashMap<>();
        paintColors.put("Kitchen", "Pink");
        paintColors.put("Dining Room", "Green");
        paintColors.put("Living Room", "Orange");
        paintColors.put("Bedroom 1", "Purple");
        paintColors.put("Bedroom 2", "Red");
        paintColors.put("Bedroom 3", "Blue");
        
        assertEquals("Count the number of values that are equal to \"Yellow\". Return 0 if there are no yellow rooms.",
                0, Question_1_Paint_Colors.howManyYellowRooms(paintColors));
        
    }
    
}