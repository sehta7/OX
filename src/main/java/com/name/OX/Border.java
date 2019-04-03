package com.name.OX;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ola Podorska
 */
class Border {

    private List<Integer> border;

    Border(int boardSize) {
        border = new ArrayList<>();
        for (int i = 0; i < boardSize * boardSize; i ++){
            if (i%boardSize == 0){
                border.add(i);
            }
        }
    }

    boolean isPassed(Move move){
        for (Integer field: border
             ) {
            if (field == move.getField()){
                return true;
            }
        }
        return false;
    }
}
