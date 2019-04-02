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
}