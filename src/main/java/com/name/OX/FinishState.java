package com.name.OX;

/**
 * @author Ola Podorska
 */
class FinishState implements GameState {
    @Override
    public GameState nextState() {
        System.exit(0);
        return null;
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.FINISH;
    }
}
