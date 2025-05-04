package main;

public class BoardRenderer {
    private final Board board;

    public BoardRenderer(Board board) {
        this.board = board;
    }

    public void render() {
        for (int row = 0; row < board.sideLength(); row++) {
            StringBuilder line = new StringBuilder();
            for (int column = 0; column < board.sideLength(); column++) {
                if (board.isEmpty(row, column)) {
                    line.append("-");
                } else {
                    line.append(board.get(row, column));
                }
                line.append(" ");
            }
                System.out.println(line);
        }
    }
}
