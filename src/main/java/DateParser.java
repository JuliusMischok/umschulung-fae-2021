import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DateParser {

    public static void main(String[] args) {
        String hello = "Hello world Hello wo";

        if (hello.length() >= 20) {
            System.out.println("#" + hello.substring(20) + "#");
        }

        String emailFromDatabase = "julius.mischok@mischok.de";
        String emailInput = " JULIUS.Mischok@mischok.de ";

        System.out.println("#" + emailInput.toUpperCase(Locale.ROOT) + "#");

        if (emailFromDatabase.equalsIgnoreCase(emailInput.trim())) {
            System.out.println("emails match");
        } else {
            System.out.println("emails does not match");
        }

        System.out.println("===========================================");

        System.out.println(emailInput.strip().toUpperCase());

        char fourthChar = emailInput.strip().toUpperCase().charAt(3);

        System.out.println(fourthChar);
        System.out.println((int)fourthChar);

        System.out.println("===========================================");

        List<String> ipComponents = List.of("122", "12", "14", "1");

        System.out.println(ipComponents.get(0) + "." + ipComponents.get(1) + "." + ipComponents.get(2) + "." + ipComponents.get(3));

        System.out.println(String.join(".", ipComponents));
        System.out.println(String.join(".", "123", "13", "15", "122"));
    }

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
