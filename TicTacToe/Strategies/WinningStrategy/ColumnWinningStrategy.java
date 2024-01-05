package TicTacToe.Strategies.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Player;
import TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    private Map<Integer, HashMap<Symbol, Integer>> counts= new HashMap<>() ;
    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!counts.containsKey(col)) {
            counts.put(col , new HashMap<>()) ;
        }
        HashMap<Symbol , Integer> colMap = counts.get(col) ;
        if(!colMap.containsKey(symbol)) {
            colMap.put(symbol, 0) ;
        }
        colMap.put(symbol , colMap.get(symbol) + 1 )  ;
        if(colMap.get(symbol) == board.getSize()) {
            return true ;
        }
        return false;
    }
    public void handleUndo(Board board , Move move) {
        int col = move.getCell().getCol() ;
        Symbol symbol = move.getPlayer().getSymbol();
        Map<Symbol , Integer> colMap = counts.get(col) ;
        colMap.put(symbol , colMap.get(symbol) -1 ) ;
    }
}
