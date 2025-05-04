package main;

public interface Board {
    int sideLength();

    void put(Symbol symbol, Coordinates coordinates);
    void put(Symbol symbol, int row, int column);

    Symbol get(Coordinates coordinates);
    Symbol get(int row, int column);

    boolean isEmpty(Coordinates coordinates);
    boolean isEmpty(int row, int column);

    boolean isFull();
}
