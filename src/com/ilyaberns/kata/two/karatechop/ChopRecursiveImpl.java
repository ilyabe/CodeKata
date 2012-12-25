package com.ilyaberns.kata.two.karatechop;

import com.ilyaberns.constants.Constants;
import com.ilyaberns.utils.Utils;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/25/12
 * Time: 12:07 AM
 */
public class ChopRecursiveImpl implements Chop {

    public int chop(int searchTarget, int[] sortedArrayOfInt) {
        return Constants.NOT_FOUND;
    }

    public String toString() {
         return Utils.getInstance().getClassNameString(getClass().toString());
    }
}
