package com.name.OX;

/**
 * @author Ola Podorska
 */
class NaughtRound implements Round {

    private Board board;
    private Player currentPlayer;
    private Player nextPlayer;
    private BoardDrawer boardDrawer;

    public NaughtRound(Board board, Player currentPlayer, Player nextPlayer, BoardDrawer boardDrawer) {
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
        return new CrossRound(board, nextPlayer, currentPlayer, boardDrawer);
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_O;
    }
}
