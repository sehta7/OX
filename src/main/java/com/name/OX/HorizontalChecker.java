package com.name.OX;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ola Podorska
 */
class HorizontalChecker implements Checker {

    private GameOptions gameOptions;
    private Border border;

    //TODO:: public?
    public HorizontalChecker(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        border = new Border(gameOptions.whatIsBoardSize());
    }

    @Override
    public boolean checkIfWin(List<Move> moves) {
        int winningSigns = gameOptions.howManySignsWin();

        for (Move move : moves
        ) {
            if(hasEnoughNeighbours(move, moves, winningSigns)) {
                //TODO: check sequence in two rows
                return true;
            }
        }

        return false;
    }

    private boolean hasEnoughNeighbours(Move move, List<Move> moves, int winningSigns) {
        List<Move> winningSequence = new ArrayList<>();
        int index = moves.indexOf(move);
        int toCheck = winningSigns;
        boolean hasEnoughNeighbours = false;
        if(moves.size() < winningSigns) {
            return false;
        }
        if(index <= (moves.size() - winningSigns)) {
            for (int i = 0; i < winningSigns; i++) {
                if(moves.get(index + i).getField() == (move.getField() + i)) {
                    if(border.isPassed(moves.get(index + i))) {
                        return false;
                    }
                    winningSequence.add(moves.get(index + i));
                    toCheck--;
                }
            }
        }
        if(toCheck == 0) {
            hasEnoughNeighbours = true;
        }
        return hasEnoughNeighbours;
    }

}
