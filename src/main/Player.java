package main;

public class Player {
    private String name;
    private Piece piece;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, Piece piece) {
        this(name);
        this.piece = piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void takeTurn() {

    }
}
