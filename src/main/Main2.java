package main;

import main.players.Player;
import main.players.RealPlayer;

public class Main2 {
    public static void main(String[] args) {
        Board board = new BoardImp(4);
        Player firstPlayer = new RealPlayer(Symbol.A);
        Player secondPlayer = new RealPlayer(Symbol.B);
        Game game = new Game(board, firstPlayer, secondPlayer);
        game.start();
    }
}