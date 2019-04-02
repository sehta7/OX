package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class Player {

    private String name;
    private Scanner scanner;

    Player(String playerName, Scanner scanner) {
        name = playerName;
        this.scanner = scanner;
    }

    String whichPlayer(){
        return name;
    }

    int choseField() {
        InputDataReader inputDataReader = new InputDataReader(scanner);
        DataInterpreter dataInterpreter = new DataInterpreter();
        return dataInterpreter.interpretField(inputDataReader.readField());
    }
}