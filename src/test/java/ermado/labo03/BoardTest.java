/* ------------------------------------------------------
GEN- LAB 3
File : BoardTest
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the tests on the Board class.

---------------------------------------------------------*/
package ermado.labo03;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;
    private static final Logger LOG = Logger.getLogger("log");

    /**
     * We will use the same board for each test instead of creating new ones
     */
    @BeforeEach
    void createTheBoard() {
        try {
            board = new Board();
            LOG.info("Board Created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getTheFirstSquareOfTheBoard() {
        Square first = board.getStartSquare();
        assertEquals(first.toString(), "0 GO!");
    }

    @Test
    void getASquareAfterAMove() {
        Square sq = board.getStartSquare();

        sq = board.getRelativeSquare(sq, 1);
        assertEquals(sq.toString(), "1 Community Chest");

        sq = board.getRelativeSquare(sq, 2);
        assertEquals(sq.toString(), "3 Income Tax");

        sq = board.getRelativeSquare(sq, 12);
        assertEquals(sq.toString(), "15 Pennsylvania Railroad");
    }


    @Test
    void getASquareAfterAMoveInBoardLimits() {
        Square sq = board.getStartSquare();

        sq = board.getRelativeSquare(sq, 19);
        assertEquals(sq.toString(), "19 New York Avenue");

        sq = board.getRelativeSquare(sq, 20);
        assertEquals(sq.toString(), "39 Boadwalk");

        sq = board.getRelativeSquare(sq, 4);
        assertEquals(sq.toString(), "3 Income Tax");
    }

}