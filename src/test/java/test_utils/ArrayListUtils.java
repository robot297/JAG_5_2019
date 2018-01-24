package test_utils;

import java.util.ArrayList;

/**
 * Created by Clara on 6/1/17.
 * Convenience methods for working with arraylists
 */
public class ArrayListUtils {
    
    
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

    /**  Checks is membership same in two ArrayLists. Same elements, but can be in any order */


    public static boolean stringArrayListSameElementsAnyOrder(ArrayList<String> a1, ArrayList<String> a2) {

        if (a1 == null && a2 == null)  { return true; }    //both null
        if (a1 == null || a2 == null)  { return false; }   //if previous condition is false, this checks if one or the other null
        if (a1.size() != a2.size() )   { return false; }

        // Make a copy of a2 so can modify it without affecting the original ArrayList
        ArrayList<String> a2_copy = (ArrayList<String>) a2.clone();

        // Loop over first ArrayList. Remove each element from the other ArrayList.
        for (String e : a1 ) {
            a2_copy.remove(e);
        }

        // If all of a2_copy elements were removed, it must have had the same elements as a1
        if (a2_copy.size() == 0) {
            return true;
        }

        return false;
    }
}
