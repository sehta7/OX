package com.name.OX;

/**
 * @author Ola Podorska
 */
class NaughtRound implements Round {

    private Board board;
    private Player currentPlayer;
    private Player nextPlayer;

    public NaughtRound(Board board, Player currentPlayer, Player nextPlayer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
    }

    @Override
    public GameState nextState() {
        //TODO: question
        int chosenField = currentPlayer.choseField();
        Move move = new Move(chosenField, currentPlayer);
        return new CrossRound(board, nextPlayer, currentPlayer);
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_O;
    }
}
