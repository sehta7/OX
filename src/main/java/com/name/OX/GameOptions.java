package com.name.OX;

/**
 * @author Ola Podorska
 */
class GameOptions {

    private Language language;
    private Players players;
    private int boardSize;
    private int winningSigns;
    private Player naughtPlayer;
    private Player crossPlayer;

    void configure(Language language, Players players, int boardSize, int winningSigns) {
        this.language = language;
        this.players = players;
        this.boardSize = boardSize;
        this.winningSigns = winningSigns;
        naughtPlayer = players.findNaught();
        crossPlayer = players.findCross();
    }

    int whatIsBoardSize(){
        return boardSize;
    }

    int howManySignsWin(){
        return winningSigns;
    }

    Player whoIsNaught(){
        return naughtPlayer;
    }

    Player whoIsCross(){
        return crossPlayer;
    }

    Language whatIsLanguage(){return language;}

    public Players setPlayers() {
        return players;
    }

    void saveScores(Player player) {
        if (player.whichSymbolIsUse().equals(Symbol.CROSS)){
            players.addScoresToCrossPlayer(player.checkPoints());
        } else {
            players.addScoresToNaughtPlayer(player.checkPoints());
        }
    }

    Player whoWonGame(){
        return players.whoWon();
    }
}