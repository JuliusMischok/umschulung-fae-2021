import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTests {

    @BeforeEach
    public void setup() {
        FourWins.initGrid();
    }

    @Test
    public void testEmptyGrid() {
        String expectedEmptyGrid = "" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   |   |\n" +
                "\n";

        Assertions.assertEquals(expectedEmptyGrid, FourWins.generateGrid());
    }

    @Test
    public void testSimpleGrid() {
        FourWins.putSymbol("X", 2);
        FourWins.putSymbol("O", 2);
        FourWins.putSymbol("X", 4);
        FourWins.putSymbol("O", 3);
        FourWins.putSymbol("X", 2);
        FourWins.putSymbol("O", 4);

        String expectedEmptyGrid = "" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   |   |\n" +
                "|   | X |   |   |   |   |   |\n" +
                "|   | O |   | O |   |   |   |\n" +
                "|   | X | O | X |   |   |   |\n" +
                "\n";

        Assertions.assertEquals(expectedEmptyGrid, FourWins.generateGrid());
    }

    @Test
    public void testSimpleGrid1() {
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 1);
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 1);
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 1);

        String expectedEmptyGrid = "" +
                "| O |   |   |   |   |   |   |\n" +
                "| X |   |   |   |   |   |   |\n" +
                "| O |   |   |   |   |   |   |\n" +
                "| X |   |   |   |   |   |   |\n" +
                "| O |   |   |   |   |   |   |\n" +
                "| X |   |   |   |   |   |   |\n" +
                "\n";

        Assertions.assertEquals(expectedEmptyGrid, FourWins.generateGrid());
    }

    @Test
    public void testVerticalWin() {
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 2);
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 3);
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 4);

        Assertions.assertFalse(FourWins.hasWonVertical("X"));

        FourWins.putSymbol("X", 1);

        Assertions.assertFalse(FourWins.hasWonVertical("O"));
        Assertions.assertTrue(FourWins.hasWonVertical("X"));
    }

    @Test
    public void testHorizontalWin() {
        FourWins.putSymbol("X", 4);
        FourWins.putSymbol("O", 5);
        FourWins.putSymbol("X", 3);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 2);
        FourWins.putSymbol("O", 7);

        Assertions.assertFalse(FourWins.hasWonHorizontal("X"));
        Assertions.assertFalse(FourWins.hasWonHorizontal("O"));
        Assertions.assertFalse(FourWins.hasWonVertical("X"));
        Assertions.assertFalse(FourWins.hasWonVertical("O"));

        FourWins.putSymbol("X", 1);

        Assertions.assertFalse(FourWins.hasWonHorizontal("O"));
        Assertions.assertTrue(FourWins.hasWonHorizontal("X"));
    }

    @Test
    public void testDiagonalWinLeftAsc() {
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 2);
        FourWins.putSymbol("X", 4);
        FourWins.putSymbol("O", 3);
        FourWins.putSymbol("X", 2);
        FourWins.putSymbol("O", 1);
        FourWins.putSymbol("X", 3);
        FourWins.putSymbol("O", 2);
        FourWins.putSymbol("X", 4);
        FourWins.putSymbol("O", 3);
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 4);
        FourWins.putSymbol("X", 2);
        FourWins.putSymbol("O", 3);
        FourWins.putSymbol("X", 3);
        FourWins.putSymbol("O", 5);
        FourWins.putSymbol("X", 4);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 4);
        FourWins.putSymbol("O", 6);

        Assertions.assertFalse(FourWins.hasWonDiagonal("X"));
        Assertions.assertFalse(FourWins.hasWonDiagonal("O"));

        FourWins.putSymbol("X", 4);

        String expectedGrid = "" +
                "|   |   |   | X |   |   |   |\n" +
                "|   |   | X | X |   |   |   |\n" +
                "|   | X | O | X |   |   |   |\n" +
                "| X | O | O | O |   |   |   |\n" +
                "| O | X | X | X |   | O |   |\n" +
                "| X | O | O | X | O | O |   |\n" +
                "\n";

        Assertions.assertEquals(expectedGrid, FourWins.generateGrid());

        Assertions.assertFalse(FourWins.hasWonDiagonal("O"));
        Assertions.assertTrue(FourWins.hasWonDiagonal("X"));
    }

    @Test
    public void testDiagonalWinAscLower() {
        FourWins.putSymbol("O", 4);
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 5);
        FourWins.putSymbol("X", 2);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 3);
        FourWins.putSymbol("O", 5);
        FourWins.putSymbol("X", 7);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 7);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 7);

        Assertions.assertFalse(FourWins.hasWonDiagonal("X"));
        Assertions.assertFalse(FourWins.hasWonDiagonal("O"));

        FourWins.putSymbol("O", 7);

        String expectedGrid = "" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   |   |\n" +
                "|   |   |   |   |   |   | O |\n" +
                "|   |   |   |   |   | O | X |\n" +
                "|   |   |   |   | O | O | X |\n" +
                "| X | X | X | O | O | O | X |\n" +
                "\n";

        Assertions.assertEquals(expectedGrid, FourWins.generateGrid());

        Assertions.assertFalse(FourWins.hasWonDiagonal("X"));
        Assertions.assertTrue(FourWins.hasWonDiagonal("O"));
    }

    @Test
    public void testDiagonalWindescUpper() {
        FourWins.putSymbol("O", 4);
        FourWins.putSymbol("X", 5);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 7);
        FourWins.putSymbol("O", 4);
        FourWins.putSymbol("X", 5);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 7);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 7);
        FourWins.putSymbol("O", 5);
        FourWins.putSymbol("X", 4);
        FourWins.putSymbol("O", 5);
        FourWins.putSymbol("X", 4);
        FourWins.putSymbol("O", 4);
        FourWins.putSymbol("X", 6);
        FourWins.putSymbol("O", 1);
        FourWins.putSymbol("X", 5);
        FourWins.putSymbol("O", 7);

        Assertions.assertFalse(FourWins.hasWonDiagonal("X"));
        Assertions.assertFalse(FourWins.hasWonDiagonal("O"));

        FourWins.putSymbol("X", 4);

        String expectedGrid = "" +
                "|   |   |   | X |   |   |   |\n" +
                "|   |   |   | O | X |   |   |\n" +
                "|   |   |   | X | O | X | O |\n" +
                "|   |   |   | X | O | O | X |\n" +
                "|   |   |   | O | X | O | X |\n" +
                "| O |   |   | O | X | O | X |\n" +
                "\n";

        Assertions.assertEquals(expectedGrid, FourWins.generateGrid());

        Assertions.assertFalse(FourWins.hasWonDiagonal("O"));
        Assertions.assertTrue(FourWins.hasWonDiagonal("X"));
    }

    @Test
    public void testDiagonalWindescLower() {
        FourWins.putSymbol("O", 1);
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 3);
        FourWins.putSymbol("X", 2);
        FourWins.putSymbol("O", 4);
        FourWins.putSymbol("X", 3);
        FourWins.putSymbol("O", 4);
        FourWins.putSymbol("X", 2);

        FourWins.putSymbol("O", 3);
        FourWins.putSymbol("X", 2);
        FourWins.putSymbol("O", 2);
        FourWins.putSymbol("X", 1);
        FourWins.putSymbol("O", 6);
        FourWins.putSymbol("X", 1);


        Assertions.assertFalse(FourWins.hasWonDiagonal("X"));
        Assertions.assertFalse(FourWins.hasWonDiagonal("O"));

        FourWins.putSymbol("O", 1);

        String expectedGrid = "" +
                "|   |   |   |   |   |   |   |\n" +
                "| O |   |   |   |   |   |   |\n" +
                "| X | O |   |   |   |   |   |\n" +
                "| X | X | O |   |   |   |   |\n" +
                "| X | X | X | O |   |   |   |\n" +
                "| O | X | O | O |   | O |   |\n" +
                "\n";

        Assertions.assertEquals(expectedGrid, FourWins.generateGrid());

        Assertions.assertFalse(FourWins.hasWonDiagonal("X"));
        Assertions.assertTrue(FourWins.hasWonDiagonal("O"));
    }
}
