package test_utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Clara on 6/1/17.
 * Convenience methods for working with arraylists
 */
public class ArrayListUtils {
    
    
    public static ArrayList<String> newArrayList(String... data) {
        return new ArrayList<>(Arrays.asList(data));
    }
    
    
    public static ArrayList<Integer> newArrayList(Integer... data) {
        return new ArrayList<>(Arrays.asList(data));
    }
    
    
    /** Utility method to compare data in two ArrayLists.
     * Returns true if both lists are the same length, and
     * have the same items in the same order. If verbose == true, and Arrays are not equal, print the reason. */
    
    
    public static boolean arrayListEqual(ArrayList a1, ArrayList a2, boolean verbose) {
        
        String msg = null;
        
        if (a1 == null && a2 == null)  { msg = null; }    //both null
        
        else if (a1 == null || a2 == null)  { msg = "ArrayLists are not equal, one is null, the other is not. \nOne is " + a1 + " and the other is " + a2; }   //if previous condition is false, this checks if one or the other null
        
        else if (a1.size() != a2.size() )   { msg = "ArrayLists are not equal size. \nOne is " + a1 + " and the other is " + a2; }
    
        else {
            for (int x = 0; x < a1.size(); x++) {
                if (!a1.get(x).equals(a2.get(x))) {
                    msg = "ArrayLists not equal. At position " + x + " the first ArrayList has the value " + a1.get(x) + "and the second ArrayList has the value" + a2.get(x)
                            + "\nThe entire ArrayList are \n" + a1 + "\n" + a2;
                }
            }
        }
        
        if (verbose) {
            System.out.println( (msg == null) ? "ArrayLists are equal." : msg );
        }
        
        return (msg == null);
    
        
    }
    
        /** Utility method to compare data in two ArrayLists.
         * Returns true if both lists are the same length, and
         * have the same items in the same order. */
    
    public static boolean arrayListEqual(ArrayList a1, ArrayList a2) {
        
        return arrayListEqual(a1, a2, false);
    }

    /**  Checks if membership same in two ArrayLists. Same elements, but can be in any order */
    public static boolean stringListSameElementsAnyOrder(List<String> a1, List<String> a2, boolean verbose) {

        if (a1 == null && a2 == null)  { return true; }    // both null, are the same
        
        if (a1 == null || a2 == null)  {
            //if previous condition is false, this checks if one is null and the other is not null, therefore different
            if (verbose) {
                System.out.println("One list is null, the other is not." + a1 + " " + a2);
            }
            return false;
        }
        
        if (a1.size() != a2.size() )   {
            if (verbose) {
                System.out.println("First list was " + a1 + "\nSecond list was " + a2 +
                        "\nLists have different sizes so do not contain the same elements. Order does not matter.");
            }
            
            return false;
        }

        // Make a copy of a2 so can modify it without affecting the original ArrayList
        List<String> a2_copy = new ArrayList<>(a2);
        
        // Loop over first ArrayList. Remove each element from the copy of a2
        for (String e : a1) {
            a2_copy.remove(e);
        }

        // If all of a2_copy elements were removed, it must have had the same elements as a1
        if (a2_copy.size() == 0) {
            return true;
        }

        if (verbose) {
            System.out.println("First list was " + a1 + "\nSecond list was " + a2 +
                    "\nLists do not contain the same elements. Order does not matter.");
        }
        return false;
    }
}
