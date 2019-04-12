import main.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class MonopolyGameTest {

    @Test
    public void aNewMonopolyGameShouldBeCreated() {
        Die d1 = new Die();
        Die d2 = new Die();
        ArrayList<Die> dices = new ArrayList<Die>();
        dices.add(d1);
        dices.add(d2);
        MonopolyGame mgame = new MonopolyGame(dices);
        assertNotNull(mgame);
    }

}
