/* ------------------------------------------------------
GEN- LAB 3
File : MonopolyGame
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the main program of the game
        It uses all other created classes to create the
        components of a monopoly game while verifying the
        user entries (ex: a valid number of players)

---------------------------------------------------------*/

package main;

import java.io.IOException;
import java.util.ArrayList;

public class MonopolyGame {

    public static final int STARTMONEY = 1500;

    private static final int MAXPLAYERS = 8;
    private static final int MINPLAYERS = 2;
    private static final int NBROUNDS = 20;
    private static final int NBDICES = 2;

    private int nbPlayers;
    private Board board;
    private ArrayList<Player> players = new ArrayList<>();
    private Cup cup;

    public MonopolyGame(int nbPlayers) throws IOException {
        board = new Board();
        this.nbPlayers = nbPlayers;
    }

    /**
     * This function simulates the whole monopoly game
     */
    public void playGame() {
        System.out.println("------Playing the game!------");
        if (nbPlayers >= MINPLAYERS) {
            if (nbPlayers <= MAXPLAYERS) {
                setUp();
                play();
            } else {
                System.out.println("Sorry, too many players to play the game");
            }
        } else {
            System.out.println("Sorry, not enough players to play the game");
        }
        System.out.println("------End of the game!-------");

    }

    /**
     * This function sets up the cup used by the players and creates the players
     */
    private void setUp() {

        cup = new Cup(NBDICES);

        for (int i = 0; i < nbPlayers; i++) {
            addPlayer(i);
        }
    }

    /**
     * This function simulates the given number of rounds
     */
    private void play() {
        for (int round = 0; round < NBROUNDS; ++round) {
            System.out.println("Round - " + (round+1));
            playRound();
        }

    }

    private void addPlayer(int index) {
        Player player = new Player(Piece.values()[index], cup, board);
        player.setCash(STARTMONEY);
        players.add(player);
    }

    /**
     * This function simulates a round for each player
     */
    private void playRound() {
        for (Player player : players) {
            System.out.println();
            System.out.println("    It's the turn of " + player.getName());
            player.takeTurn();
            System.out.println();
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}
