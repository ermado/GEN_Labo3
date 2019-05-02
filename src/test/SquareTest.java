/* ------------------------------------------------------
GEN- LAB 3
File : SquareTest
Authors : Carpita Edoardo, Dutu Launay Marion, Moreira Erwan
Date : 01-05-2019

Brief : This class implement the tests on the Square class.

---------------------------------------------------------*/
import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SquareTest {

    @Test
    public void squareConstructorShouldWork() {
        Square square = new RegularSquare("A square", 2);
        assertEquals(2, square.getNumber());
        assertEquals("A square", square.getName());
    }

    @Test
    public void ASquareShouldHaveASimpleButClearVisualisation() {
        Square square = new RegularSquare("Cuisenaire Boulevard", 40);
        assertEquals("40 Cuisenaire Boulevard", square.toString());
    }

    @Test
    public void differentTypeOfSquaresCanBeCreated() {
        Square square1 = new RegularSquare("Little Road", 22);
        Square square2 = new GoToJailSquare("Go to Jail", 21);
        assertNotEquals(square1.getClass(), square2.getClass());
        assertEquals(square1.getClass().getSuperclass(), square2.getClass().getSuperclass());
    }

}
