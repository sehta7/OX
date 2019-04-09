package com.name.OX;

import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

@Test
public class GameOptionsTest {

    public void testIfConfigurationsAreSaved() {
        Language language = new Language("en");
        Player crossPlayer = new Player("cross", new Scanner(System.in));
        crossPlayer.setSymbol(Symbol.CROSS);
        Player naughtPlayer = new Player("naught", new Scanner(System.in));
        naughtPlayer.setSymbol(Symbol.NAUGHT);
        Players players = new Players(naughtPlayer, crossPlayer);
        int boardSize = 10;
        int winningSigns = 5;
        GameOptions gameOptions = new GameOptions();
        gameOptions.configure(language, players, boardSize, winningSigns);
        assert (gameOptions.whatIsBoardSize() == boardSize) : "Not proper value of board size";
        assert (gameOptions.howManySignsWin() == winningSigns) : "Not proper value of winning signs";
        assert (gameOptions.whatIsLanguage().equals(language)) : "Not proper value of language";
        assert (gameOptions.whoIsCross().equals(crossPlayer)) : "Not proper value of language";
        assert (gameOptions.whoIsNaught().equals(naughtPlayer)) : "Not proper value of language";
    }
}