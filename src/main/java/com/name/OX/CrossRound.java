package com.name.OX;

/**
 * @author Ola Podorska
 */
class CrossRound implements Round {

    private Board board;
    private Player currentPlayer;
    private Player nextPlayer;

    public CrossRound(Board board, Player currentPlayer, Player nextPlayer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
    }

    @Override
    public GameState nextState() {
        //TODO: question
        int chosenField = currentPlayer.choseField();
        Move move = new Move(chosenField, currentPlayer);
        return new NaughtRound(board, nextPlayer, currentPlayer);
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_X;
    }
}
