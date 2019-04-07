package com.name.OX;

/**
 * @author Ola Podorska
 */
class Players {

    private Player naughtPlayer;
    private Player crossPlayer;

    Players(Player naughtPlayer, Player crossPlayer) {
        this.naughtPlayer = naughtPlayer;
        this.crossPlayer = crossPlayer;
    }

    Player findNaught() {
        return naughtPlayer;
    }

    Player findCross() {
        return crossPlayer;
    }
}