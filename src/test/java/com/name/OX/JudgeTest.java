package com.name.OX;

import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

@Test
public class JudgeTest {

    public void testIfFoundWinnerHorizontally() {
        Language language = new Language("en");
        Player crossPlayer = new Player("cross", new Scanner(System.in));
        crossPlayer.setSymbol(Symbol.CROSS);
        Player naughtPlayer = new Player("naught", new Scanner(System.in));
        naughtPlayer.setSymbol(Symbol.NAUGHT);
        Players players = new Players(naughtPlayer, crossPlayer);
        int boardSize = 3;
        int winningSigns = 3;
        GameOptions gameOptions = new GameOptions();
        gameOptions.configure(language, players, boardSize, winningSigns);
        Move firstMove = new Move(1,  naughtPlayer);
        Move secondMove = new Move(2, naughtPlayer);
        Move thirdMove = new Move(3, naughtPlayer);
        Judge judge = new Judge(gameOptions);
        judge.update(firstMove);
        judge.update(secondMove);
        judge.update(thirdMove);
        assert (judge.foundWinner().equals(Symbol.NAUGHT)) : "Judge does not found winner";
    }

    public void testIfFoundWinnerVertically() {
        Language language = new Language("en");
        Player crossPlayer = new Player("cross", new Scanner(System.in));
        crossPlayer.setSymbol(Symbol.CROSS);
        Player naughtPlayer = new Player("naught", new Scanner(System.in));
        naughtPlayer.setSymbol(Symbol.NAUGHT);
        Players players = new Players(naughtPlayer, crossPlayer);
        int boardSize = 3;
        int winningSigns = 3;
        GameOptions gameOptions = new GameOptions();
        gameOptions.configure(language, players, boardSize, winningSigns);
        Move firstMove = new Move(1,  naughtPlayer);
        Move secondMove = new Move(4, naughtPlayer);
        Move thirdMove = new Move(7, naughtPlayer);
        Judge judge = new Judge(gameOptions);
        judge.update(firstMove);
        judge.update(secondMove);
        judge.update(thirdMove);
        assert (judge.foundWinner().equals(Symbol.NAUGHT)) : "Judge does not found winner";
    }

    public void testIfFoundWinnerDiagonally() {
        Language language = new Language("en");
        Player crossPlayer = new Player("cross", new Scanner(System.in));
        crossPlayer.setSymbol(Symbol.CROSS);
        Player naughtPlayer = new Player("naught", new Scanner(System.in));
        naughtPlayer.setSymbol(Symbol.NAUGHT);
        Players players = new Players(naughtPlayer, crossPlayer);
        int boardSize = 3;
        int winningSigns = 3;
        GameOptions gameOptions = new GameOptions();
        gameOptions.configure(language, players, boardSize, winningSigns);
        Move firstMove = new Move(1,  naughtPlayer);
        Move secondMove = new Move(5, naughtPlayer);
        Move thirdMove = new Move(9, naughtPlayer);
        Judge judge = new Judge(gameOptions);
        judge.update(firstMove);
        judge.update(secondMove);
        judge.update(thirdMove);
        assert (judge.foundWinner().equals(Symbol.NAUGHT)) : "Judge does not found winner";
    }
}