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
        for (int i = counter; i < gameMatches; i++){
            if (i%2 == 1){
                round = new NaughtRound(board, gameOptions.whoPlays());
            } else{
                round = new CrossRound(board, gameOptions.whoPlays());
            }
        }
        return round;
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.START;
    }
}
