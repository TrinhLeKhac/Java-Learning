package collection;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

// Enum is a group of constant values with a name. Its name considered a type (class)
enum Days {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumSetExample {
    public static void main(String[] args) {

        Set<Days> set = EnumSet.of(Days.FRIDAY, Days.SATURDAY);
        Set<Days> set1 = EnumSet.allOf(Days.class);
        Set<Days> set2 = EnumSet.noneOf(Days.class);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        for (Days item: set) {
            System.out.print(item + " ");
        }

        EnumMap<Days, Integer> map = new EnumMap<>(Days.class);
        map.put(Days.MONDAY, 1);
        map.put(Days.TUESDAY, 2);
        map.put(Days.WEDNESDAY, 3);
        map.put(Days.THURSDAY, 4);

        for (Map.Entry<Days, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
