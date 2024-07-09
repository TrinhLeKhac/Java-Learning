package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {
    public static void main(String[] args) {

        System.out.println("----------------Example 1-----------------------");
        LocalTime current = LocalTime.now();
        LocalTime time1 = current.minusHours(1);
        // print LocalTime instance is print LocalTime which formatted by DatetimeFormatter.ISO_LOCAL_TIME
        System.out.println("Today time is: " + current);
        System.out.println("Today time (minus 1 hour) is: " + time1.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println('\n');

        System.out.println("----------------Example 2-----------------------");

        ZoneId vietnam = ZoneId.of("Asia/Ho_Chi_Minh");
        LocalTime time21 = LocalTime.now(vietnam);
        System.out.println("Vietnam Time Zone: " + time21);

        ZoneId japan = ZoneId.of("Asia/Tokyo");
        LocalTime time22 = LocalTime.now(japan);
        System.out.println("Japan Time Zone: " + time22);

        long hours = ChronoUnit.HOURS.between(time21, time22);
        System.out.println("Hours between two Time Zone is: " + hours);
        long minutes = ChronoUnit.MINUTES.between(time21, time22);
        System.out.println("Minutes between two Time Zone is: " + minutes);

        System.out.println("System default Time zone is: " + ZoneId.systemDefault());
        System.out.println('\n');
    }
}
