package main;

import main.players.Player;
import main.players.RealPlayer;

public class Main {

    public static void main(String[] args) {
        Board board = new BoardImp();
        Player firstPlayer = new RealPlayer(Symbol.X);
        Player secondPlayer = new RealPlayer("rere",Symbol.O);
        Game game = new Game(board, firstPlayer, secondPlayer);
        game.start();
    }
}