package com.name.OX;

/**
 * @author Ola Podorska
 */
class StartState implements GameState {

    private GameOptions gameOptions;
    private int counter;
    private Board board;

    StartState(GameOptions gameOptions, int counter) {
        this.gameOptions = gameOptions;
        this.counter = counter;
        board = new Board(gameOptions.whatIsBoardSize());
        board.initialize();
    }

    @Override
    public GameState nextState() {
        if(counter < 3) {
            Round round;
            //TODO:: Co jezeli ktos chcialby zeby X zaczynal gre?
            if(counter % 2 == 0) {
                round = new NaughtRound(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions), counter);
            } else {
                round = new CrossRound(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions), counter);
            }
            return round;
        }
        return new FinishState();
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.START;
    }
}
