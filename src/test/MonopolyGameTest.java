import main.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class MonopolyGameTest {

    @Test
    public void aNewMonopolyGameShouldBeCreated() {

        // Creation de 2 dés
        Die d1 = new Die();
        Die d2 = new Die();
        ArrayList<Die> dices = new ArrayList<Die>();
        dices.add(d1);
        dices.add(d2);

        // Création de 2 joueurs
        Player p1 = new Player("The cat");
        Player p2 = new Player("The hat");
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        MonopolyGame mgame = new MonopolyGame(dices, players);

        assertNotNull(mgame);
    }
}
