import java.time.LocalDate;
import java.util.IllegalFormatException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void testSplitDate() {
        String input = "19.10.2021";

        int day = DateParser.parseDay(input);
        int month = DateParser.parseMonth(input);
        int year = DateParser.parseYear(input);

        Assertions.assertEquals(19, day);
        Assertions.assertEquals(2021, year);
    }

    @Test
    public void testSplitDateWithoutDot() {
        String input = "10/19/2021";

        try {
            int day = DateParser.parseDay(input);
            Assertions.fail("parsing should fail due to invalid format");
        } catch (IllegalArgumentException e) {
            // exception expected
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testSplitInvalidDate() {
        String input = "Di 19.10.2021";

        try {
            int day = DateParser.parseDay(input);
            Assertions.fail("parsing should fail due to invalid format");
        } catch (IllegalArgumentException e) {
            // exception expected
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testSplitInvalidDate1() {
        String input = ".10.2021";

        try {
            int day = DateParser.parseDay(input);
            Assertions.fail("parsing should fail due to invalid format");
        } catch (IllegalArgumentException e) {
            // exception expected
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testSplitNullDate() {
        try {
            //noinspection ConstantConditions
            DateParser.parseDay(null);
            Assertions.fail("parsing should fail due to null value");
        } catch (IllegalArgumentException e) {
            // exception expected
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testSplitYearNullDate() {
        try {
            //noinspection ConstantConditions
            DateParser.parseYear(null);
            Assertions.fail("parsing should fail due to null value");
        } catch (IllegalArgumentException e) {
            // exception expected
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testSplitYearInvalidDate() {
        String input = "19.10.";

        try {
            int year = DateParser.parseYear(input);
            Assertions.fail("parsing should fail due to invalid format");
        } catch (IllegalArgumentException e) {
            // exception expected
            Assertions.assertTrue(true);
        }
    }
}
