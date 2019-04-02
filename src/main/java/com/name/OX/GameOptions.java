package com.name.OX;

/**
 * @author Ola Podorska
 */
class GameOptions {

    private Language language;
    private Players players;
    private int boardSize;
    private int winningSigns;

    void configure(Language language, Players players, int boardSize, int winningSigns) {
        this.language = language;
        this.players = players;
        this.boardSize = boardSize;
        this.winningSigns = winningSigns;
    }

    int whatIsBoardSize(){
        return boardSize;
    }
}