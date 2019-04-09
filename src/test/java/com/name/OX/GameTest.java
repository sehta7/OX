package com.name.OX;


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Test
public class GameTest {


    @Test(expectedExceptions = NoSuchElementException.class)
    public void verticalWinAutomatedGame() throws IOException {

        String testFile = readFile("4_3_v.txt", StandardCharsets.UTF_8);
        GameState gameState = new OptionsFromFileState(new GameOptions(), new Scanner(testFile));
        GameFromFileMain gameMain = new GameFromFileMain(gameState);
        while (!gameState.whichState().equals(GameStateName.FINISH)) {
            gameState = gameState.nextState();
        }
    }

    @Test
    public void verticalWinManualGame() throws IOException {
        String testFile = readFile("4_3_v.txt", StandardCharsets.UTF_8);
        GameState gameState = new OptionsState(new GameOptions(), new Scanner(testFile));
        GameMain gameMain = new GameMain(gameState);
        while (!gameState.whichState().equals(GameStateName.FINISH)) {
            gameState = gameState.nextState();
        }
    }


    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
