package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class Player {

    private String name;
    private Scanner scanner;
    private Symbol symbol;

    Player(String playerName, Scanner scanner, Symbol symbol) {
        name = playerName;
        this.scanner = scanner;
        this.symbol = symbol;
    }

    String whichPlayer(){
        return name;
    }

    int choseField() {
        InputDataReader inputDataReader = new InputDataReader(scanner);
        DataInterpreter dataInterpreter = new DataInterpreter();
        return dataInterpreter.interpretField(inputDataReader.readField());
    }

    Symbol whichSymbolIsUse(){
        return symbol;
    }
}