package com.name.OX;

/**
 * @author Ola Podorska
 */
class Move {

    private int chosenField;
    private Player whoseMove;

    public Move(int chosenField, Player whoseMove) {
        this.chosenField = chosenField;
        this.whoseMove = whoseMove;
    }
}
