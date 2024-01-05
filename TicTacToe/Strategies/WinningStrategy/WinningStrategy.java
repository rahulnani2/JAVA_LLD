package TicTacToe.Strategies.WinningStrategy;
import TicTacToe.Models.Move;
import TicTacToe.Models.Player;
import TicTacToe.Models.Board ;
public interface WinningStrategy {
    public boolean checkWinner(Move move, Board Board);
    public void handleUndo(Board board ,Move move ) ;
}
