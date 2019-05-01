/* ------------------------------------------------------
GEN- LAB 3
File : MonopolyGame
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implement the main program of the game
        It uses all other created classes to create the
        components of a monopoly game while verifing the
        user entries (ex: a valid number of players)

---------------------------------------------------------*/

package main;

import java.io.IOException;
import java.util.ArrayList;

public class MonopolyGame {

    private static final int MAXPLAYERS = 8;
    private static final int MINPLAYERS = 2;
    private static final int NBROUNDS = 20;
    private static final int NBDICES = 2;
    private static final int STARTMONEY = 1500;

    private int nbPlayers;
    private Board board;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Die> dices = new ArrayList<Die>();
    private Cup cup;

    public MonopolyGame(int nbPlayers) throws IOException {
        board = new Board();
        this.nbPlayers = nbPlayers;
    }

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

    private void setUp() {
        cup = new Cup(NBDICES);

        for (int i = 0; i < NBDICES; i++) {
            addDie();
        }
        for (int i = 0; i < nbPlayers; i++) {
            addPlayer(i);
        }
    }

    private void play() {
        for (int round = 0; round < NBROUNDS; ++round) {
            System.out.println("Round - " + round);
            playRound();
        }

    }

    private void addDie() {
        Die die = new Die();
        dices.add(die);
    }

    private void addPlayer(int index) {
        Player player = new Player(Piece.values()[index], cup, board);
        player.setCash(STARTMONEY);
        players.add(player);
    }

    private void playRound() {
        for (Player player : players) {
            System.out.println();
            System.out.println("    It's the turn of " + player.getName());
            player.takeTurn();
            System.out.println();
        }
    }

}
