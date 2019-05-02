/* ------------------------------------------------------
GEN- LAB 3
File : IncomeTaxSquare
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the Income Tax square in the
        Monopoly game.

---------------------------------------------------------*/

package main;

import static java.lang.Double.min;

public class IncomeTaxSquare extends Square {

    public IncomeTaxSquare(String name, int number) {
        super(name, number);
    }

    private static final int MINIMUMTAXATION = 200;

    @Override
    public void landedOn(Player player) {
        System.out.println("    " + player.getName() + " has to pay taxes!");
        double netValue = player.getCash();
        player.reduceCash(min(MINIMUMTAXATION, (netValue * 0.1)));
    }
}
