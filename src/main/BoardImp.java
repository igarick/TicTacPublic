package main;

public class BoardImp implements Board{
    private static final int SIDE_LENGTH_DEFAULT = 3;

    private final Symbol[][] symbols;
    private final int sideLength;

    public BoardImp() {
        this(SIDE_LENGTH_DEFAULT);
    }

    public BoardImp(int sideLength) {
        this.symbols = new Symbol[sideLength][sideLength];
        this.sideLength = sideLength;
    }

    @Override
    public int sideLength() {
        return sideLength;
    }

    @Override
    public void put(Symbol symbol, Coordinates coordinates) {
        put(symbol, coordinates.row(), coordinates.column());
    }

    @Override
    public void put(Symbol symbol, int row, int column) {
        symbols[row][column] = symbol;
    }

    @Override
    public Symbol get(Coordinates coordinates) {
        return get(coordinates.row(), coordinates.column());
    }

    @Override
    public Symbol get(int row, int column) {
        Symbol symbol = symbols[row][column];
        if (symbol == null) {
            throw new IllegalArgumentException("No symbols found...");
        }
        return symbol;
    }

    @Override
    public boolean isEmpty(Coordinates coordinates) {
        return isEmpty(coordinates.row(), coordinates.column());
    }

    @Override
    public boolean isEmpty(int row, int column) {
        return symbols[row][column] == null;
    }

    @Override
    public boolean isFull() {
        for (int row = 0; row < sideLength; row++) {
            for (int column = 0; column < sideLength; column++) {
                if (isEmpty(row, column)) {
                    return false;
                }
            }
        }
        return true;
    }
}
