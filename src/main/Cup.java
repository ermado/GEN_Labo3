/* ------------------------------------------------------
GEN- LAB 3
File : Cup
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements the Cup class, which contains
        a given number of dices. When we roll a cup, in fact
        we roll all the dices contained in it.

---------------------------------------------------------*/

package main;

import java.util.ArrayList;

public class Cup {

    private ArrayList<Die> dices = new ArrayList<>();
    private int total;

    public Cup(int numberOfDices) {
        for (int i = 0; i < numberOfDices; ++i) {
            dices.add(new Die());
        }
    }

    public void roll() {
        total = 0;
        for (Die die : dices) {
            die.roll();
            total += die.getFaceValue();
        }
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<Die> getDices() {
        return dices;
    }

    public void setDices(ArrayList<Die> newDices) {
        this.dices = newDices;
    }
}
