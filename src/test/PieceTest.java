/* ------------------------------------------------------
GEN- LAB 3
File : PieceTest
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implement the tests on the Piece class.

---------------------------------------------------------*/

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    void numberOfPiecesShouldBeEight(){
        assertEquals(Piece.values().length, 8);
    }

    @Test
    void aPieceShouldHaveACorrectCorrespondentString(){
        Piece piece = Piece.BATTLESHIP;
        assertEquals("The battleship", piece.toString());

        piece = Piece.SCOTTIEDOG;
        assertNotEquals("The battleship", piece.toString());
        assertEquals("The Scottie Dog", piece.toString());
    }

    @Test
    void aPieceCanChangeLocation(){
        Square first = new Square("First", 1);
        Square last = new Square("Last", 3);

        Piece piece = Piece.BATTLESHIP;
        piece.setLocation(first);
        assertEquals("1 First", piece.getLocation().toString());
        piece.setLocation(last);
        assertEquals("3 Last", piece.getLocation().toString());
    }

}