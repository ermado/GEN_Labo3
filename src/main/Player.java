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

import java.util.ArrayList;

public class Player {
    private Board board;
    private String name;
    private Piece piece;
    private ArrayList<Die> dices;


    public Player(Piece piece, ArrayList<Die> dices, Board board) {
        this.name = piece.toString();
        this.piece = piece;
        this.piece.setLocation(board.getStartSquare());
        this.dices = dices;
        this.board = board;
    }

    public void takeTurn() {
        int dieValue = 0;
        for (int i = 0; i < dices.size(); ++i) {
            /*roll the dices and sum the result */
            dices.get(i).roll();
            dieValue += dices.get(i).getFaceValue();
        }
        System.out.println("    Rolling the dices! The sum is a : " + dieValue);

        Square newLoc = board.getRelativeSquare(this.piece.getLocation(), dieValue);
        piece.setLocation(newLoc);

        System.out.println("    " + this.name + "is moving to : " + piece.getLocation().toString());

    }

    public Square getLocation() {
        return this.piece.getLocation();
    }

    public void setLocation(int index){
        Square newLoc = board.getAbsoluteSquare(index);
        piece.setLocation(newLoc);
    };

    public String getName() {
        return this.name;
    }
}
