package com.name.OX;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ola Podorska
 */
//TODO: implement
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
        boolean horizontal;
        if (move.checkPlayer().equals(Symbol.CROSS)){
            crossMoves.add(move);
            crossMoves.sort(new MoveComparator());
            checker = new HorizontalChecker(gameOptions);
            horizontal = checker.checkIfWin(crossMoves);
        } else{
            naughtMoves.add(move);
            naughtMoves.sort(new MoveComparator());
            checker = new HorizontalChecker(gameOptions);
            horizontal = checker.checkIfWin(naughtMoves);
        }
        /*checker = new VerticalChecker();
        boolean vertical = checker.checkIfWin(crossMoves);
        checker = new DiagonalChecker();
        boolean diagonal = checker.checkIfWin(crossMoves);*/
        boolean vertical = false;
        boolean diagonal = false;
        if (horizontal || vertical ||diagonal){
            winner = move.checkPlayer();
        }
    }
}
