package com.ilyaberns.kata.two.karatechop;

import com.ilyaberns.constants.Constants;
import com.ilyaberns.kata.two.karatechop.utils.KarateChopUtils;
import com.ilyaberns.utils.Utils;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/26/12
 * Time: 9:04 PM
 *
 * Based on the Deferred detection of equality binary search algorithm:
 * http://en.wikipedia.org/wiki/Binary_search_algorithm#Deferred_detection_of_equality
 *
 * The difference is the equality check is moved out of the iteration since it only needs to be made rarely,
 *
 * 1. Errors encountered:
 *      - None
 * 2. Merits:
 *      - Simpler to code, although a little more difficult to understand the algorithm at first
 *      - More modular since I can refactor the equality test out
 *      - Goes with above, but code is simpler with only two branches in search reduction
 */
public class ChopDeferredDetectionOfEqualityImpl implements Chop {

    /**
     * Deferred detection of equality binary search finds the searchTarget in the sortedArrayOfInt
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

        // continually narrow search until just one element remains
        while (minIndex < maxIndex) {
            int midpoint = KarateChopUtils.calculateMidpoint(minIndex, maxIndex);

            // code must guarantee the interval is reduced at each iteration
            assert(midpoint < maxIndex);
            // note: 0 <= minIndex < maxIndex implies minIndex will always be less than maxIndex

            // reduce the search
            if (sortedArrayOfInt[midpoint] < searchTarget) {
                minIndex = midpoint + 1;
            } else {
                maxIndex = midpoint;
            }
        }

        // At exit of while:
        //   if A[] is empty, then imax < imin
        //   otherwise imax == imin

        // deferred test for equality
        if ((maxIndex == minIndex) && sortedArrayOfInt[minIndex] == searchTarget) {
            return minIndex;
        } else {
            return Constants.NOT_FOUND;
        }
    }

    public String toString() {
        return Utils.getInstance().getClassName(getClass().toString());
    }
}
