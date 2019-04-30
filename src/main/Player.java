package main;

import java.util.ArrayList;

public class Player {
    private String name;
    private Piece piece;
    private ArrayList<Die> dices;
    private Board board;

    public Player(Piece piece, ArrayList<Die> dices, Board board) {
        this.name = piece.toString();
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
            dieValue += dices.get(i).getFaceValue();
        }
        System.out.println("    Rolling the dices! It's a : " + dieValue);
        Square newLoc = board.getSquare(this.piece.getLocation(), dieValue);
        piece.setLocation(newLoc);
        System.out.println("    " + this.name + "is moving to : " + piece.getLocation().toString());

    }

    public Square getLocation() {
        return this.piece.getLocation();
    }

    public String getName() {
        return this.name;
    }
}
