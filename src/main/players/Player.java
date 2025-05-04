package main.players;

import main.Symbol;

public abstract class Player {

    private final String name;
    private final Symbol symbol;

    public Player(Symbol symbol) {
        this(symbol.name(), symbol);
    }

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }


}
