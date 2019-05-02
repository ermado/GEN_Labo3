/* ------------------------------------------------------
GEN- LAB 3
File : MonopolyGameTest
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the tests on the MonopolyGame class.

       To verify the correct out screens, before each test the
       system output is deviated to a byte array to verify
       its content. It is restored after each test.

---------------------------------------------------------*/

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
        try {
            MonopolyGame mgame = new MonopolyGame(4);
            mgame.playGame();
            LOG.info(outContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void aNewMonopolyGameShouldNotWorkIfNotEnoughPlayers() {
        try {
            MonopolyGame mgame = new MonopolyGame(1);
            mgame.playGame();
            assertEquals("------Playing the game!------\r\n" +
                    "Sorry, not enough players to play the game\r\n" +
                    "------End of the game!-------\r\n", outContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aNewMonopolyGameShouldNotWorkIfTooManyPlayers() {
        try {
            MonopolyGame mgame = new MonopolyGame(10);
            mgame.playGame();
            assertEquals("------Playing the game!------\r\n" +
                    "Sorry, too many players to play the game\r\n" +
                    "------End of the game!-------\r\n", outContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void aPlayerShouldReceiveMoneyWhenGameBegins() {
        try {
            MonopolyGame mgame = new MonopolyGame(4);
            for (Player p : mgame.getPlayers()) {
                assertEquals( mgame.STARTMONEY, p.getCash());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
