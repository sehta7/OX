package com.name.OX;

/**
 * @author Ola Podorska
 */
interface GameState {

    GameState nextState();
    GameStateName whichState();
}