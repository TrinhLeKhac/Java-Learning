package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        System.out.println("----------------Example 1-----------------------");
        ZoneId vietnam = ZoneId.of("Asia/Ho_Chi_Minh");
        LocalDateTime current = LocalDateTime.now(vietnam);
        System.out.println("Before formatting: " + current);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentStr = current.format(formatter);
        System.out.println("After formatting: " + currentStr);

        System.out.println('\n');

        System.out.println("----------------Example 2-----------------------");
        LocalDateTime datetime2 = LocalDateTime.of(2024, 7, 7, 10, 20, 55);
        LocalDate date2 = datetime2.toLocalDate();

        System.out.println("Current day is: " + date2);

        System.out.println("Day of week: " + datetime2.getDayOfWeek());
        System.out.println("Day of week (number): " + datetime2.get(ChronoField.DAY_OF_WEEK));
        System.out.print("Day of year: " + datetime2.getDayOfYear());

        System.out.println('\n');

        System.out.println("----------------Example 3-----------------------");
        LocalDateTime datetime3 = LocalDateTime.of(2024, Month.JUNE, 19, 15, 26);

        ZoneId japan = ZoneId.of("Asia/Tokyo");
        ZonedDateTime datetimeWithZone  = ZonedDateTime.of(datetime3, japan);
        System.out.println("In Japan Time Zone: " + datetimeWithZone);

        System.out.println(datetimeWithZone.getZone());
    }
}
