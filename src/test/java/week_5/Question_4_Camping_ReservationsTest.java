package week_5;

import org.junit.Test;
import test_utils.ArrayListUtils;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by clara on 2019-09-10.
 */
public class Question_4_Camping_ReservationsTest {
    
    static final int TIMEOUT = 3000;
    
    @Test(timeout = TIMEOUT)
    public void testSearchTentWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("TENT", true);
        List<String> expected = List.of();
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void testSearchTentNoWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("TENT", false);
        List<String> expected = List.of("4", "5");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    
    }
    
    @Test(timeout = TIMEOUT)
    public void testSearchRVWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("RV", true);
        List<String> expected = List.of("2", "8", "10");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    
    }
    
    @Test(timeout = TIMEOUT)
    public void testSearchRVNoWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("RV", false);
        List<String> expected = List.of("7");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    }
    
    
}