package week_4;

import java.util.List;
import java.util.Map;

import static input.InputUtils.*;

/**
  *  This program contains an example set of data about individual campsites for one day at a campground.
  *  People who want to stay at a campsite can make reservations. 
  *  This program will search the campsite data and return a list of sites that match a user's search criteria, 
  *  and are available.   
  *  
  *  In this program, the user will enter information about the type of campsite they want, and 
  *  your program will search for matching campsites, and return a list of campsites that are available. 
  *  
  *  Each campsite has a unique number 
  *  Each campsite has a type ("RV" or "TENT")
  *  Campsites may or may not have water at the site, stored under a "has_water" key with a value of "YES" or "NO"
  *  Campsites can be reserved, stored in a reserved key with a value of "RESERVED" or "AVAILABLE"
  *  
  *  Finish the getMatchingSites method. 
  *  Search the siteInfo Map (the global variable) and return a List of campsites that match 
  *  the search criteria AND are available.
  *
  *    - For example, if the user wants an RV campsite and wants water, then campsite 1 and 2 and 8 and 10 match,
  *    but only 2 and 8 and 10 are available. Return a list of [2, 8, 10]
  *
  *    - For example, if the user wants a TENT campsite and does not want water, then campsites 4, 5, 6 match,
  *    but only 4 and 5 are available. Return a list [4, 5]
  *
  *    - For example, if the user wants a TENT campsite and does want water, then site 3 matches,
  *    but it is reserved. Return an empty list []
 */

public class Question_4_Camping_Reservations {
    
    
    /*  Example individual campsite data. Do not modify this */
    private static Map<String, String> site1 = Map.of("type", "RV", "has_water", "YES", "availability", "RESERVED");
    private static Map<String, String> site2 = Map.of("type", "RV", "has_water", "YES", "availability", "AVAILABLE");
    private static Map<String, String> site3 = Map.of("type", "TENT", "has_water", "YES", "availability", "RESERVED");
    private static Map<String, String> site4 = Map.of("type", "TENT", "has_water", "NO", "availability", "AVAILABLE");
    private static Map<String, String> site5 = Map.of("type", "TENT", "has_water", "NO", "availability", "AVAILABLE");
    private static Map<String, String> site6 = Map.of("type", "TENT", "has_water", "NO", "availability", "RESERVED");
    private static Map<String, String> site7 = Map.of("type", "RV", "has_water", "NO", "availability", "AVAILABLE");
    private static Map<String, String> site8 = Map.of("type", "RV", "has_water", "YES", "availability", "AVAILABLE");
    private static Map<String, String> site9 = Map.of("type", "RV", "has_water", "NO", "availability", "RESERVED");
    private static Map<String, String> site10 = Map.of("type", "RV", "has_water", "YES", "availability", "AVAILABLE");
    
    /* Map of all the site reservation data. Do not modify this. Use this Map in your getMatchingSites method.*/
    static Map<String, Map<String, String>> siteInfo = Map.of("1", site1, "2", site2, "3", site3, "4", site4, "5", site5, "6", site6, "7", site7, "8", site8, "9", site9, "10", site10);
    
    
    public static void main(String[] args) {
        
        // You do not need to modify the main method.
    
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
        
//        TODO search the siteInfo Map (the global variable) and return a List of
//         sites that match the search criteria.
//        
//         For example, if the user wants an RV campsite and wants water, then campsite 1 and 2 and 8 and 10 match,
//         but only 2 and 8 and 10 are available. Return a list of [2, 8, 10]
//        
//         For example, if the user wants a TENT campsite and does not want water, then campsites 4, 5, 6 match,
//         but only 4 and 5 are available. Return a list [4, 5]
//    
//         For example, if the user wants a TENT campsite and does want water, then campsite 3 matches,
//         but it is reserved. Return an empty list []
        
        return null;  // TODO replace with your code.
    }
    
}
