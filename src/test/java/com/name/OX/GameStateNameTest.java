package com.name.OX;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Ola Podorska
 */

@Test
public class GameStateNameTest {

    public void testIfGameStateReturnsNameOfOptionsState() {
        GameStateName options = GameStateName.OPTIONS;
        assert (options.toString().equals("Options in game")) : "Enum does not return proper string for options";
    }

    public void testIfGameStateReturnsNameOfDefaultOptionsState() {
        GameStateName options = GameStateName.DEF_OPTIONS;
        assert (options.toString().equals("Default options")) : "Enum does not return proper string for default options";
    }

    public void testIfGameStateReturnsNameOfStartState() {
        GameStateName options = GameStateName.START;
        assert (options.toString().equals("Game is starting")) : "Enum does not return proper string for game start";
    }

    public void testIfGameStateReturnsNameOfRoundOState() {
        GameStateName options = GameStateName.ROUND_O;
        assert (options.toString().equals("Play naught player")) : "Enum does not return proper string for naught round";
    }

    public void testIfGameStateReturnsNameOfRoundXState() {
        GameStateName options = GameStateName.ROUND_X;
        assert (options.toString().equals("Play cross player")) : "Enum does not return proper string for cross round";
    }

    public void testIfGameStateReturnsNameOfFinishState() {
        GameStateName options = GameStateName.FINISH;
        assert (options.toString().equals("Game is ended")) : "Enum does not return proper string for cross round";
    }

}