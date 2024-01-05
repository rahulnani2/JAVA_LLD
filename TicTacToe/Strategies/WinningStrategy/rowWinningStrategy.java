package TicTacToe.Strategies.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Player;
import TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class rowWinningStrategy implements WinningStrategy {
    private Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();
    @Override

    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        if (!counts.containsKey(row)) {
                counts.put(row, new HashMap<>());
            }
            HashMap<Symbol, Integer> rowMap = counts.get(row);
            if (!rowMap.containsKey(symbol)) {
                rowMap.put(symbol, 0);
            }
            rowMap.put(symbol, rowMap.get(symbol) + 1);
            if (rowMap.get(symbol) == board.getSize()) {
                return true;
            }
            return false;
        }
        public void handleUndo(Board board , Move move) {
            int row = move.getCell().getRow() ;
            Symbol symbol = move.getPlayer().getSymbol();
            Map<Symbol , Integer> rowMap = counts.get(row) ;
            rowMap.put(symbol , rowMap.get(symbol) -1 ) ;
        }
}
