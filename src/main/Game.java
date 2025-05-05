package main;

import main.case2.Dialog;
import main.case2.IntegerMinMaxDialog;
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
    Dialog<Integer> dialog;

    public Game(Board board, Player firstPlayer, Player secondPlayer) {
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.renderer = new BoardRenderer(board);
        this.analyser = new GameResultAnalyser(board);
        this.firstAddress = 1;
        this.lastAddress = board.sideLength() * board.sideLength();
        this.dialog = new IntegerMinMaxDialog(
                "Введите число от %s до %d".formatted(firstAddress, lastAddress),
                "Вы ввели некорректное число",
                firstAddress,
                lastAddress);
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
            System.out.printf("%s,", currentPlayer.getName());
            Coordinates coordinates = inpitCoordinates();
            board.put(currentPlayer.getSymbol(), coordinates);
            if (isWin()) {
                showWinMessage();
                break;
            }
            if (isDraw()) {
                showDrawMessage();
                break;
            }
            changeCurrentPlayer();
        }
    }

    private void showWinMessage() {
        renderer.render();
        System.out.printf("%s игрок победил \n", currentPlayer.getName());
    }

    private boolean isWin() {
        return analyser.isWin(currentPlayer.getSymbol());
    }

    private boolean isDraw() {
        return analyser.isDraw(currentPlayer.getSymbol());
    }

    private void showDrawMessage() {
        renderer.render();
        System.out.println("Ничья");
    }

    private Coordinates inpitCoordinates() {
        while (true) {
            int address = dialog.input();
            Coordinates coordinates = addressToCoordinates(address);
            if (board.isEmpty(coordinates)) {
                return coordinates;
            }
            System.out.println("Координата занят, введите другую координату");
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
