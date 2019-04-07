package com.name.OX;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ola Podorska
 */
class Judge implements Observer {

    private List<Move> crossMoves = new ArrayList<>();
    private List<Move> naughtMoves = new ArrayList<>();
    private Checker checker;
    private GameOptions gameOptions;
    private Symbol winner = null;

    Judge(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    Symbol foundWinner() {
        return winner;
    }

    @Override
    public void update(Move move) {
        if (checkIfDraw()){

        }
        boolean horizontal, vertical, diagonal, antiDiagonal;
        if (move.checkPlayer().equals(Symbol.CROSS)){
            crossMoves.add(move);
            crossMoves.sort(new MoveComparator());
            checker = new HorizontalChecker(gameOptions);
            horizontal = checker.checkIfWin(crossMoves);
            checker = new VerticalChecker(gameOptions);
            vertical = checker.checkIfWin(crossMoves);
            checker = new DiagonalChecker(gameOptions);
            diagonal = checker.checkIfWin(crossMoves);
            checker = new AntiDiagonalChecker(gameOptions);
            antiDiagonal = checker.checkIfWin(crossMoves);
        } else{
            naughtMoves.add(move);
            naughtMoves.sort(new MoveComparator());
            checker = new HorizontalChecker(gameOptions);
            horizontal = checker.checkIfWin(naughtMoves);
            checker = new VerticalChecker(gameOptions);
            vertical = checker.checkIfWin(naughtMoves);
            checker = new DiagonalChecker(gameOptions);
            diagonal = checker.checkIfWin(naughtMoves);
            checker = new AntiDiagonalChecker(gameOptions);
            antiDiagonal = checker.checkIfWin(naughtMoves);
        }
        if (horizontal || vertical ||diagonal || antiDiagonal){
            winner = move.checkPlayer();
        }
    }

    boolean checkIfDraw() {
        return ((crossMoves.size() + naughtMoves.size()) == (gameOptions.whatIsBoardSize() * gameOptions.whatIsBoardSize()));
    }
}
