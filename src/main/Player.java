package main;

public class Player {
    private String name;
    private Piece piece;
    private Die[] dices;
    private Board board;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, Piece piece, Die[] dices, Board board) {
        this(name);
        this.piece = piece;
        this.dices = dices;
        this.board = board;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void takeTurn() {

        int dieValue = 0;

        for (int i = 0; i < dices.length; ++i) {
            dices[i].roll();
            dieValue = dices[i].getFaceValue();
        }

        // Square newLoc = board.getSquare(this.piece.getLocation(), dieValue);

        // piece.setLocation(newLoc);

    }
}
