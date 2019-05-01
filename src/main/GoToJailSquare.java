package main;

public class GoToJailSquare extends Square {

    private static final int JAILSQUARE = 10 ;

    public GoToJailSquare(String name, int number) {
        super(name, number);
    }

    @Override
    public void landedOn(Player player) {
        System.out.println( "   "+ player.getName() +" is going to jail!");
        player.setLocation(JAILSQUARE);
    }


}
