package main;

import main.players.Player;

public class Game {

    private final Board board;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final BoardRenderer renderer;
    private final GameResultAnalyser analyser;
    private Player currentPlayer;
    private final int firstAddress;
    private final int lastAddress;

    public Game(Board board, Player firstPlayer, Player secondPlayer) {
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.renderer = new BoardRenderer(board);
        this.analyser = new GameResultAnalyser(board);
        this.firstAddress = 1;
        this.lastAddress = board.sideLength() * board.sideLength();
        changeCurrentPlayer();
    }

    private void changeCurrentPlayer() {
        if (currentPlayer == null || currentPlayer == secondPlayer) {
            currentPlayer = firstPlayer;
        } else {
            currentPlayer = secondPlayer;
        }
    }

    public void start() {
        while (true) {
            renderer.render();
            System.out.printf("%s, сделайте Ваш ход (%d - %d): ", currentPlayer.getName(), firstAddress, lastAddress);

        }

    }

    private Coordinates addressToCoordinates(int address) {
        if (address < firstAddress || address > lastAddress) {
            throw new IllegalArgumentException();
        }
        int counter = firstAddress;
        for (int row = 0; row < board.sideLength(); row++) {
            for (int column = 0; column < board.sideLength(); column++) {
                if (counter == address) {
                    return new Coordinates(row, column);
                }
                counter++;
            }
        }
        throw new IllegalArgumentException();
    }
}
