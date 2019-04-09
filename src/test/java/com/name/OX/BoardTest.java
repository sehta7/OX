package com.name.OX;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class BoardTest {

    @Test(dataProviderClass = DP.class, dataProvider = "boardSize")
    public void testIfBoardIsInitialized(String size) {
        Board board = new Board(Integer.parseInt(size));
        board.initialize();
        assert (board.getEmptyFields().size() == Integer.parseInt(size) * Integer.parseInt(size)) : "Board was not initialized";
    }

    @Test(dataProviderClass = DP.class, dataProvider = "boardSize")
    public void testIfBoardSizeIsSave(String size) {
        Board board = new Board(Integer.parseInt(size));
        assert (board.getBoardSize() == Integer.parseInt(size)) : "Board size is not proper";
    }
}