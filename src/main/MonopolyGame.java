package main;

import java.util.ArrayList;

public class MonopolyGame {

    final int N = 40;

    // 2 to 8 players per game
    private ArrayList<Player> players;

    // 2 dices per game
    private ArrayList<Die> dices;

    // Le plateau de jeu
    //private Board board = new Board();

    private int roundCnt;

    public MonopolyGame(ArrayList<Die> dices, ArrayList<Player> players) {
        this.dices = dices;
        this.players = players;
    }

    private void playRound() {
        for (Player player : players) {
            player.takeTurn();
        }
    }

    public void playGame() {

        // TODO
        for (roundCnt = 0; roundCnt < N; ++roundCnt) {
            playRound();
        }

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
