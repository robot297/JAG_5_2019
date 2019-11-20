package week_5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clara on 2019-09-11.
 */
public class Question_5_Sales_RecordsTest {
    
    static final int TIMEOUT = 3000;
    
    @Test(timeout = TIMEOUT)
    public void addSalesAndSalesForEvent() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
    
        q5.addSales("PyCon", "Monday", 3);
        q5.addSales("PyCon", "Tuesday", 2);
        q5.addSales("PyCon", "Wednesday", 5);
        q5.addSales("PyCon", "Thursday", 1);
        q5.addSales("PyCon", "Friday", 3);
    
        int[] pyConSales = q5.salesForEvent("PyCon");
    
        assertArrayEquals(new int[]{3, 2, 5, 1, 3}, pyConSales);
    }
    
    
    @Test(timeout = TIMEOUT)
    public void addSalesAndSalesForEventDaysNotInOrder() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
    
        q5.addSales("JSCon", "Friday", 7);
        q5.addSales("JSCon", "Wednesday", 100);
        q5.addSales("JSCon", "Monday", 2);
        q5.addSales("JSCon", "Tuesday", 42);
        q5.addSales("JSCon", "Thursday", 9);
    
        int[] jsConSales = q5.salesForEvent("JSCon");
    
        assertArrayEquals( new int[]{2, 42, 100, 9, 7}, jsConSales);
    }
    
    
    @Test(timeout = TIMEOUT)
    public void addSalesAndSalesForEventMissingSales() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
    
        q5.addSales("PyCon", "Monday", 3);
        q5.addSales("PyCon", "Tuesday", 2);
        q5.addSales("PyCon", "Thursday", 1);
       
        int[] pyConSales = q5.salesForEvent("PyCon");
    
        assertArrayEquals( new int[]{3, 2, 0, 1, 0}, pyConSales);
    
        q5.addSales("JSCon", "Monday", 7);
        q5.addSales("JSCon", "Tuesday", 100);
        q5.addSales("JSCon", "Thursday", 42);
        q5.addSales("JSCon", "Friday", 9);
    
        int[] jsConSales = q5.salesForEvent("JSCon");
    
        assertArrayEquals( new int[]{7, 100, 0, 42, 9}, jsConSales);
        
        q5.addSales("CSharpCon", "Thursday", 9);
        int[] cSharpConSales = q5.salesForEvent("CSharpCon");
        assertArrayEquals( new int[]{0, 0, 0, 9, 0}, cSharpConSales);
    }
    
    
    @Test(timeout = TIMEOUT)
    public void addSalesForInvalidDay() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
    
        // No real days - only Monday through Friday are accepted
        q5.addSales("PyCon", "Pizza", 3);
        q5.addSales("PyCon", "Saturday", 2);
        q5.addSales("PyCon", "Cat", 1);
    
        q5.addSales("PyCon", "Monday", 1);    // Real day
        
        int[] pyConSales = q5.salesForEvent("PyCon");
    
        assertArrayEquals( new int[]{1, 0, 0, 0, 0}, pyConSales);
    }
    
    @Test(timeout = TIMEOUT)
    public void salesForEventEventDoesNotExist(){
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
        assertNull(q5.salesForEvent("Does not exist"));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void eventExists() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
        q5.addSales("PyCon", "Monday", 3);
        assertTrue(q5.eventExists("PyCon"));
    
        q5.addSales("RubyCon", "Monday", 9);
        q5.addSales("RubyCon", "Tuesday", 99);
        q5.addSales("RubyCon", "Wednesday", 90);
        q5.addSales("RubyCon", "Thursday", 19);
        q5.addSales("RubyCon", "Friday", 92);
        assertTrue(q5.eventExists("RubyCon"));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void eventDoesNotExist() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
        q5.addSales("PyCon", "Monday", 3);
        assertFalse(q5.eventExists("CSharpCon"));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void daySaleAtOrAboveAverageForWeek() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
    
        q5.addSales("JSCon", "Monday", 3);     // below
        q5.addSales("JSCon", "Tuesday", 7);   // above
        q5.addSales("JSCon", "Wednesday", 5);       // at
        q5.addSales("JSCon", "Thursday", 9);   //above
        q5.addSales("JSCon", "Friday", 1);    // below
        
        String msg = "With data for an event called JSCon, and sales data Monday=3, Tuesday=7, Wednesday=5, Thursday=9, Friday=1 (Total=25 average5=) the sales for %s, %d, are %s average";
        assertFalse(String.format(msg, "Monday", 3, "below"), q5.daySaleAtOrAboveAverageForWeek("JSCon", "Monday"));
        assertTrue(String.format(msg, "Tuesday", 7, "above"), q5.daySaleAtOrAboveAverageForWeek("JSCon", "Tuesday"));
        assertTrue(String.format(msg, "Wednesday", 5, "at"), q5.daySaleAtOrAboveAverageForWeek("JSCon", "Wednesday"));
        assertTrue(String.format(msg, "Thursday", 9, "above"), q5.daySaleAtOrAboveAverageForWeek("JSCon", "Thursday"));
        assertFalse(String.format(msg, "Friday", 1, "below"), q5.daySaleAtOrAboveAverageForWeek("JSCon", "Friday"));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void daySaleAtOrAboveAverageForWeekEventDoesNotExist() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
        assertNull("daySaleAtOrAboveAverageForWeek should return null if the event does not exist", q5.daySaleAtOrAboveAverageForWeek("Not an event", "Monday"));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void daySaleAtOrAboveAverageForWeekDayAndEventDoNotExist() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
        assertNull("daySaleAtOrAboveAverageForWeek should return null if the event is not found, or the day of week is not valid. " +
                        "Only Monday, Tuesday, Wednesday, Thursday, Friday are valid."
                , q5.daySaleAtOrAboveAverageForWeek("Not an event", "Saturday"));
    
        assertNull("daySaleAtOrAboveAverageForWeek should return null if the event is not found, or the day of week is not valid. " +
                        "Only Monday, Tuesday, Wednesday, Thursday, Friday are valid."
                , q5.daySaleAtOrAboveAverageForWeek("Not an event", "Cat"));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void daySaleAtOrAboveAverageForWeekDayDoestNotExist() {
        Question_5_Sales_Records q5 = new Question_5_Sales_Records();
        q5.addSales("JSCon", "Monday", 3);
        assertNull("daySaleAtOrAboveAverageForWeek should return null if the day of the week is not valid. " +
                "Only Monday, Tuesday, Wednesday, Thursday, Friday are valid.",
                q5.daySaleAtOrAboveAverageForWeek("JSCon", "Pizza"));
    
        assertNull("daySaleAtOrAboveAverageForWeek should return null if the day of the week is not valid. " +
                        "Only Monday, Tuesday, Wednesday, Thursday, Friday are valid.",
                q5.daySaleAtOrAboveAverageForWeek("JSCon", "Sunday"));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void humanReview() {
        fail("This test is intended to fail. The instructor will review your work and assign a grade");
    }
}