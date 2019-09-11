package week_4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static input.InputUtils.*;

/**
 *
 * In Minnesota, we have a lot of lakes. The Minnesota Pollution Control Agency monitors water quality,
 * as part of monitoring Minnesota's environment.
 *
 * One of the measures of lake quality is clarity - how far can you see down into the water?
 * (If you are interested, more info https://www.pca.state.mn.us/water/what-water-clarity-tells-us)
 *
 * Clarity is measured in distance.  A higher distance usually means better water quality.
 *
 * For swimming, going to the beach etc. it's better to have higher water quality.
 * A common recommendation is at least 48 inches for swimming and other water recreation.
 *
 *
 */

public class Question_2_Lake_Quality {
    
    public static void main(String[] args) {
        
        Map<String, Double> lakeClarities = new HashMap<>();
        lakeClarities.put("Bde Maka Ska", 49.1);
        lakeClarities.put("Harriet", 42.4);
        lakeClarities.put("Nokomis", 37.2);
        
        while (yesNoInput("Do you want to add or update a lake clarity?")) {
            String lakeName = stringInput("Enter the lake name");
            double clarity = positiveDoubleInput("Enter the clarity, in inches");
            updateClarity(lakeClarities, lakeName, clarity);
        }
        
        // Decide which lakes are suitable for swimming
        
        double minSwimmingClarity = 48;
        List<String> swimmingLakes = getSwimmingLakes(lakeClarities, minSwimmingClarity);
    
        System.out.println("These lakes are suitable for swimming: " + swimmingLakes);
        
    }

    public static void updateClarity(Map<String, Double> lakeClarities, String lake, double clarity) {
        
        // TODO add the new lake (key) and clarity (value) to lakeClarities HashMap.
        // If the lake name is already in the HashMap, then overwrite the previous clarity value with the new clarity.
        // you don't need to return anything. (Make sure you know why?)
        
    }
    
    public static List<String> getSwimmingLakes(Map<String, Double> lakeClarities, double minClarity) {
        
        // TODO return a list of lakes with clarity at or above minClarity.
        // Example: if lakeClarities = {"Nokomis"=23, "Como"=49, "Bde Maka Ska"=52}
        // Return a list of ["Nokomis", "Bde Maka Ska"]
        
        return null;   // TODO delete and replace with your code.
        
    }

    
}
