package com.name.OX;

/**
 * @author Ola Podorska
 */
class StartFromFileState implements GameState {

    private GameOptions gameOptions;
    private int counter;
    private Board board;

    StartFromFileState(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        this.counter = counter;
        board = new Board(gameOptions.whatIsBoardSize());
        board.initialize();
    }

    @Override
    public GameState nextState() {
        //while (true){
         return new FromFileRound(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions), counter);
        //}
    }

    private Player findWinner() {
        return gameOptions.whoWonGame();
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.START;
    }
}
