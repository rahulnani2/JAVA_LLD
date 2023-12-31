package TicTacToe.Strategies;
import TicTacToe.Models.Player;
import TicTacToe.Models.Board ;
public interface WinningStrategy {
    public boolean checkWinner(Player player, Board Board);
}
