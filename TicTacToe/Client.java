package TicTacToe;

import TicTacToe.Enums.BotDifficultyLevel;
import TicTacToe.Enums.GameState;
import TicTacToe.Enums.playerType;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Exceptions.InvalidSymbolSelectionException;
import TicTacToe.Models.Bot;
import TicTacToe.Models.Game;
import TicTacToe.Models.Player;
import TicTacToe.Models.Symbol;
import TicTacToe.Strategies.WinningStrategy.ColumnWinningStrategy;
import TicTacToe.Strategies.WinningStrategy.DiagonalWinningStrategy;
import TicTacToe.Strategies.WinningStrategy.WinningStrategy;
import TicTacToe.Strategies.WinningStrategy.rowWinningStrategy;
import TicTacToe.controllers.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException,
            InvalidPlayerCountException, InvalidSymbolSelectionException {
        Scanner sc = new Scanner(System.in) ;
        GameController gameController = new GameController();
        System.out.println("Starting the TicTacToe game");
        try {
            int dimensionForGame =3 ;
            List<Player> players = new ArrayList<>() ;
            players.add(new Player(1,"Rahul" , playerType.HUMAN , new Symbol('R'))) ;
            players.add(new Bot(2 , "System", new Symbol('S'), BotDifficultyLevel.EASY)) ;
            List<WinningStrategy> winningStrategies = List.of(new rowWinningStrategy() ,
                                                    new ColumnWinningStrategy() ,
                                                    new DiagonalWinningStrategy())  ;
            Game game = gameController.startGame(dimensionForGame , players , winningStrategies) ;
            gameController.displayBoard(game);
            while(gameController.checkState(game).equals(GameState.INPROGRESS)) {
                gameController.MakeMove(game);
                gameController.displayBoard(game);
                System.out.println("Do  anyone wants to undo the move (y/n)");
                String undoResponse = sc.next() ;
                if(undoResponse.equals("y")) {
                    gameController.undo(game);
                    gameController.displayBoard(game);
                }

            }
            System.out.println("The Game is finished ! ");
            GameState gameState = gameController.checkState(game) ;
            if(gameState.equals(GameState.DRAW)) {
                System.out.println("The Result is DRAW!!");
            } else {
                System.out.println("The Winner is " + gameController.getWinner(game).getName());
            }
        } catch(Exception e) {
            System.out.println("Game  Has Stopped working");
        }
/*        Game game = gameController.startGame(3,new ArrayList<>() , new ArrayList<>());
        gameController.displayBoard(game);
        while(gameController.checkState(game).equals(GameState.INPROGRESS)) {
            gameController.MakeMove(game);
            gameController.displayBoard(game);
        }
    if(gameController.checkState(game).equals(GameState.DRAW)){
        System.out.println("Game is Drawn");
    }else if(gameController.checkState(game).equals(GameState.SUCCESS)) {
        System.out.println("Winner is : " + gameController.getWinner(game).getName());
        }*/
    }
}
