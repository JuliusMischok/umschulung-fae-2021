import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class DateParser {

    public static int parseDay(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        // 19.10.2021
        // 012345678

        int indexOfDot = input.indexOf(".");

        if (indexOfDot < 0) {
            throw new IllegalArgumentException();
        }

        String dayString = input.substring(0, indexOfDot);



        return Integer.parseInt(dayString);
    }

    public static int parseMonth(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        // TODO: Implementierung

        return 0;
    }

    public static int parseYear(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        // 19.10.2021
        // 012345678

        int lastIndexOfDot = input.lastIndexOf(".");

        if (lastIndexOfDot < 0) {
            throw new IllegalArgumentException();
        }

        String yearString = input.substring(lastIndexOfDot + 1);

        return Integer.parseInt(yearString);
    }
}
