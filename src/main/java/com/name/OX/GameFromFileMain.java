package com.name.OX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class GameFromFileMain {

    private static GameState currentState;

    GameFromFileMain(GameState currentState) {
        this.currentState = currentState;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Olka\\Desktop\\4_3_h.txt");
        try {
            GameFromFileMain gameMain = new GameFromFileMain(new OptionsFromFileState(new GameOptions(), new Scanner(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (!currentState.whichState().equals(GameStateName.FINISH)){
            currentState = currentState.nextState();
        }
    }
}