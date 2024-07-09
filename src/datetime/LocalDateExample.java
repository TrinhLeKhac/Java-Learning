package datetime;
// Java LocalDate class is an immutable class that represents Date with a default format of yyyy-mm-dd.
// It inherits Object class and implements the ChronoLocalDate interface

import java.sql.SQLSyntaxErrorException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
    public static void main(String[] args) {

        System.out.println("----------------Example 1-----------------------");
        LocalDate current = LocalDate.now();
        LocalDate yesterday = current.minusDays(1);
        LocalDate tomorrow = current.plusDays(1);
        // print LocalDate instance is print LocalDate which formatted by DatetimeFormatter.ISO_DATE
        System.out.println("Today date: " + current);
        System.out.println("Yesterday date: " + yesterday);
        System.out.println("Tomorrow date: " + tomorrow);
        System.out.println('\n');

        System.out.println("----------------Example 2-----------------------");
        LocalDate date2 = LocalDate.of(2024, 7, 1);
        String dateStr2 = date2.format(DateTimeFormatter.ISO_DATE);
        if (date2.isLeapYear()) {
            System.out.println("The year of dateStr " + dateStr2 + " is leap year");
        }
        System.out.println('\n');

        System.out.println("----------------Example 3-----------------------");
        LocalDate date3 = LocalDate.of(2024, 6, 1);
        LocalDateTime datetime3 = date3.atTime(12, 40, 40);
        // print LocalDateTime instance is print LocalDateTime which formatted by DatetimeFormatter.ISO_DATE_TIME
        System.out.println(datetime3);
        System.out.println(datetime3.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println('\n');

        System.out.println("----------------Example 4-----------------------");
        String dateStr4 = "2024-07-07";
        LocalDate date4 = LocalDate.parse(dateStr4);
        System.out.println("String to LocalDate: " + date4);
        System.out.println('\n');

    }
}
