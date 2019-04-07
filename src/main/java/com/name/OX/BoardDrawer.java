package com.name.OX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ola Podorska
 */
class BoardDrawer implements Observer {

    private Board board;
    private List<Move> moves = new ArrayList<>();

    BoardDrawer(Board board) {
        this.board = board;
    }

    //TODO: refactor!!
    void drawBoard() {
        int boardSize = board.getBoardSize();
        for (int i = 1; i <= boardSize * boardSize; i++) {
            System.out.print("|");
            if (!moves.isEmpty()) {
                Move move = findMoveToDraw(i);
                if (move != null){
                    drawPlayerSymbols(move);
                } else {
                    if (i >= 10 && i < 100){
                        System.out.print("  " + i + " ");
                    } else if(i >= 100) {
                        System.out.print(" " + i + " ");
                    } else if(i < 10){
                        System.out.print("  " + i + "  ");
                    }
                }
            } else{
                if (i >= 10 && i < 100){
                    System.out.print(" " + i + " ");
                } else if(i >= 100) {
                    System.out.print("" + i + "");
                } else{
                    System.out.print(" " + i + "  ");
                }
            }
            if (i % boardSize == 0) {
                System.out.print("|");
                System.out.println();
                String pause = " -----";
                System.out.println(String.join("", Collections.nCopies(boardSize, pause)));
            }
        }
    }

    private Move findMoveToDraw(int i) {
        for (Move move : moves
        ) {
            if (move.getField() == i) {
                return move;
            }
        }
        return null;
    }

    private void drawPlayerSymbols(Move move) {
        if (move.checkPlayer().equals(Symbol.CROSS)) {
            System.out.print("  X  ");
        } else {
            System.out.print("  O  ");
        }
    }

    @Override
    public void update(Move move) {
        moves.add(move);
        drawBoard();
    }
}
