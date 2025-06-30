import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    public void fizzTestBy3(){
        String expected = "Fizz";
        String actual = FizzBuzz.translate(3);
        assertEquals(expected,actual);
    }

    public void fizzTestBy9(){
        String expected = "Fizz";
        String actual = FizzBuzz.translate(9);
        assertEquals(expected,actual);
    }

    public void buzzTestBy5(){
        String expected = "Buzz";
        String actual = FizzBuzz.translate(9);
        assertEquals(expected,actual);
    }
}
