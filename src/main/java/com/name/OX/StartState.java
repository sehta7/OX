package com.name.OX;

/**
 * @author Ola Podorska
 */
class StartState implements GameState {

    private GameOptions gameOptions;
    private int counter;
    private Board board;
    private BoardDrawer boardDrawer;

    StartState(GameOptions gameOptions, int counter) {
        this.gameOptions = gameOptions;
        this.counter = counter;
        board = new Board(gameOptions.whatIsBoardSize());
        board.initialize();
        this.boardDrawer = new BoardDrawer(board);
    }

    @Override
    public GameState nextState() {
        if (counter < 3){
            Round round;
            if (counter % 2 == 0) {
                boardDrawer.drawEmptyBoard();
                round = new NaughtRound(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions), counter);
            } else {
                boardDrawer.drawEmptyBoard();
                round = new CrossRound(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions), counter);
            }
            return round;
        }
        Player gameWinner = findWinner();
        System.out.println("Winner is " + gameWinner);
        return new FinishState();
    }

    private Player findWinner() {
        return gameOptions.whoWonGame();
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.START;
    }
}
