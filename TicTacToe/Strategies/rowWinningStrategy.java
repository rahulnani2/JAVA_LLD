package TicTacToe.Strategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Player;

public class rowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Player player, Board Board) {
        return false;
    }
}
