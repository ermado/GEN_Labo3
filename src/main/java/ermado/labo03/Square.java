package ermado.labo03;/* ------------------------------------------------------
GEN- LAB 3
File : ermado.labo03.Square
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This abstract class defines the squares that compose the
        board of the game.

        It's a pretty straightforward class, every square
        has a name and a corresponding number.

---------------------------------------------------------*/

public abstract class Square {
    private String name;
    private int number;

    public Square(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return number + " " + name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    /**
     * This method is used to define the actions done to a player when he
     * lands on it.
     */
    public abstract void landedOn(Player player);
}
