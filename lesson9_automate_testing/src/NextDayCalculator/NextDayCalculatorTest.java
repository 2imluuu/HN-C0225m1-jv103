package NextDayCalculator;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void calculateNextDay() {
        LocalDate actual = LocalDate.of(2020, 1, 1);
        LocalDate expected = LocalDate.of(2020, 1, 2);
        LocalDate resutl = actual.plusDays(1);
        assertEquals(expected, resutl);
    }
}