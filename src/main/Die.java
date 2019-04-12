package main;

import java.util.Random;

public class Die {

    private int faceValue;

    public Die() {

    }

    public int roll() {
        Random random = new Random();
        faceValue = random.nextInt(6) + 1;
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

}