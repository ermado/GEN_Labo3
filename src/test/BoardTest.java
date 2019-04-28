import main.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class BoardTest {

    @Test
    void createTheBoard(){

        try {
            Board board = new Board();
            System.out.println(board.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //assertEquals(Piece.values().length, 8);

    }
}