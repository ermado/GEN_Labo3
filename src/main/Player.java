/* ------------------------------------------------------
GEN- LAB 3
File : Player
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implement the Player of the game.

        To properly move in the game, every player has to
        access to the board and the dices used. This explain
        why they are implemented as methods of the class

        For know, a player name correspond also at the name
        of it's piece, but we left the two entities separated
        if this situation may need to change in future
        implementations

---------------------------------------------------------*/

package main;

public class Player {
    private Board board;
    private String name;
    private Piece piece;
    private Cup cup;
    private double cash;

    public Player(Piece piece, Cup cup, Board board) {
        this.name = piece.toString();
        this.piece = piece;
        this.piece.setLocation(board.getStartSquare());
        this.cup = cup;
        this.board = board;
    }

    public void takeTurn() {
        cup.roll();
        int dieValue = cup.getTotal();

        System.out.println("    Rolling the dices! The sum is a : " + dieValue);

        Square newLocation = board.getRelativeSquare(this.piece.getLocation(), dieValue);
        piece.setLocation(newLocation);

        System.out.println("    " + this.name + " is moving to : " + piece.getLocation().toString());

        newLocation.landedOn(this);
    }

    public Square getLocation() {
        return this.piece.getLocation();
    }

    public void setLocation(int index){
        Square newLocation = board.getAbsoluteSquare(index);
        piece.setLocation(newLocation);

        System.out.println("    " + this.name + " is moving to : " + piece.getLocation().toString());

        newLocation.landedOn(this);
    };

    public String getName() {
        return this.name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
