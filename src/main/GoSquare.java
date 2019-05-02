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
