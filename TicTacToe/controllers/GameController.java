package TicTacToe.controllers;

import TicTacToe.Enums.GameState;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Exceptions.InvalidSymbolSelectionException;
import TicTacToe.Models.Game;
import TicTacToe.Models.Player;
import TicTacToe.Strategies.WinningStrategy;

import java.util.List ;
public class GameController {
    public Game startGame(int dimension, List<Player> players,
                          List<WinningStrategy> winningStrategies) throws
            InvalidBotCountException , InvalidPlayerCountException , InvalidSymbolSelectionException {
    //Validate the parameters
      return Game.getBuilder()
              .setDimension(dimension)
              .setPlayers(players)
              .setWinningStrategies(winningStrategies)
              .build();
    }
    public void displayBoard(Game game) {

    }
    public void MakeMove(Game game ) {

    }
    public GameState checkState(Game game) {
        return null ;
    }
    public Player getWinner(Game game) {
        return null ;
    }

    public void undo() {

    }
}


//Client --> GameController --> Services/Models
// Basic Functionalities for the game - Methods to be implemented
// 1. Start the Game

// 2. while the game state is IN_Progress
// 2.1 Display the board
// 2.2 Make the move

// 3. Based on the Game state return the result
//  DRAW : Mention Draw Result
//  Winner : Get the winner and return

// 4. Undo