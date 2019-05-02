/* ------------------------------------------------------
GEN- LAB 3
File : GoSquare
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the GoSquare, which is the first
        square of the board.

---------------------------------------------------------*/

package main;

public class GoSquare extends Square {

    public GoSquare(String name, int number) {
        super(name, number);
    }

    private static final int GOMONEY = 200;

    @Override
    public void landedOn(Player player) {
        System.out.println( "    "+ player.getName() +" is receving "+ GOMONEY +"!");
        player.addCash(GOMONEY);
    }


}
