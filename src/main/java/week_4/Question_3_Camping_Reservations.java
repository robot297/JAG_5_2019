package week_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static input.InputUtils.*;

/**
 *
 */

public class Question_3_Camping_Reservations {
    
    
    /* Example site reservation data. Do not modify this */
    static Map<String, String> site1 = Map.of("type", "RV", "has_water", "YES", "availability", "RESERVED");
    static Map<String, String> site2 = Map.of("type", "RV", "has_water", "YES", "availability", "AVAILABLE");
    static Map<String, String> site3 = Map.of("type", "TENT", "has_water", "YES", "availability", "RESERVED");
    static Map<String, String> site4 = Map.of("type", "TENT", "has_water", "NO", "availability", "AVAILABLE");
    static Map<String, String> site5 = Map.of("type", "TENT", "has_water", "NO", "availability", "AVAILABLE");
    static Map<String, String> site6 = Map.of("type", "TENT", "has_water", "NO", "availability", "RESERVED");
    static Map<String, String> site7 = Map.of("type", "RV", "has_water", "NO", "availability", "AVAILABLE");
    static Map<String, String> site8 = Map.of("type", "RV", "has_water", "YES", "availability", "AVAILABLE");
    static Map<String, String> site9 = Map.of("type", "RV", "has_water", "NO", "availability", "RESERVED");
    static Map<String, String> site10 = Map.of("type", "RV", "has_water", "YES", "availability", "AVAILABLE");
    
    static Map<String, Map<String, String>> siteInfo = Map.of("1", site1, "2", site2, "3", site3, "4", site4, "5", site5, "6", site6, "7", site7, "8", site8, "9", site9, "10", site10);
    
    
    public static void main(String[] args) {
        
        // You do not need to modify the main method
    
        List<String> siteTypes = List.of("RV", "TENT");
        
        String siteType = stringInput("Do you want to reserve an RV or TENT site?").toUpperCase();
        if (!siteTypes.contains(siteType)) {
            System.out.println("Enter RV or TENT. Try running the program again.");
        }
        
        boolean needWater = yesNoInput("Do you want water at the site?");
        
        List<String> availableSiteNames = getMatchingSites(siteType, needWater);
    
        if (availableSiteNames.isEmpty()) {
            System.out.println("No sites match your search");
        } else {
            System.out.println("These sites are available: " + availableSiteNames);
        }
        
    }
    
    static List<String> getMatchingSites(String siteType, boolean needWater) {
        
        //TODO search the siteInfo Map (the global variable) and return a List of
        // sites that match the search criteria.
        
        // For example, if the user wants an RV site and wants water, then site 1 and 2 and 8 and 10 match,
        // but only 2 and 8 and 10 are available. Return a list of [2, 8, 10]
        
        // For example, if the user wants a TENT site and does not want water, then sites 4, 5, 6 match,
        // but only 4 and 5 are available. Return a list [4, 5]
    
        // For example, if the user wants a TENT site and does want water, then site 3 match,
        // but it is reserved. Return an empty list []
        
        return null;  // TODO replace with your code.
    }
    
}
