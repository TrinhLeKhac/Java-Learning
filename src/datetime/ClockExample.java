package datetime;

import java.time.Clock;
import java.time.Duration;

public class ClockExample {
    public static void main(String[] args) {
        System.out.println("----------------Example 1-----------------------");
        Clock c1 = Clock.systemDefaultZone();
        System.out.println(c1.getZone());
        System.out.println('\n');

        Clock c2 = Clock.systemUTC();
        System.out.println(c2.instant());

        Duration d = Duration.ofHours(5);
        Clock c3 = Clock.offset(c2, d);
        System.out.println(c3.instant());
    }
}
