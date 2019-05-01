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
