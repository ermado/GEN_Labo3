import main.*;
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

    @Test
    void aPieceCanChangeLocation(){
        Square first = new Square("First");
        Square last = new Square("Last");

        Piece piece = Piece.BATTLESHIP;
        piece.setLocation(first);
        assertSame(piece.getLocation().toString(), "First");

        piece.setLocation(last);
        assertSame(piece.getLocation().toString(),"Last");

    }

}