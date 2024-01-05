package TicTacToe.Models;

import TicTacToe.Enums.playerType;

import java.util.Scanner;

public class Player {
   private int id ;
   private String name ;
   private playerType playerType ;
   private Symbol symbol ;
    public Scanner scanner ;
    public Player(int id , String name , playerType playerType , Symbol symbol) {
        this.id = id ;
        this.name = name ;
        this.playerType = playerType ;
        this.symbol = symbol ;
        this.scanner = new Scanner(System.in) ;
    }

    public Move makeMove(Board board) {
        System.out.println("Please mention the row number to move");
        int row = scanner.nextInt() ;
        System.out.println("Please mention the column number to move");
        int col = scanner.nextInt() ;
        return new Move(new Cell(row ,col) , this) ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
