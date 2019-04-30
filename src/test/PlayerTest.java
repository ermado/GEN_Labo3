import main.Board;
import main.Die;
import main.Piece;
import main.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


public class PlayerTest {

    Board board;
    ArrayList<Die> dices;
    private static final Logger LOG = Logger.getLogger("log");

    @BeforeEach
    void createTheBoardAndTheDices() {

        try {
            board = new Board();
            //System.out.println(board.toString());
            LOG.info("Board Created");

            Die d1 = new Die();
            Die d2 = new Die();
            dices = new ArrayList<Die>();
            dices.add(d1);
            dices.add(d2);
            LOG.info("Dices Created");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void aPlayerIsCreatedInAGameBoard() {
        Player player = new Player(Piece.CAT,dices,board);
        assertEquals("0 GO!",player.getLocation().toString());
        assertEquals("The cat",player.getName());

    }

    public void aPlayerCanMoveIntoTheBoard() {
        Player player = new Player(Piece.CAT,dices,board);
        assertEquals("0 GO!",player.getLocation().toString());

    }
}