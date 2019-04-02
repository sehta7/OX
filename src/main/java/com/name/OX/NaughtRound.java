package com.name.OX;

/**
 * @author Ola Podorska
 */
class NaughtRound implements Round {

    private Board board;
    private Player currentPlayer;

    public NaughtRound(Board board, Players players) {
        this.board = board;
        currentPlayer = players.findNaught();
    }

    @Override
    public GameState nextState() {
        return null;
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_O;
    }
}
