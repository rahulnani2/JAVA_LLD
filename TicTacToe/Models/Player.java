package TicTacToe.Models;

import TicTacToe.Enums.playerType;

public class Player {
   private int id ;
   private int name ;
   private playerType playerType ;
   private Symbol symbol ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public TicTacToe.Enums.playerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(TicTacToe.Enums.playerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
