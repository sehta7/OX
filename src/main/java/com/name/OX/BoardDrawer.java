package com.name.OX;

import java.util.Collections;
import java.util.Map;

/**
 * @author Ola Podorska
 */
class BoardDrawer {

    private Board board;

    BoardDrawer(Board board) {
        this.board = board;
    }

    //TODO: refactor!!
    void drawBoard(Board board){
        this.board = board;
        int boardSize = board.getBoardSize();
        for (int i = 1; i <= boardSize * boardSize; i ++){
            System.out.print("| ");
            if (board.areFieldsToDraw()){
                drawPlayerSymbols(board, i);
            } else{
                System.out.print("" + i);
            }
            System.out.print(" ");
            if (i%boardSize == 0){
                System.out.print("|");
                System.out.println();
                String pause = " ---";
                System.out.println(String.join("", Collections.nCopies(3, pause)));
            }
        }
    }

    private void drawPlayerSymbols(Board board, int i) {
        for (Map.Entry<Integer, Player> entry : board.getOccupiedFields().entrySet()
             ) {
            if (entry.getKey() == i){
                if (entry.getValue().whichSymbolIsUse().equals(Symbol.CROSS)){
                    System.out.print("X");
                } else{
                    System.out.print("O");
                }
            }
        }
    }
}
