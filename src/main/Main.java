package main;

import main.players.Player;
import main.players.RealPlayer;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardImp();
//        board.put(Symbol.X, 0, 0);
//        board.put(Symbol.X, 0, 1);
//        board.put(Symbol.O, 0, 2);
//        board.put(Symbol.O, 1, 0);
//        board.put(Symbol.O, 1, 1);
//        board.put(Symbol.X, 1, 2);
//        board.put(Symbol.O, 2, 0);
//        board.put(Symbol.X, 2, 1);
//        board.put(Symbol.X, 2, 2);
//
        Player firstPlayer = new RealPlayer(Symbol.X);
        Player secondPlayer = new RealPlayer(Symbol.O);

        Game game = new Game(board, firstPlayer, secondPlayer);
        game.start();

        BoardRenderer renderer = new BoardRenderer(board);
        renderer.render();
//
//        GameResultAnalyser analyser = new GameResultAnalyser(board);
//        System.out.println(analyser.isWin(Symbol.X));
    }
}