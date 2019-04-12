package main;

public enum Piece {
    SCOTTIEDOG("The Scottie Dog"), TOPHAT("The top hat"), THIMBLE("The thimble"),
    BOOT("The boot"), WHEELBARROW("The wheelbarrow"), CAT("The cat"),
    RACINGCAR("The racing car"), BATTLESHIP("The battleship");

    private String pieceName;

    Piece(String piece) {
        this.pieceName = piece;
    }

    public String toString() {
        return pieceName;
    }
}

