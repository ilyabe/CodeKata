package com.ilyaberns.kata.two.karatechop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/21/12
 * Time: 1:50 AM
 */
public class ChopIterativeImplTest {

    private Chop chop;

    @Before
    public void setUp() throws Exception {
        chop = ChopFactory.makeIterativeChop();
    }

    @After
    public void tearDown() throws Exception {
        chop = null;
    }

    @Test
    public void testChop() throws Exception {
        assertEquals(-1, chop.chop(3, new int[0]));
        assertEquals(-1, chop.chop(3, new int[]{1}));
        assertEquals(0,  chop.chop(1, new int[]{1}));
        //
        assertEquals(0,  chop.chop(1, new int[]{1, 3, 5}));
        assertEquals(1,  chop.chop(3, new int[]{1, 3, 5}));
        assertEquals(2,  chop.chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, chop.chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, chop.chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, chop.chop(4, new int[]{1, 3, 5}));
        assertEquals(-1, chop.chop(6, new int[]{1, 3, 5}));
        //
        assertEquals(0,  chop.chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1,  chop.chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2,  chop.chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3,  chop.chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, chop.chop(8, new int[]{1, 3, 5, 7}));
    }
}
