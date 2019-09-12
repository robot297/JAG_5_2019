package week_4;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Paint color hashmap - keys are room names, values are the color to paint that room.
 *
 * In this program, practice adding data to a HashMap
 * Analyzing values in a HashMap
 */

public class Question_1_Paint_Colors {
    
    public static void main(String[] args) {
        
        Map<String, String> paintColors = new HashMap<>();
        paintColors.put("Kitchen", "Light Blue");
        paintColors.put("Dining Room", "Yellow");
        paintColors.put("Living Room", "Yellow");
        paintColors.put("Bedroom 1", "Purple");
        paintColors.put("Bedroom 2", "Green");
        
        // TODO add another key-value pair to your map. "Bedroom 3" will be painted "Yellow".
    
        // Should print "Kitchen color: Light Blue"
        System.out.println("Kitchen color: " + getKitchenColor(paintColors));
    
        // Should print "Number of rooms to be painted yellow: 3"
        System.out.println("Number of rooms to be painted yellow: " + howManyYellowRooms(paintColors));

     }
    
    
    public static String getKitchenColor(Map<String, String> paintColors) {
        // TODO return the value for the key "Kitchen" in the paintColors map
        
        return null;    // TODO delete and replace with your code
    }
    
    public static int howManyYellowRooms(Map<String, String> paintColors) {
    
        // TODO count how many values are the String "Yellow" and return this number.
        
        return -1;    // TODO delete and replace with your code
    }
    
    
    
}
