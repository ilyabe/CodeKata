package com.ilyaberns.kata.two.karatechop;

import com.ilyaberns.constants.Constants;
import com.ilyaberns.kata.two.karatechop.utils.KarateChopUtils;
import com.ilyaberns.utils.Utils;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/25/12
 * Time: 12:07 AM
 *
 * Based on the Recursive binary search algorithm: http://en.wikipedia.org/wiki/Binary_search_algorithm#Recursive
 *
 * 1. Errors encountered:
 *      - ArrayIndexOutOfBoundsException for empty arrays
 *      - ArrayIndexOutOfBoundsException for one-element arrays because midpoint index would get increased to 1
 *      - StackOverflow on recursive call because forgot to check whether the searchable set is empty
 * 2. Merits:
 *      - More modular in that a recursive call is made to do the same operation, but edge cases clutter up the method
 */
public class ChopRecursiveImpl implements Chop {

    /**
     * Recursive binary search returns the index of the search target if the element is found and -1 if the element is
     * not found.
     *
     * @param searchTarget int to find
     * @param sortedArrayOfInt int array to search
     * @param minIndex int lower bound to search
     * @param maxIndex int upper bound to search
     * @return int index of the searchTarget or -1 if not found
     */
    public int chop(int searchTarget, int[] sortedArrayOfInt, int minIndex, int maxIndex) {
        // If array is empty, return not found
        if (sortedArrayOfInt.length == 0)
            return Constants.NOT_FOUND;

        // if searchable set is empty, return value showing not found
        if (maxIndex < minIndex)
            return Constants.NOT_FOUND;

        // calculate midpoint to cut set in half
        int midPoint = KarateChopUtils.calculateMidpoint(minIndex, maxIndex);

        // three-way comparison
        if (sortedArrayOfInt[midPoint] > searchTarget)
            // key is in lower subset
            return chop(searchTarget, sortedArrayOfInt, minIndex, midPoint - 1);
        else if (sortedArrayOfInt[midPoint] < searchTarget)
            // key is in upper subset
            return chop(searchTarget, sortedArrayOfInt, midPoint + 1, maxIndex);
        else
            // key has been found
            return midPoint;
    }

    public String toString() {
         return Utils.getInstance().getClassName(getClass().toString());
    }
}
