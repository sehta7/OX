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
}
