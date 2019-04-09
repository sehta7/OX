package com.name.OX;

/**
 * @author Ola Podorska
 */
class StartFromFileState implements GameState {

    private GameOptions gameOptions;
    private int counter;
    private Board board;

    StartFromFileState(GameOptions gameOptions, int counter) {
        this.gameOptions = gameOptions;
        this.counter = counter;
        board = new Board(gameOptions.whatIsBoardSize());
        board.initialize();
    }

    @Override
    public GameState nextState() {
        Round round;
        if (counter % 2 == 0) {
            round = new NaughtRoundFromFile(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions), counter);
        } else {
            round = new CrossRoundFromFile(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions), counter);
        }
        return round;
    }

    private Player findWinner() {
        return gameOptions.whoWonGame();
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.START;
    }
}
