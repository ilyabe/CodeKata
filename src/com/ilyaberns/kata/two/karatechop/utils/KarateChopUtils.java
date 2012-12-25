package com.ilyaberns.kata.two.karatechop.utils;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/25/12
 * Time: 12:01 PM
 */
public class KarateChopUtils {

    /**
     * Calculates the rough mid point between two indices
     *
     * @param min int starting point
     * @param max int ending point
     * @return int mid point
     */
    public static int calculateMidpoint(int min, int max) {
        return min + ((max - min) / 2);
    }
}
