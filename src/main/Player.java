package main;

import java.util.ArrayList;

public class Player {
    private String name;
    private Piece piece;
    private ArrayList<Die> dices;
    private Board board;

    public Player(Piece piece, ArrayList<Die> dices, Board board) {
        this.name = piece.name();
        this.piece = piece;
        this.piece.setLocation(board.getStartSquare());
        this.dices = dices;
        this.board = board;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void takeTurn() {

        int dieValue = 0;

        for (int i = 0; i < dices.size(); ++i) {
            dices.get(i).roll();
            dieValue = dices.get(i).getFaceValue();
        }

        Square newLoc = board.getSquare(this.piece.getLocation(), dieValue);

        piece.setLocation(newLoc);

    }
}
