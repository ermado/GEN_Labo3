import main.Die;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class DieTest {

    @Test
    public void createDie() {
        Die die = new Die(3);
        assertNotNull(die);
    }
}
