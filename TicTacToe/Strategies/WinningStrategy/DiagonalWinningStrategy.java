package TicTacToe.Strategies.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Player;
import TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

    private Map<Symbol , Integer> leftDiagonalCounts = new HashMap<>() ;
    private Map<Symbol, Integer> rightDiagonalCounts = new HashMap<>() ;
    @Override
    public boolean checkWinner(Move move, Board board) {
        // Left diagonal --> row == Col (i ==j) ;
        //right diagonal --> row + col == N-1 ;
        int row = move.getCell().getRow();
        int col = move.getCell().getCol() ;
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col ) {
            if(!leftDiagonalCounts.containsKey(symbol)) {
                leftDiagonalCounts.put(symbol,0) ;
            }
            leftDiagonalCounts.put(symbol , leftDiagonalCounts.get(symbol)+1) ;
            if(leftDiagonalCounts.get(symbol) == board.getSize()) {
                return true ;
            }
        } else if(row+col == board.getSize()-1) {
            if(!rightDiagonalCounts.containsKey(symbol)) {
                rightDiagonalCounts.put(symbol,0) ;
            }
            rightDiagonalCounts.put(symbol , rightDiagonalCounts.get(symbol) +1) ;
           if(rightDiagonalCounts.get(symbol) == board.getSize()-1) {
               return true ;
           }
        }
         return false;
    }
    public void handleUndo(Board board , Move move) {
        int row = move.getCell().getRow() ;
        int col = move.getCell().getCol() ;
        Symbol symbol = move.getPlayer().getSymbol();
        if(row == col ) {
         leftDiagonalCounts.put(symbol, leftDiagonalCounts.get(symbol)-1) ;
        } else if(row+col == board.getSize()-1) {
        rightDiagonalCounts.put(symbol , rightDiagonalCounts.get(symbol)-1) ;
        }
    }
}
