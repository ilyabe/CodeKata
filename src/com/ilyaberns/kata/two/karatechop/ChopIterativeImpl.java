package com.ilyaberns.kata.two.karatechop;

import com.ilyaberns.constants.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/20/12
 * Time: 8:19 PM
 *
 * Based on the Iterative binary search algorithm: http://en.wikipedia.org/wiki/Binary_search_algorithm#Iterative
 *
 * 1. Errors encountered:
 *      - Calculating midpoint incorrectly by forgetting that min is not always 0, which can cause an infinite loop
 * 2. Merits:
 *      - Straight-forward, well documented
 */
public class ChopIterativeImpl implements Chop {

    /**
     * Iterative binary search finds the searchTarget in the sortedArrayOfInt
     *
     * @param searchTarget int to find
     * @param sortedArrayOfInt int array to search
     * @return int index of the searchTarget or -1 if not found
     */
    public int chop(int searchTarget, int[] sortedArrayOfInt) {
        int minIndex = 0;
        int maxIndex = sortedArrayOfInt.length - 1;

        // Continue searching while [minIndex,maxIndex] is not empty
        while (maxIndex >= minIndex) {
            // Calculate the midpoint for roughly equal partition
            int midPoint = calculateMidpoint(minIndex, maxIndex);
            // Determine which subarray to search
            if (sortedArrayOfInt[midPoint] < searchTarget) {
                // Change min index to search upper subarray
                minIndex = midPoint + 1;
            } else if (sortedArrayOfInt[midPoint] > searchTarget) {
                // Change max index to search lower subarray
                maxIndex = midPoint - 1;
            } else {
                // Key found at middle index
                return midPoint;
            }
        }

        return Constants.NOT_FOUND;
    }

    /**
     * Calculates the rough mid point between to indexes
     * @param min int starting point
     * @param max int ending point
     * @return int mid point
     */
    private int calculateMidpoint(int min, int max) {
        return min + ((max - min) / 2);
    }

    public String toString() {
        return "ChopIterativeImpl";
    }
}
