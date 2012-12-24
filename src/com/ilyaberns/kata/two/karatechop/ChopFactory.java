package com.ilyaberns.kata.two.karatechop;

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
}
