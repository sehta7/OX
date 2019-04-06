package com.name.OX;

/**
 * @author Ola Podorska
 */
class CrossRound implements Round {

    private Board board;
    private Player currentPlayer;
    private BoardDrawer boardDrawer;
    private Judge judge;
    private GameOptions gameOptions;
    private int counter;

    //TODO:: public
    public CrossRound(Board board, GameOptions gameOptions, BoardDrawer boardDrawer, Judge judge, int counter) {
        this.board = board;
        this.boardDrawer = boardDrawer;
        this.gameOptions = gameOptions;
        this.judge = judge;
        this.counter = counter;
        currentPlayer = gameOptions.whoIsCross();
    }

    @Override
    public GameState nextState() {
        //TODO: question
        int chosenField = currentPlayer.choseField();
        Move move = new Move(chosenField, currentPlayer);
        move.addObserver(boardDrawer);
        move.addObserver(judge);
        move.notifyAllObservers();
        if(judge.foundWinner() != null) {
            System.out.println("Winner");
            return new StartState(gameOptions, ++counter);
        } else {
            return new NaughtRound(board, gameOptions, boardDrawer, judge, counter);
        }
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_X;
    }
}
