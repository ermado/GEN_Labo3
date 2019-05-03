/* ------------------------------------------------------
GEN- LAB 3
File : PlayerTest
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the tests on the Player class.

        To verify the correct implementation of the takeTurn()
        method, we created a internal class PipedDie to create
        dices that will give a face with a defined value at
        every turn, by overriding the roll() method.

---------------------------------------------------------*/

package ermado.labo03;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private static final int MONEYBEFOREGOSQUARE = 0;
    private static final int MONEYAFTERGOSQUARE = 200;
    private static final int MONEYRICHPLAYER = 5500;
    private static final int MONEYPOORPLAYER = 300;
    private static final int MAXIMUMTAXES = 200;

    private class PipedDie extends Die {

        private int value;

        public PipedDie( int value){
            this.value = value;
        }

        @Override
        public void roll() {
            this.faceValue = value;
        }
    }
    private Board board;
    private Cup cup;
    private static final Logger LOG = Logger.getLogger("log");


    /**
     * We use the same board and piped dices for the following tests
     */
    @BeforeEach
    void createTheBoardAndTheDices() {

        try {
            board = new Board();
            LOG.info("Board Created");

            ArrayList<Die> pipedDices = new ArrayList<>();
            Die d1 = new PipedDie(3);
            Die d2 = new PipedDie(3);
            pipedDices.add(d1);
            pipedDices.add(d2);
            cup = new Cup(2);
            cup.setDices(pipedDices);
            LOG.info("Dices Created");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void aPlayerIsCreatedInAGameBoard() {
        Player player = new Player(Piece.CAT, cup, board);
        assertEquals("0 GO!",player.getLocation().toString());
        assertEquals("The cat",player.getName());

    }
    @Test
    public void aPlayerCanMoveIntoTheBoard() {
        Player player = new Player(Piece.CAT, cup, board);
        /* This pipedDie always give 3, so with two dices we should always move 6 squares at the time*/
        player.takeTurn();
        assertEquals("6 Oriental Avenue",player.getLocation().toString());
        player.takeTurn();
        assertEquals("12 Electric Company",player.getLocation().toString());
    }

    @Test
    public void aPlayerThatLandOnaGTJSquareShouldBeSentToJail() {
        ArrayList<Die> pipedDices = new ArrayList<>();
        Die d1 = new PipedDie(15);
        Die d2 = new PipedDie(15);
        pipedDices.add(d1);
        pipedDices.add(d2);
        cup = new Cup(2);
        cup.setDices(pipedDices);

        Player player = new Player(Piece.CAT, cup, board);
        player.takeTurn();
        assertEquals("10 Jail", player.getLocation().toString());
    }

    @Test
    public void aPlayerThatLandOnaGoSquareShouldReceiveMoney() {
        ArrayList<Die> pipedDices = new ArrayList<Die>();
        Die d1 = new PipedDie(20);
        Die d2 = new PipedDie(20);
        pipedDices.add(d1);
        pipedDices.add(d2);
        cup = new Cup(2);
        cup.setDices(pipedDices);

        Player player = new Player(Piece.CAT, cup, board);
        assertEquals(MONEYBEFOREGOSQUARE, player.getCash());
        player.takeTurn();
        assertEquals("0 GO!", player.getLocation().toString());
        assertEquals(MONEYAFTERGOSQUARE, player.getCash());
        player.takeTurn();
        assertEquals(MONEYAFTERGOSQUARE * 2, player.getCash());
    }

    @Test
    public void aRichPlayerThatLandOnaTaxSquareShouldBeTaxedMaximalValue() {
        ArrayList<Die> pipedDices = new ArrayList<Die>();
        Die d1 = new PipedDie(1);
        Die d2 = new PipedDie(2);
        pipedDices.add(d1);
        pipedDices.add(d2);
        cup = new Cup(2);
        cup.setDices(pipedDices);

        Player player = new Player(Piece.CAT, cup, board);
        player.setCash(MONEYRICHPLAYER);

        player.takeTurn();
        assertEquals("3 Income Tax", player.getLocation().toString());
        assertEquals(MONEYRICHPLAYER - MAXIMUMTAXES, player.getCash());
    }

    @Test
    public void aPoorPlayerThatLandOnaTaxSquareShouldBeTaxedProportionally() {
        ArrayList<Die> pipedDices = new ArrayList<Die>();
        Die d1 = new PipedDie(1);
        Die d2 = new PipedDie(2);
        pipedDices.add(d1);
        pipedDices.add(d2);
        cup = new Cup(2);
        cup.setDices(pipedDices);

        Player player = new Player(Piece.CAT, cup, board);
        player.setCash(MONEYPOORPLAYER);

        player.takeTurn();
        assertEquals("3 Income Tax", player.getLocation().toString());
        assertEquals(MONEYPOORPLAYER - (MONEYPOORPLAYER * 0.1), player.getCash());
    }

}