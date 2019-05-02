/* ------------------------------------------------------
GEN- LAB 3
File : Die
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implements a die used by the players to move
        their piece from square to square.

        Every die has a 6 faces, with each a value from 1 to 6.

---------------------------------------------------------*/

package main;

import java.util.Random;

public class Die {

    protected int faceValue;

    public Die() {}

    public void roll() {
        Random random = new Random();
        faceValue = random.nextInt(6) + 1;
    }

    public int getFaceValue() {
        return faceValue;
    }
}