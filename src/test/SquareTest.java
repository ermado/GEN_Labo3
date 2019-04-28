import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;

public class SquareTest {

    @Test
    public void stringConstructorShouldWork() {
        Square square = new Square("a square", 2);
        assertNotNull(square);
    }
}
