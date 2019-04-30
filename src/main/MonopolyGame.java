package main;

import java.util.ArrayList;

public class MonopolyGame {

    private static final int N = 20;
    private static final int NBDICES = 2;

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Die> dices = new ArrayList<Die>();

    private Board board; //Le plateau de jeu

    public MonopolyGame(int nbPlayers) {
        try {
            board = new Board();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < NBDICES; i++) {
            addDie();
        }

        for (int i = 0; i < nbPlayers; i++) {
            addPlayer(i);
        }
    }

    private void addDie() {
        Die die = new Die();
        dices.add(die);
    }

    private void addPlayer(int index) {
        Player player = new Player(Piece.values()[index], dices, board);
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

    public void playGame() {

        System.out.println("------Playing the game!------");
        if (players.size() >= 2) {
            for (int roundCnt = 0; roundCnt < N; ++roundCnt) {
                System.out.println("Round - " + roundCnt);
                playRound();
            }
        } else {
            System.out.println("Sorry not enough players to play the game");
        }
        System.out.println("------End of the game!-------");

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
