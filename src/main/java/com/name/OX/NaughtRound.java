package com.name.OX;

/**
 * @author Ola Podorska
 */
class NaughtRound implements Round {

    private Board board;
    private Player currentPlayer;
    private BoardDrawer boardDrawer;
    private Judge judge;
    private GameOptions gameOptions;

    public NaughtRound(Board board, GameOptions gameOptions, BoardDrawer boardDrawer, Judge judge) {
        this.board = board;
        this.boardDrawer = boardDrawer;
        this.gameOptions = gameOptions;
        this.judge = judge;
        currentPlayer = gameOptions.whoIsNaught();
    }

    @Override
    public GameState nextState() {
        //TODO: question
        int chosenField = currentPlayer.choseField();
        Move move = new Move(chosenField, currentPlayer);
        move.addObserver(boardDrawer);
        move.addObserver(judge);
        move.notifyAllObservers();
        //TODO: check winning sequence
        if (judge.foundWinner() != null){
            System.out.println("Winner");
            return new FinishState();
        } else{
            return new CrossRound(board, gameOptions, boardDrawer, judge);
        }
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_O;
    }
}
