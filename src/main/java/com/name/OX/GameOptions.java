package com.name.OX;

/**
 * @author Ola Podorska
 */
class GameOptions {

    private Language language;
    private Players players;
    private BoardSize boardSize;
    private int winningSigns;

    void configure(Language language, Players players, BoardSize boardSize, int winningSigns) {
        this.language = language;
        this.players = players;
        this.boardSize = boardSize;
        this.winningSigns = winningSigns;
    }
}