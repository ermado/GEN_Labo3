/* ------------------------------------------------------
GEN- LAB 3
File : PlayerTest
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implement the tests on the Square class.

---------------------------------------------------------*/
import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    @Test
    public void squareConstructorShouldWork() {
        Square square = new Square("A square", 2);
        assertEquals(2, square.getNumber());
        assertEquals("A square", square.getName());
    }

    @Test
    public void ASquareShouldHaveASimpleButClearVisualisation() {
        Square square = new Square("Cuisenaire Boulevard", 40);
        assertEquals("40 Cuisenaire Boulevard", square.toString());
    }


}
