package com.ilyaberns.kata.two.karatechop;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/20/12
 * Time: 8:39 PM
 */
public class ChopFactory {

    public static Chop makeIterativeChop() {
        return new ChopIterativeImpl();
    }

    public static Chop makeRecursiveChop() {
        return new ChopRecursiveImpl();
    }

    public static Chop makeDeferredDetectionOfEqualityChop() {
        return new ChopDeferredDetectionOfEqualityImpl();
    }

    public static ArrayList<Chop> makeAllChops() {
        ArrayList<Chop> allChops = new ArrayList<Chop>();

        allChops.add(makeIterativeChop());
        allChops.add(makeRecursiveChop());
        allChops.add(makeDeferredDetectionOfEqualityChop());

        return allChops;
    }
}
