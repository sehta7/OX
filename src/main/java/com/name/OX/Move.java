package com.name.OX;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ola Podorska
 */
class Move {

    private int chosenField;
    private Player whoseMove;
    List<Observer> observers = new ArrayList<>();

    Move(int chosenField, Player whoseMove) {
        this.chosenField = chosenField;
        this.whoseMove = whoseMove;
    }

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    int getField() {
        return chosenField;
    }

    Symbol checkPlayer() {
        return whoseMove.whichSymbolIsUse();
    }

    public boolean hasEnoughNeighbours(List<Move> moves, int winningSigns, Border border) {
        List<Move> winningSequence = new ArrayList<>();
        int index = moves.indexOf(this);
        int toCheck = winningSigns;
        boolean hasEnoughNeighbours = false;
        if (moves.size() < winningSigns) {
            return false;
        }
        if (index <= (moves.size() - winningSigns)) {
            for (int i = 0; i < winningSigns; i++) {
                if (moves.get(index + i).chosenField == (this.chosenField + i)) {
                    if (border.isPassed(moves.get(index + i))){
                        return false;
                    }
                    winningSequence.add(moves.get(index + i));
                    toCheck--;
                }
            }
        }
        if (toCheck == 0) {
            hasEnoughNeighbours = true;
        }
        return hasEnoughNeighbours;
    }
}
