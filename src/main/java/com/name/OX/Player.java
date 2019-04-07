package com.name.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class Player {

    private String name;
    private Scanner scanner;
    private Symbol symbol;

    Player(String playerName, Scanner scanner) {
        name = playerName;
        this.scanner = scanner;
    }

    String whichPlayer(){
        return name;
    }

    int choseField(Displayer displayer) {
        InputDataReader inputDataReader = new InputDataReader(scanner, displayer);
        DataInterpreter dataInterpreter = new DataInterpreter();
        return dataInterpreter.interpretField(inputDataReader.readField());
    }

    void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    Symbol whichSymbolIsUse(){
        return symbol;
    }

    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
}