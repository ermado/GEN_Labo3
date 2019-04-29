import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BoardTest {

    Board board;
    private static final Logger LOG = Logger.getLogger("log");

    @BeforeEach
    void createTheBoard() {

        try {
            board = new Board();
            //System.out.println(board.toString());
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
    void getASquareAfterADeplacement() {
        Square sq = board.getStartSquare();

        sq = board.getSquare(sq, 1);
        assertEquals(sq.toString(), "1 Community Chest");

        sq = board.getSquare(sq, 2);
        assertEquals(sq.toString(), "3 Income Tax");

        sq = board.getSquare(sq, 12);
        assertEquals(sq.toString(), "15 Pennsylvania Railroad");
    }


    @Test
    void getASquareAfterADeplacementInBoardLimits() {
        Square sq = board.getStartSquare();

        sq = board.getSquare(sq, 19);
        assertEquals(sq.toString(), "19 New York Avenue");

        sq = board.getSquare(sq, 20);
        assertEquals(sq.toString(), "39 Boadwalk");

        sq = board.getSquare(sq, 4);
        assertEquals(sq.toString(), "3 Income Tax");
    }

}