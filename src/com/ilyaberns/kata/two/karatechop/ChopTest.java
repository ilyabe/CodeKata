package com.ilyaberns.kata.two.karatechop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/21/12
 * Time: 1:50 AM
 */
public class ChopTest {

    private ArrayList<Chop> allChops;

    @Before
    public void setUp() throws Exception {
        allChops = ChopFactory.makeAllChops();
    }

    @After
    public void tearDown() throws Exception {
        allChops = null;
    }

    @Test
    public void testChop() throws Exception {
        for (Chop chop : allChops) {
            System.out.println("Starting test for " + chop.toString());
            assertEquals(-1, chop.chop(3, new int[0], 0, 0));
            assertEquals(-1, chop.chop(3, new int[]{1}, 0, 0));
            assertEquals(0,  chop.chop(1, new int[]{1}, 0, 0));
            //
            assertEquals(0,  chop.chop(1, new int[]{1, 3, 5}, 0, 2));
            assertEquals(1,  chop.chop(3, new int[]{1, 3, 5}, 0, 2));
            assertEquals(2,  chop.chop(5, new int[]{1, 3, 5}, 0, 2));
            assertEquals(-1, chop.chop(0, new int[]{1, 3, 5}, 0, 2));
            assertEquals(-1, chop.chop(2, new int[]{1, 3, 5}, 0, 2));
            assertEquals(-1, chop.chop(4, new int[]{1, 3, 5}, 0, 2));
            assertEquals(-1, chop.chop(6, new int[]{1, 3, 5}, 0, 2));
            //
            assertEquals(0,  chop.chop(1, new int[]{1, 3, 5, 7}, 0, 3));
            assertEquals(1,  chop.chop(3, new int[]{1, 3, 5, 7}, 0, 3));
            assertEquals(2,  chop.chop(5, new int[]{1, 3, 5, 7}, 0, 3));
            assertEquals(3,  chop.chop(7, new int[]{1, 3, 5, 7}, 0, 3));
            assertEquals(-1, chop.chop(0, new int[]{1, 3, 5, 7}, 0, 3));
            assertEquals(-1, chop.chop(2, new int[]{1, 3, 5, 7}, 0, 3));
            assertEquals(-1, chop.chop(4, new int[]{1, 3, 5, 7}, 0, 3));
            assertEquals(-1, chop.chop(6, new int[]{1, 3, 5, 7}, 0, 3));
            assertEquals(-1, chop.chop(8, new int[]{1, 3, 5, 7}, 0, 3));
            System.out.println("All tests passed for " + chop.toString());
        }
    }
}
