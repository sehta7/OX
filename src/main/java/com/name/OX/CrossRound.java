package com.name.OX;

/**
 * @author Ola Podorska
 */
class CrossRound implements Round {

    private Board board;
    private Player currentPlayer;

    public CrossRound(Board board, Players players) {
        this.board = board;
        currentPlayer = players.findCross();
    }

    @Override
    public GameState nextState() {
        return null;
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_X;
    }
}
