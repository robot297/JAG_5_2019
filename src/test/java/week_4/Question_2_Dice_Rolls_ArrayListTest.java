package week_4;

import input.InputUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import test_utils.ArrayListUtils;

import java.util.ArrayList;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;


@RunWith(PowerMockRunner.class)
@PrepareForTest(InputUtils.class)
public class Question_2_Dice_Rolls_ArrayListTest {
    

    @Test
    public void testUserWantsToContinue() throws Exception {

        mockStatic(InputUtils.class);
        expect(InputUtils.yesNoInput(anyString()))
                .andReturn(true)        // Provide two return values, plan to call the wantsToContinue method twice
                .andReturn(false);

        replay(InputUtils.class);

        Question_2_Dice_Rolls_ArrayList q2 = new Question_2_Dice_Rolls_ArrayList();

        assertTrue(q2.userWantsToContinue());
        assertFalse(q2.userWantsToContinue());

    }

    @Test
    public void testRoll() throws Exception {

        Question_2_Dice_Rolls_ArrayList q2 = new Question_2_Dice_Rolls_ArrayList();

        Random rnd = mock(Random.class);
        expect(rnd.nextInt(6))
                .andReturn(3)
                .andReturn(4)
                .andReturn(2)
                .andReturn(5);

        replay(rnd);

        // Replace the program's random number generator with the mock
        q2.rnd = rnd;

        ArrayList<Integer> expected = newArrayList(4, 5, 3, 6);

        ArrayList<Integer> actual = q2.roll(4);

        assertTrue(ArrayListUtils.intArrayListEqual(expected, actual));

    }

    @Test
    public void testDiceTotal() throws Exception {

        Question_2_Dice_Rolls_ArrayList q2 = new Question_2_Dice_Rolls_ArrayList();
        ArrayList<Integer> example = newArrayList(4, 5, 3);

        int total = q2.diceTotal(example);

        assertEquals(12, total);

    }

    @Test
    public void testAllSameValue() throws Exception {

        Question_2_Dice_Rolls_ArrayList q2 = new Question_2_Dice_Rolls_ArrayList();
        ArrayList<Integer> example = newArrayList(4, 5, 3);
        assertFalse(q2.allSameValue(example));

        example = newArrayList(4, 4, 4, 4, 3);
        assertFalse(q2.allSameValue(example));

        example = newArrayList(4, 4, 4);
        assertTrue(q2.allSameValue(example));

        example = newArrayList(4);
        assertTrue(q2.allSameValue(example));

        // Empty list, returns false
        example = newArrayList();
        assertFalse(q2.allSameValue(example));

        // null list, returns false
        example = null;
        assertFalse(q2.allSameValue(example));

    }
}