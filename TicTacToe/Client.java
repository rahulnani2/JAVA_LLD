package TicTacToe;

import TicTacToe.Enums.GameState;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Exceptions.InvalidSymbolSelectionException;
import TicTacToe.Models.Game;
import TicTacToe.controllers.GameController;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException, InvalidSymbolSelectionException {
        GameController gameController = new GameController();
        System.out.println("Starting the TicTacToe game");
        Game game = gameController.startGame(3,new ArrayList<>() , new ArrayList<>());
        gameController.displayBoard(game);
        while(gameController.checkState(game).equals(GameState.INPROGRESS)) {
            gameController.MakeMove(game);
            gameController.displayBoard(game);
        }
    if(gameController.checkState(game).equals(GameState.DRAW)){
        System.out.println("Game is Drawn");
    }else if(gameController.checkState(game).equals(GameState.SUCCESS)) {
        System.out.println("Winner is : " + gameController.getWinner(game).getName());
        }
    }
}
