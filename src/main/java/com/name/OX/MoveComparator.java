package com.name.OX;

import java.util.Comparator;

/**
 * @author Ola Podorska
 */
class MoveComparator implements Comparator<Move> {

    @Override
    public int compare(Move move1, Move move2) {
        return move1.getField() - move2.getField();
    }
}
