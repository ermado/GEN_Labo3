/* ------------------------------------------------------
GEN- LAB 3
File : MonopolyGameTest
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the tests on the ermado.labo03.MonopolyGame class.

       To verify the correct out screens, before each test the
       system output is deviated to a byte array to verify
       its content. It is restored after each test.

---------------------------------------------------------*/

package ermado.labo03;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
            String expected = String.format("------Playing the game!------%nSorry, too many players to play the game%n------End of the game!-------%n");
            /*assertEquals("------Playing the game!------\r\n" +
                    "Sorry, too many players to play the game\r\n" +
                    "------End of the game!-------\r\n", outContent.toString());*/
            assertEquals(expected, outContent.toString());
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

    public static class BoardTest {

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

    public static class CupTest {

        @Test
        public void aNewCupShouldBeCreated() {
            Cup cup = new Cup(2);
            assertFalse(cup.getTotal() > 0);
            assertNotNull(cup);
        }

        @ParameterizedTest(name="Run {index}: numberOfDices{0}")
        @MethodSource("rollValueMustBeBetweenMinAndMax_Parameters")
        public void rollValueMustBeBetweenMinAndMax(int numberOfDices) {
            Cup cup = new Cup(numberOfDices);
            cup.roll();
            int max = cup.getDices().size() * 6;
            int min = cup.getDices().size();
            assertTrue(cup.getTotal() < max && cup.getTotal() > min);
        }

        static Stream<Arguments> rollValueMustBeBetweenMinAndMax_Parameters() throws Throwable {
            return Stream.of(Arguments.of(2), Arguments.of(3), Arguments.of(4));
        }
    }

    public static class DieTest {

        @Test
        public void aNewDieShouldBeCreated() {
            Die die = new Die();
            assertNotNull(die);
        }

        @RepeatedTest(50)
        public void rollValueMustBeBetweenOneAndSix() {
            Die die = new Die();
            die.roll();
            assertTrue(1 <= die.getFaceValue() && die.getFaceValue() <= 6);
        }
    }

    public static class PieceTest {

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
            Square first = new RegularSquare("First", 1);
            Square last = new RegularSquare("Last", 3);

            Piece piece = Piece.BATTLESHIP;
            piece.setLocation(first);
            assertEquals("1 First", piece.getLocation().toString());
            piece.setLocation(last);
            assertEquals("3 Last", piece.getLocation().toString());
        }

    }

    public static class PlayerTest {

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

    public static class SquareTest {

        @Test
        public void squareConstructorShouldWork() {
            Square square = new RegularSquare("A square", 2);
            assertEquals(2, square.getNumber());
            assertEquals("A square", square.getName());
        }

        @Test
        public void ASquareShouldHaveASimpleButClearVisualisation() {
            Square square = new RegularSquare("Cuisenaire Boulevard", 40);
            assertEquals("40 Cuisenaire Boulevard", square.toString());
        }

        @Test
        public void differentTypeOfSquaresCanBeCreated() {
            Square square1 = new RegularSquare("Little Road", 22);
            Square square2 = new GoToJailSquare("Go to Jail", 21);
            assertNotEquals(square1.getClass(), square2.getClass());
            assertEquals(square1.getClass().getSuperclass(), square2.getClass().getSuperclass());
        }

    }
}
