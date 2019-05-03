package ermado.labo03;/* ------------------------------------------------------
GEN- LAB 3
File : ermado.labo03.Player
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the players of the game.

        To properly move in the game, every player has to
        access to the board and the dices used. This explains
        why they are implemented as methods of the class.

        For now, a player name corresponds also with the name
        of its piece, but we left the two entities separated
        if this situation may need to change in future
        implementations.

---------------------------------------------------------*/

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

    /**
     * This function simulates a player's turn
     */
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

    public void addCash(double addedCash) {
        this.cash += addedCash;
    }

    public void reduceCash(double removedCash){
        this.cash -= removedCash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

}
