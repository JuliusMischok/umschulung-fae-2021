import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FourWins {

    private static List<List<String>> rows;

    public static void main(String[] args) {
        initGrid();

        System.out.println(rows);

        System.out.println(generateGrid());

        putSymbol("X", 2);
        System.out.println(rows);
        putSymbol("O", 2);
        putSymbol("X", 3);
        System.out.println(rows);
        putSymbol("O", 2);

        System.out.println(generateGrid());

        System.out.println(rows);
    }

    static void initGrid() {
        rows = new ArrayList<>();

        for (int i=1; i<=6; i++) {
            rows.add(new ArrayList<>());
        }
    }

    /**
     * @param colNum the one-based column number
     */
    static void putSymbol(String symbol, int colNum) {
        for (int rowNum=6; rowNum>=1; rowNum--) {
            String currentSymbol = getFieldContent(rowNum, colNum);

            if (" ".equals(currentSymbol)) {
                putSymbolAtPosition(symbol, colNum, rowNum);
                break;
            }
        }
        // TODO: handling, if column is full
    }

    @SuppressWarnings("StringConcatenationInLoop")
    static String generateGrid() {
        String result = "";

        for (int row=1; row<=6; row++) {
            for (int col=1; col<=7; col++) {
                result += "| " + getFieldContent(row, col) + " ";
            }
            result += "|\n";
        }
        result += "\n";

        return result;
    }

    static boolean hasWonVertical(String symbol) {
        Objects.requireNonNull(symbol);

        for (int col=1; col<=7; col++) {
            List<String> valuesInColumn = new ArrayList<>();

            for (int row=1; row<=6; row++) {
                valuesInColumn.add(getFieldContent(row, col));
            }

            if (checkWinInList(symbol, valuesInColumn)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasWonHorizontal(String symbol) {
        Objects.requireNonNull(symbol);

        for (int row=1; row<=6; row++) {
            List<String> valuesInRow = new ArrayList<>();
            for (int col=1; col<=7; col++) {
                valuesInRow.add(getFieldContent(row, col));
            }

            if (checkWinInList(symbol, valuesInRow)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasWonDiagonal(String symbol) {
        for (int initialRowNum=1; initialRowNum<=6; initialRowNum++) {
            List<String> diagFromLeftAsc = new ArrayList<>();
            List<String> diagFromLeftDesc = new ArrayList<>();
            List<String> diagFromRightAsc = new ArrayList<>();
            List<String> diagFromRightDesc = new ArrayList<>();

            for (int colNum=1; colNum<=7; colNum++) {
                if (initialRowNum - colNum + 1 >= 1) {
                    diagFromLeftDesc.add(getFieldContent(initialRowNum - colNum + 1, colNum));
                }
                if (initialRowNum + colNum - 1 <= 6) {
                    diagFromLeftAsc.add(getFieldContent(initialRowNum + colNum - 1, colNum));
                }
            }

            for (int colNum=7; colNum>=1; colNum--) {
                if (initialRowNum + (7-colNum) <= 6) {
                    diagFromRightAsc.add(getFieldContent(initialRowNum + (7-colNum), colNum));
                }
                if (initialRowNum - (7-colNum) >= 1) {
                    diagFromRightDesc.add(getFieldContent(initialRowNum - (7-colNum), colNum));
                }
            }

            if (checkWinInList(symbol, diagFromLeftAsc) || checkWinInList(symbol, diagFromLeftDesc) || checkWinInList(symbol, diagFromRightAsc) || checkWinInList(symbol, diagFromRightDesc)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkWinInList(String symbol, List<String> values) {
        String valuesAsString = String.join("", values);

        return valuesAsString.contains(symbol + symbol + symbol + symbol);
    }

    /**
     *
     * @param rowNum the row num (one-based)
     * @param colNum the col num (one-based)
     * @return the field content (symbol or empty string)
     */
    private static String getFieldContent(int rowNum, int colNum) {
        if (rows.get(rowNum - 1).size() >= colNum) {
            return rows.get(rowNum - 1).get(colNum - 1);
        } else {
            return " ";
        }
    }

    private static void putSymbolAtPosition(String symbol, int colNum, int rowNum) {
        for (int i = rows.get(rowNum -1).size(); i<= colNum -1; i++) {
            rows.get(rowNum -1).add(" ");
        }
        rows.get(rowNum -1).set(colNum -1, symbol);
    }
}
