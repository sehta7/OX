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
public class OptionsStateTest {

    //TODO: finish test with next state
    //TODO: remove file path
    public void testIfOptionsStateGoToStartState() {
        File file = new File("/home/ola/Desktop/options_state_test.txt");
        GameState optionsState = null;
        try {
            optionsState = new OptionsState(new GameOptions(), new Scanner(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        GameState gameState = optionsState.nextState();
    }

    @Test
    public void testIfOptionsStateKnowsItsState() {
        File file = new File("/home/ola/Desktop/options_state_test.txt");
        GameState optionsState = null;
        try {
            optionsState = new OptionsState(new GameOptions(), new Scanner(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        GameStateName gameStateName = optionsState.whichState();
        assert (gameStateName.equals(GameStateName.OPTIONS)) : "Options state does not know its state";
    }
}