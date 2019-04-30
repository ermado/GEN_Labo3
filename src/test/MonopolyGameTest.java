import main.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonopolyGameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final Logger LOG = Logger.getLogger("log");

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        LOG.info("Out.deviated");
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        LOG.info("Out.restored");
    }

    @Test
    public void aNewMonopolyGameShouldWork() {
        MonopolyGame mgame = new MonopolyGame(4);
        try {
            mgame.playGame();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // better test?
    }

    @Test
    public void aNewMonopolyGameShouldNotWorkIfNotEnoughPlayers() {
        MonopolyGame mgame = new MonopolyGame(1);
        mgame.playGame();
        assertEquals("------Playing the game!------\r\n" +
                      "Sorry not enough players to play the game\r\n" +
                      "------End of the game!-------\r\n", outContent.toString());
    }

}
