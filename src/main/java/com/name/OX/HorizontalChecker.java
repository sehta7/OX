package com.name.OX;

import java.util.List;

/**
 * @author Ola Podorska
 */
class HorizontalChecker implements Checker {

    private GameOptions gameOptions;

    HorizontalChecker(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    @Override
    public boolean checkIfWin(List<Move> moves) {
        int winningSigns = gameOptions.howManySignsWin();

        for (Move move : moves
        ) {
            if (hasEnoughNeighbours(move, moves, winningSigns)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasEnoughNeighbours(Move move, List<Move> moves, int winningSigns) {
        int index = moves.indexOf(move);
        int toCheck = winningSigns - 1;
        boolean hasEnoughNeighbours = false;
        if (moves.size() < winningSigns) {
            return false;
        }
        if (index <= (moves.size() - winningSigns)) {
            Move current = moves.get(index);
            for (int i = 0; i < winningSigns - 1; i++) {
                Move next = hasNext(current, moves);
                if (!current.equals(next)) {
                    toCheck--;
                }
                current = next;
            }
        }
        if (toCheck == 0) {
            hasEnoughNeighbours = true;
        }
        return hasEnoughNeighbours;
    }

    private Move hasNext(Move field, List<Move> moves) {
        for (Move move : moves
        ) {
            if ((field.getField() + 1) == move.getField()) {
                return move;
            }
        }
        return field;
    }

}
