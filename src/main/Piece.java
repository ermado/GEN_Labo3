package main;

public enum Piece {

    SCOTTIEDOG("The Scottie Dog"),
    TOPHAT("The top hat"),
    THIMBLE("The thimble"),
    BOOT("The boot"),
    WHEELBARROW("The wheelbarrow"),
    CAT("The cat"),
    RACINGCAR("The racing car"),
    BATTLESHIP("The battleship");

    private String pieceName;
    private Square location;

    Piece(String piece) {
        this.pieceName = piece;
        this.location = null;
    }

    public String toString() {
        return pieceName;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }
}
