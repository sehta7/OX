package com.name.OX;

/**
 * @author Ola Podorska
 */
class Player {

    private String name;

    Player(String playerName) {
        name = playerName;
    }

    String whichPlayer(){
        return name;
    }
}