package com.name.OX;

/**
 * @author Ola Podorska
 */
class FromFileRound implements Round {

    private Board board;
    private Player currentPlayer;
    private BoardDrawer boardDrawer;
    private Judge judge;
    private GameOptions gameOptions;
    private int counter;

    FromFileRound(Board board, GameOptions gameOptions, BoardDrawer boardDrawer, Judge judge, int counter) {
        this.board = board;
        this.boardDrawer = boardDrawer;
        this.gameOptions = gameOptions;
        this.judge = judge;
        currentPlayer = gameOptions.whoIsNaught();
        this.counter = counter;
    }

    @Override
    public GameState nextState() {
        Displayer displayer = new Displayer(gameOptions.whatIsLanguage());
        displayer.displayQuestionAboutField();
        int chosenField = currentPlayer.choseField(displayer);
        Move move = new Move(chosenField, currentPlayer);
        move.addObserver(boardDrawer);
        move.addObserver(judge);
        move.notifyAllObservers();
        if (judge.checkIfDraw()){
            gameOptions.saveDraw();
            displayer.displayDraw();
            return new StartFromFileState(gameOptions);
        }
        if (judge.foundWinner() != null){
            currentPlayer.win();
            gameOptions.saveScores(currentPlayer);
            displayer.displayScore(currentPlayer);
            displayer.displayNewRound();
            return new StartFromFileState(gameOptions);
        } else{
            return new FromFileRound(board, gameOptions, boardDrawer, judge, counter);
        }
    }

    @Override
    public GameStateName whichState() {
        return GameStateName.ROUND_O;
    }
}
