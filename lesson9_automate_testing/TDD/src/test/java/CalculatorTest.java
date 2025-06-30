
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    public void addOne() {
        int expected = 2;
        assertEquals(expected,calculator.add(1,1));
    }

    @Test
    public void subTwo(){
        int expected = 0;
        int actual = calculator.sub(1,1);
        assertEquals(expected,actual);
    }

    @Test
    public void mulTwo(){
        int expected = 2;
        int actual = calculator.mul(1,2);
        assertEquals(expected,actual);
    }
}
