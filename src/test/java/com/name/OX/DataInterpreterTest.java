package com.name.OX;

import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

/**
 * @author Ola Podorska
 */
@Test
public class DataInterpreterTest {

    public void testIfCreateProperLanguage() {
        DataInterpreter dataInterpreter = new DataInterpreter();
        String languageName = "fr";
        Language language = dataInterpreter.interpretLanguage(languageName);
        assert (language.whatLanguage().equals(languageName)) : "Does not save proper name of language";
    }

    public void testIfCreateProperPlayer() {
        DataInterpreter dataInterpreter = new DataInterpreter();
        String playerName = "player";
        Player player = dataInterpreter.interpretPlayers(playerName, new Scanner(System.in));
        assert (player.whichPlayer().equals(playerName)) : "Does not save proper name of player";
    }

    @Test(dataProviderClass = DP.class, dataProvider = "boardSize")
    public void testIfSaveProperSizeBoard(String size){
        DataInterpreter dataInterpreter = new DataInterpreter();
        int boardSize = dataInterpreter.interpretBoardSize(size);
        assert (String.valueOf(boardSize).equals(size)) : "Does not save proper size of board";
    }
}