package com.ilyaberns.kata.two.karatechop;

import com.ilyaberns.constants.Constants;
import com.ilyaberns.kata.two.karatechop.utils.KarateChopUtils;
import com.ilyaberns.utils.Utils;

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
 *      - Based minIndex, maxIndex on array size. Can't do that for recursive version
 *      - ArrayIndexOutOfBoundsException when passing an empty array
 * 2. Merits:
 *      - Straight-forward, well documented
 */
public class ChopIterativeImpl implements Chop {

    /**
     * Iterative binary search finds the searchTarget in the sortedArrayOfInt
     *
     * @param searchTarget int to find
     * @param sortedArrayOfInt int array to search
     * @param minIndex int lower bound to search
     * @param maxIndex int upper bound to search
     * @return int index of the searchTarget or -1 if not found
     */
    public int chop(int searchTarget, int[] sortedArrayOfInt, int minIndex, int maxIndex) {

        // Return not found for empty arrays
        if (sortedArrayOfInt.length == 0)
            return Constants.NOT_FOUND;

        // Continue searching while [minIndex,maxIndex] is not empty
        while (maxIndex >= minIndex) {
            // Calculate the midpoint for roughly equal partition
            int midPoint = KarateChopUtils.calculateMidpoint(minIndex, maxIndex);
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

    public String toString() {
        return Utils.getInstance().getClassName(getClass().toString());
    }
}
