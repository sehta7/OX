package com.name.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * @author Ola Podorska
 */
class DP {

    private static final int MIN = 3;
    private static final int MAX = 100;


    @DataProvider
    public static Object[][] boardSize(){
        return new Object[][]{
                {randomNumber()},
                {randomNumber()},
                {randomNumber()},
                {randomNumber()},
                {randomNumber()},
                {randomNumber()},
                {randomNumber()},
                {randomNumber()},
                {randomNumber()},
                {randomNumber()}
        };
    }

    private static String randomNumber() {
        Random random = new Random();
        int number = random.nextInt((MAX - MIN) + 1) + MIN;
        return String.valueOf(number);
    }
}
