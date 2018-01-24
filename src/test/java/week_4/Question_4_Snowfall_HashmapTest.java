package week_4;

import input.InputUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;

import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;



@RunWith(PowerMockRunner.class)
@PrepareForTest(InputUtils.class)
public class Question_4_Snowfall_HashmapTest {

    double delta = 0.0001;


    @Test
    public void testAddToHashmap() throws Exception {


        Question_4_Snowfall_HashMap q4 = new Question_4_Snowfall_HashMap();

        // Data not in HashMap, should be added
        q4.addToHashMap("March", 4);
        assertEquals(4.0, q4.snowfall.get("March"), delta);
        assertEquals(1, q4.snowfall.size());

        // Mocking user input
        mockStatic(InputUtils.class);
        expect(InputUtils.yesNoInput(anyString()))
                .andReturn(true)    // First case, want to overwrite
                .andReturn(false);  // Second case, don't want to overwrite
        replay(InputUtils.class);

        // Data in HashMap, user wants to overwrite

        q4 = new Question_4_Snowfall_HashMap();

        q4.snowfall.put("January", 10.3);
        q4.snowfall.put("February", 3.1);

        q4.addToHashMap("January", 4.3);

        // Should be updated
        assertEquals(4.3, q4.snowfall.get("January"), delta);
        assertEquals(3.1, q4.snowfall.get("February"), delta);
        assertEquals(2, q4.snowfall.size());


        // Data in HashMap, user does not want to overwrite
        q4 = new Question_4_Snowfall_HashMap();

        q4.snowfall.put("January", 10.3);
        q4.snowfall.put("February", 3.1);

        q4.addToHashMap("January", 4.3);

        // Should NOT be updated
        assertEquals(10.3, q4.snowfall.get("January"), delta);
        assertEquals(3.1, q4.snowfall.get("February"), delta);
        assertEquals(2, q4.snowfall.size());



    }

    @Test
    public void testMonthInHashMap() throws Exception {

        Question_4_Snowfall_HashMap q4 = new Question_4_Snowfall_HashMap();
        q4.snowfall.put("January", 3.0);
        assertTrue(q4.monthInHashMap("January"));

        q4.snowfall.remove("January");
        assertFalse(q4.monthInHashMap("January"));

    }

    @Test
    public void testTotalSnow() throws Exception {

        Question_4_Snowfall_HashMap q4 = new Question_4_Snowfall_HashMap();
        q4.snowfall = new HashMap<String, Double>();
        q4.snowfall.put("jan", 6.1);
        q4.snowfall.put("feb", 7.8);
        q4.snowfall.put("mar", 2.3);

        assertEquals( 6.1 + 7.8 + 2.3 , q4.totalSnow(), delta);

    }

    @Test
    public void testMaxSnow() throws Exception {

        Question_4_Snowfall_HashMap q4 = new Question_4_Snowfall_HashMap();
        q4.snowfall = new HashMap<String, Double>();
        q4.snowfall.put("jan", 6.1);
        q4.snowfall.put("feb", 7.8);
        q4.snowfall.put("mar", 2.3);

        assertEquals("feb" , q4.maxSnow());

    }
}