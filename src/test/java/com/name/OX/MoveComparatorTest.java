package com.name.OX;

import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

@Test
public class MoveComparatorTest {

    @Test(dataProviderClass = DP.class, dataProvider = "sortMoves")
    public void testIfTwoMovesAreCompareInAscendingOrder(int first, int second, int result) {
        Move firstMove = new Move(first, new Player("player1", new Scanner(System.in)));
        Move secondMove = new Move(second, new Player("player2", new Scanner(System.in)));
        MoveComparator moveComparator = new MoveComparator();
        assert (moveComparator.compare(firstMove, secondMove) == result) : "Moves are not sorted properly";
    }
}