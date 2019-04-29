package main;

public class Square {
    private String name;
    private int number;

    public Square(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return number + " " + name;
    }

    String getName() {
        return name;
    }

    int getNumber() {
        return number;
    }
}
