package ermado.labo03;/* ------------------------------------------------------
GEN- LAB 3
File : ermado.labo03.Piece
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This enum class implements all the pieces of a Monopoly
        game.

        We decided to use a enum to easily index and give
        a proper String name to its components.

---------------------------------------------------------*/

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
