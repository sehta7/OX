package com.name.OX;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ola Podorska
 */
class HorizontalChecker implements Checker{

    private GameOptions gameOptions;
    private Border border;

    public HorizontalChecker(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        border = new Border(gameOptions.whatIsBoardSize());
    }

    private List<Integer> initialize() {
        List<Integer> border = new ArrayList<>();
        for (int i = 1; i <= gameOptions.whatIsBoardSize() * gameOptions.whatIsBoardSize(); i++){
            if (i%gameOptions.whatIsBoardSize() == 0){
                border.add(i);
            }
        }
        return border;
    }

    @Override
    public boolean checkIfWin(List<Move> moves) {
        int boardSize = gameOptions.whatIsBoardSize();
        int winningSigns = gameOptions.howManySignsWin();

        for (Move move: moves
             ) {
            if (move.hasEnoughNeighbours(moves, winningSigns, border)){
                //TODO: check sequence in two rows
                //if ((move.getField() + winningSigns - 1)%boardSize == 0 ){
                    return true;
                //}
            }
        }

        return false;
    }

}
