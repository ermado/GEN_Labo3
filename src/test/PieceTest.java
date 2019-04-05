import main.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    void numberOfPiecesShouldBeEight(){
        assertEquals(Piece.values().length, 8);

    }

    @Test
    void aPieceShouldHaveACorrectCorrespondantString(){
        Piece piece = Piece.BATTLESHIP;
        assertTrue(piece.toString() == "The battleship");

        piece = Piece.SCOTTIEDOG;
        assertTrue(piece.toString() != "The battleship");
        assertTrue(piece.toString() == "The Scottie Dog");

    }

}