package week_4;

import org.junit.Test;
import test_utils.ArrayListUtils;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by clara on 2019-09-10.
 */
public class Question_4_Camping_ReservationsTest {
    
    @Test(timeout = 3000)
    public void testSearchTentWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("TENT", true);
        List<String> expected = List.of();
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    }
    
    
    @Test(timeout = 3000)
    public void testSearchTentNoWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("TENT", false);
        List<String> expected = List.of("4", "5");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    
    }
    
    @Test(timeout = 3000)
    public void testSearchRVWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("RV", true);
        List<String> expected = List.of("2", "8", "10");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    
    }
    
    @Test(timeout = 3000)
    public void testSearchRVNoWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("RV", false);
        List<String> expected = List.of("7");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    }
    
    
}