package com.name.OX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
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
        Scanner scanner = new Scanner(System.in);
        String size = scanner.nextLine();
        String win = scanner.nextLine();
        String type = scanner.nextLine();
        String name = "" + size + "_" + win + "_" + type + ".txt";
        File file = new File("/home/ola/Desktop/" + name);

        try {
            GameFromFileMain gameMain = new GameFromFileMain(new OptionsFromFileState(new GameOptions(), new Scanner(file)));
            while (!currentState.whichState().equals(GameStateName.FINISH)) {
                currentState = currentState.nextState();
            }
        } catch (NoSuchElementException exception) {
            System.exit(0);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}