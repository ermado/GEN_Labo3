package main;

import java.util.Random;

public class Die {

    private int faceValue;

    public Die() {

    }

    public void roll() {
        Random random = new Random();
        faceValue = random.nextInt(6) + 1;
    }

    public int getFaceValue() {
        return faceValue;
    }

}