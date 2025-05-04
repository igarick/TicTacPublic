package main;

public class GameResultAnalyser {
    private final Board board;

    public GameResultAnalyser(Board board) {
        this.board = board;
    }

    public boolean isWin(Symbol symbol) {
        if (isRowWin(symbol)) {
            return true;
        }
        if (isColumnWin(symbol)) {
            return true;
        }
        if (isFirstDiagonalWin(symbol)) {
            return true;
        }if (isSecondDiagonalWin(symbol)) {
            return true;
        }

        return false;
    }

    private boolean isRowWin(Symbol symbol) {
        for (int row = 0; row < board.sideLength(); row++) {
            int counter = 0;
            for (int column = 0; column < board.sideLength(); column++) {
                Coordinates coordinate = new Coordinates(row, column);
                if(!board.isEmpty(coordinate) && board.get(coordinate) == symbol) {
                    counter++;
                }
            }
            if (counter == board.sideLength()) {
                return true;
            }
        }
        return false;
    }
    private boolean isColumnWin(Symbol symbol) {
        for (int column = 0; column < board.sideLength(); column++) {
            int counter = 0;
            for (int row = 0; row < board.sideLength(); row++) {
                Coordinates coordinate = new Coordinates(row, column);
                if(!board.isEmpty(coordinate) && board.get(coordinate) == symbol) {
                    counter++;
                }
            }
            if (counter == board.sideLength()) {
                return true;
            }
        }
        return false;
    }

    private boolean isFirstDiagonalWin(Symbol symbol) {
        int counter = 0;
        for (int n = 0; n < board.sideLength(); n++) {
            Coordinates coordinate = new Coordinates(n, n);
            if (!board.isEmpty(coordinate) && board.get(coordinate) == symbol) {
                counter++;
            }
        }
        return (counter == board.sideLength());
    }
    private boolean isSecondDiagonalWin(Symbol symbol) {
        int counter = 0;
        for (int n = 0; n < board.sideLength(); n++) {
            Coordinates coordinate = new Coordinates(board.sideLength() - n - 1, n);
            if (!board.isEmpty(coordinate) && board.get(coordinate) == symbol) {
                counter++;
            }
        }
        return (counter == board.sideLength());
    }

    public boolean isDraw(Symbol... symbols) {
        for (Symbol symbol : symbols) {
            if(isWin(symbol)) {
                return false;
            }
        }
        return board.isFull();
    }
}
