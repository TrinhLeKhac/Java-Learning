package datetime;

// Classical Date/Time API
// java.util.Date
// java.util.Calendar
// java.util.TimeZone

// java.sql.Date
// java.sql.Time
// java.sql.Timestamp

// Java has introduced a new Date and Time API since Java 8.
// The java.time package contains Java 8 Date and Time classes
// java.time.*

// format Date and Time
// java.text.DateFormat
// java.text.SimpleDateFormat


// Some useful methods in old Date/Time APIs
// Java.lang.System: The class provides the currentTimeMillis() method that returns the current time in milliseconds.
// It shows the current date and time in milliseconds from January 1st 1970.
// java.util.Date: It is used to show specific instant of time, with unit of millisecond.
// java.util.Calendar: It is an abstract class that provides methods for converting between instances and manipulating the calendar fields in different ways.
// java.text.SimpleDateFormat: It is a class that is used to format and parse the dates in a predefined manner or user defined pattern.
// java.util.TimeZone: It represents a time zone offset, and also figures out daylight savings.

// Drawbacks of old Date/Time APIs
// Thread safety: hart-to-debug concurrency issues
// Bad API designing: not provide methods to perform basic day-to-day functionalities
// Difficult time zone handling


// Some usefull methods in new Data/Time APIs
// java.time.LocalDate
// java.time.LocalTime
// java.time.LocalDateTime: It handles both date and time, without a time zone
// java.time.ZonedDateTime: It combines the LocalDateTime class with the zone information given in ZoneId class
// java.time.OffsetTime: It handles time with a corresponding time zone offset from Greenwich/UTC, without a time zone ID.
// java.time.OffsetDateTime
// java.time.Instant: It represents the start of a nanosecond on the timeline (since EPOCH) and useful for generating a timestamp to represent machine time
// java.time.Duration: Difference between two instants and measured in seconds or nanoseconds
// java.time.Period: It is used to define the difference between dates in date-based values (years, months, days)
// java.time.format.DateTimeFormatter : It comes up with various predefined formatter, or we can define our own

public class DateTimeExplaination {
}

