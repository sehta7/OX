package com.name.OX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ola Podorska
 */
class Board {

    private int boardSize;
    private List<Move> occupiedFields;
    private List<Integer> emptyFields;

    Board(int boardSize){
        this.boardSize = boardSize;
        occupiedFields = new ArrayList<>();
        emptyFields = new ArrayList<>();
    }

    Board initialize(){
        for (int i = 0; i < boardSize * boardSize; i++){
            emptyFields.add(i);
        }
        return this;
    }

    int getBoardSize(){
        return boardSize;
    }

    List<Move> getOccupiedFields(){
        return occupiedFields;
    }
}
