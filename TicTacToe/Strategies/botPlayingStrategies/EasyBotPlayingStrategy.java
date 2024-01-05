package TicTacToe.Strategies.botPlayingStrategies;

import TicTacToe.Enums.CellState;
import TicTacToe.Models.Board;
import TicTacToe.Models.Bot;
import TicTacToe.Models.Cell;
import TicTacToe.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board) {
       for(List<Cell> row : board.getBoard()) {
           for(Cell cell : row) {
               if(cell.getCellState().equals(CellState.EMPTY)) {
                   return new Move(cell , null) ;
               }
           }
       }
        return null;
    }
}
