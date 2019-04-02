package com.name.OX;

/**
 * @author Ola Podorska
 */
class CrossRound implements Round {

    private Board board;
    private Player currentPlayer;
    private Player nextPlayer;
    private BoardDrawer boardDrawer;

    public CrossRound(Board board, Player currentPlayer, Player nextPlayer, BoardDrawer boardDrawer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
        this.boardDrawer = boardDrawer;
    }

    @Override
    public GameState nextState() {
        //TODO: question
        int chosenField = currentPlayer.choseField();
        Move move = new Move(chosenField, currentPlayer);
        move.addObserver(boardDrawer);
        move.notifyAllObservers();
        return new NaughtRound(board, nextPlayer, currentPlayer, boardDrawer);
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_X;
    }
}
