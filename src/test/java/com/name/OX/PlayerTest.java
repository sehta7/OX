package com.name.OX;

import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */

@Test
public class PlayerTest {

    @Test(dataProviderClass = DP.class, dataProvider = "player")
    public void testIfPlayerReturnsItsName(String name) {
        Player player = new Player(name, new Scanner(System.in));
        assert (player.whichPlayer().equals(name)) : "Player does not know its name";
    }

    public void testIfAddPointsWhenWin() {
        Player player = new Player("player", new Scanner(System.in));
        player.win();
        assert (player.checkPoints() == 3) : "Does not add points to player";
    }

    public void testIfAddPointsWhenWinTwoTimes() {
        Player player = new Player("player", new Scanner(System.in));
        player.win();
        player.win();
        assert (player.checkPoints() == 6) : "Does not add points to player";
    }

    public void testIfAddPointsWhenDraw() {
        Player player = new Player("player", new Scanner(System.in));
        player.draw();
        assert (player.checkPoints() == 1) : "Does not add points to player";
    }

    public void testIfAddPointsWhenWinAndDraw() {
        Player player = new Player("player", new Scanner(System.in));
        player.win();
        player.draw();
        assert (player.checkPoints() == 4) : "Does not add points to player";
    }
}