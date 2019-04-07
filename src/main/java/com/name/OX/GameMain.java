package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class GameMain {

    private static GameState currentState;

    GameMain(GameState currentState) {
        this.currentState = currentState;
    }

    public static void main(String[] args) {
        GameMain gameMain = new GameMain(new OptionsState(new GameOptions(), new Scanner(System.in)));
        while (!currentState.whichState().equals(GameStateName.FINISH)){
            currentState = currentState.nextState();
        }
    }
}