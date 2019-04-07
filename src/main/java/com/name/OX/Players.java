package com.name.OX;

/**
 * @author Ola Podorska
 */
class Players {

    private Player naughtPlayer;
    private Player crossPlayer;
    private int naughtPlayerScores;
    private int crossPlayerScores;

    Players(Player naughtPlayer, Player crossPlayer) {
        this.naughtPlayer = naughtPlayer;
        this.crossPlayer = crossPlayer;
        naughtPlayerScores = 0;
        crossPlayerScores = 0;
    }

    Player findNaught() {
        return naughtPlayer;
    }

    Player findCross() {
        return crossPlayer;
    }

    int addScoresToNaughtPlayer(int score){
        naughtPlayerScores += score;
        return naughtPlayerScores;
    }

    int addScoresToCrossPlayer(int score){
        crossPlayerScores += score;
        return crossPlayerScores;
    }

    Player whoWon(){
        if (naughtPlayerScores > crossPlayerScores){
            return naughtPlayer;
        } else {
            return crossPlayer;
        }
    }
}