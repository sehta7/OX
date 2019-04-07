package com.name.OX;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.testng.Assert.*;

/**
 * @author Ola Podorska
 */

@Test
public class InputDataReaderTest {

    @Test(dataProviderClass = DP.class, dataProvider = "availableLanguage")
    public void testIfReadProperLanguage(String inputLanguage) {
        InputDataReader inputDataReader = new InputDataReader(new Scanner(inputLanguage), new Displayer(new Language("en")));
        assert (inputLanguage.equals(inputDataReader.readLanguage())) : "Does not read proper value of language";
    }

    //TODO: remove path file
    public void testIfFinallyFindProperLanguage() {
        File file = new File("/home/ola/Desktop/language_test.txt");
        InputDataReader inputDataReader = null;
        String readLanguage = "";
        try {
            inputDataReader = new InputDataReader(new Scanner(file), new Displayer(new Language("en")));
            readLanguage = inputDataReader.readLanguage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert (readLanguage.equals("pl")) : "Does not find proper value of language";
    }

    @Test(dataProviderClass = DP.class, dataProvider = "player")
    public void testIfReadProperPlayer(String inputPlayer) {
        InputDataReader inputDataReader = new InputDataReader(new Scanner(inputPlayer), new Displayer(new Language("en")));
        assert (inputPlayer.equals(inputDataReader.readPlayer())) : "Does not read proper value of player";
    }

    @Test(dataProviderClass = DP.class, dataProvider = "boardSize")
    public void testIfReadProperBoardSize(String inputBoardSize) {
        InputDataReader inputDataReader = new InputDataReader(new Scanner(inputBoardSize), new Displayer(new Language("en")));
        assert (inputBoardSize.equals(inputDataReader.readBoardSize())) : "Does not read proper value of player";
    }

    public void testIfFinallyFindProperBoardSize() {
        File file = new File("/home/ola/Desktop/board_size_test.txt");
        InputDataReader inputDataReader = null;
        String readBoardSize = "";
        try {
            inputDataReader = new InputDataReader(new Scanner(file), new Displayer(new Language("en")));
            readBoardSize = inputDataReader.readBoardSize();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert (readBoardSize.equals("6")) : "Does not find proper value of language";
    }

    @Test(dataProviderClass = DP.class, dataProvider = "winningSigns")
    public void testIfReadProperWinningSigns(String inputWinningSigns) {
        InputDataReader inputDataReader = new InputDataReader(new Scanner(inputWinningSigns), new Displayer(new Language("en")));
        assert (inputWinningSigns.equals(inputDataReader.readWinningSigns())) : "Does not read proper value of player";
    }

    public void testIfFinallyFindProperWinningSigns() {
        File file = new File("/home/ola/Desktop/winning_signs_test.txt");
        InputDataReader inputDataReader = null;
        String readWinningSigns = "";
        try {
            inputDataReader = new InputDataReader(new Scanner(file), new Displayer(new Language("en")));
            readWinningSigns = inputDataReader.readWinningSigns();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert (readWinningSigns.equals("7")) : "Does not find proper value of language";
    }

    //TODO: test if winning signs can't be bigger than board size

}