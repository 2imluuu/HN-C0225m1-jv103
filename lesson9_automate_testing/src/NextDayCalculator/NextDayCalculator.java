package NextDayCalculator;

import java.time.LocalDate;

public class NextDayCalculator {
    public static LocalDate calculateNextDay(int year, int month, int day){
        LocalDate date = LocalDate.of(year, month, day);
        return date.plusDays(1);
    }
}
