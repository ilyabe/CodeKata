package com.ilyaberns.main;

import com.ilyaberns.kata.two.karatechop.Chop;
import com.ilyaberns.kata.two.karatechop.ChopFactory;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/20/12
 * Time: 8:13 PM
 */
public class Main {

    public static void main(String[] args) {
        Chop chop = ChopFactory.makeIterativeChop();
        System.out.println(chop.chop(4, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }
}
