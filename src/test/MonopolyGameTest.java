import main.*;
import org.junit.jupiter.api.Test;

public class MonopolyGameTest {

    @Test
    public void aNewMonopolyGameShouldWork() {

        MonopolyGame mgame = new MonopolyGame();

        mgame.playGame();
    }

}
