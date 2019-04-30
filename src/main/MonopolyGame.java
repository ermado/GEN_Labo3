package main;

import java.util.ArrayList;

public class MonopolyGame {

    final int N = 40;

    // 2 to 8 players per game
    private ArrayList<Player> players;

    // 2 dices per game
    private ArrayList<Die> dices;

    // Le plateau de jeu
    private Board board;

    private int roundCnt;

    public MonopolyGame() {

        try {
            board = new Board();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Creation de 2 dés
        Die d1 = new Die();
        Die d2 = new Die();
        ArrayList<Die> dices = new ArrayList<Die>();
        dices.add(d1);
        dices.add(d2);
        this.dices = dices;

        // Creation des joueurs
        Player p1 = new Player(Piece.CAT, dices, board);
        Player p2 = new Player(Piece.TOPHAT, dices, board);
        Player p3 = new Player(Piece.BATTLESHIP, dices, board);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        this.players = players;

    }

    private void playRound() {
        for (Player player : players) {
            player.takeTurn();
        }
    }

    public void playGame() {

        for (roundCnt = 0; roundCnt < N; ++roundCnt) {
            playRound();
        }

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
