package com.name.OX;

/**
 * @author Ola Podorska
 */
class StartState implements GameState {

    private GameOptions gameOptions;
    private int counter;
    private Board board;

    StartState(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        counter = 0;
        board = new Board(gameOptions.whatIsBoardSize());
        board.initialize();
    }

    @Override
    public GameState nextState() {
        return playMatches(3);
    }

    private GameState playMatches(int gameMatches) {
        Round round = null;
        if (counter < gameMatches){
            if (counter%2 == 0){
                round = new NaughtRound(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions));
            } else{
                round = new CrossRound(board, gameOptions, new BoardDrawer(board), new Judge(gameOptions));
            }
        }
        counter++;
        return round;
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.START;
    }
}
