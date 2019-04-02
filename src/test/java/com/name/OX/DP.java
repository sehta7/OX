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

    @DataProvider
    public static Object[][] availableLanguage(){
        return new Object[][]{
                //TODO: iterate over AvailableLanguage enum
                {"pl"},
                {"en"}
        };
    }

    @DataProvider
    public static Object[][] player(){
        return new Object[][]{
                //TODO: iterate over AvailableLanguage enum
                {randomString()},
                {randomString()},
                {randomString()},
                {randomString()},
                {randomString()},
                {randomString()},
                {randomString()},
                {randomString()}
        };
    }

    @DataProvider
    public static Object[][] notAvailableLanguage(){
        return new Object[][]{
                {randomString(), "pl"},
                {randomString(), "pl"},
                {randomString(), "pl"},
                {randomString(), "pl"},
                {randomString(), "en"},
                {randomString(), "en"},
                {randomString(), "en"},
                {randomString(), "en"}
        };
    }

    @DataProvider
    public static Object[][] winningSigns(){
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

    private static String randomString(){
        Random random = new Random();
        int firstASCIIChar = 32;
        int lastASCIIChar = 126;
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < random.nextInt(15); i++){
            char ascii = (char) (random.nextInt((lastASCIIChar - firstASCIIChar) + 1) + firstASCIIChar);
            randomString.append(ascii);
        }
        return randomString.toString();
    }
}
