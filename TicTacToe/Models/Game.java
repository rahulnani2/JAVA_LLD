package TicTacToe.Models;

import TicTacToe.Enums.CellState;
import TicTacToe.Enums.GameState;
import TicTacToe.Enums.playerType;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Exceptions.InvalidSymbolSelectionException;
import TicTacToe.Strategies.WinningStrategy.WinningStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.nio.file.Files.move;

public class Game {
private Board board ;
private List<Player> players ;
private List<Move> moves ;
private Player winner;
private int nextPlayerMoveIndex ;
private GameState gameState ;
private List<WinningStrategy> winningStrategies ;

// Constructor for the Game
    private Game(int dimension , List<Player> players , List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension) ;
        this.players = players ;
        this.winningStrategies = winningStrategies ;
        this.gameState = GameState.INPROGRESS ;
        this.winner = null ;
        this.nextPlayerMoveIndex = 0 ;
        this.moves = new ArrayList<>() ;
    }

    public static Builder getBuilder() {
        return new Builder() ;
    }

    // Builder inner class for building the Game object using builder design pattern
    public static class Builder {
    private int dimension ;
    private List<Player> players ;
    private  List<WinningStrategy> winningStrategies ;

   //Setters for the attributes in Builder class
    public Builder setDimension(int dimension) {
        this.dimension = dimension;
        return this ;
    }

    public Builder setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
        return this ;
    }
    public Builder addPlayer(Player player) {
        this.players.add(player);
        return this;
    }
    public Builder addWinningStrategies(WinningStrategy winningStrategy) {
        this.winningStrategies.add(winningStrategy);
        return this ;
    }
//     public void validate() throws InvalidBotCountException ,InvalidPlayerCountException  {
//        //Validate bot count
//         checkBotCount() ;
//         checkPlayerCount() ;
//     }
     // Functions for Validating the input parameters
        // Check bot count
        public boolean checkBotCount() throws InvalidBotCountException{
        int count = 0;
        for(Player p : players) {
                if(p.getPlayerType().equals(playerType.BOT)) {
                    count++ ;
                }
                if(count > 1) {
                    throw new InvalidBotCountException() ;
                } else {
                    return true ;
                }
            }
        return true ;
    }
    // Check for Player Count
        public boolean checkPlayerCount() throws InvalidPlayerCountException{
          if(players.size() > dimension-1) {
              throw new InvalidPlayerCountException() ;
           } else {
              return true ;
          }
        }

        public boolean checkValidSymbol(ArrayList<Player> player) throws InvalidSymbolSelectionException{
            HashMap<Character, Integer> symbolMap = new HashMap<>() ;
        for(Player p : players ) {
                if(!symbolMap.containsKey(p.getSymbol().getSymbol())) {
                    symbolMap.put(p.getSymbol().getSymbol() , p.getId() ) ;
                }  else {
                    throw new InvalidSymbolSelectionException() ;
                }
            }
        return true ;
        }

    public Game build() throws InvalidBotCountException , InvalidPlayerCountException, InvalidSymbolSelectionException {
        // Validations
        checkBotCount() ;
        checkPlayerCount() ;
        checkValidSymbol((ArrayList<Player>) this.players) ;
        return new Game(this.dimension , this.players , this.winningStrategies) ;
    }
}
    public void printBoard() {
        board.printBoard() ;
    }

    public boolean validateMove(Move move) {
        int row = move.getCell().getRow() ;
        int col = move.getCell().getCol() ;
        if(row >= board.getSize()) {
            return false ;
        }
        if(col >= board.getSize()) {
            return false ;
        }
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY) ;
    }
    public void makeMove() {
        Player currentMovePlayer = players.get(nextPlayerMoveIndex) ;
        System.out.println("It is "
                + currentMovePlayer.getName() + "'s turn .Please make move");
        Move move = currentMovePlayer.makeMove(board) ;

        if(!validateMove(move)) {
            System.out.println("Invalid Move ! Please try again") ;
            return ;
        }
        int row = move.getCell().getRow() ;
        int col = move.getCell().getCol() ;
        Cell cellToBeUpdated = board.getBoard().get(row).get(col) ;
        cellToBeUpdated.setCellState(CellState.FILLED);
        cellToBeUpdated.setPlayer(currentMovePlayer);

        Move finalMoveObject = new Move(cellToBeUpdated , currentMovePlayer) ;
        moves.add(finalMoveObject) ;

        nextPlayerMoveIndex +=1 ;
        nextPlayerMoveIndex %= players.size() ;

        if(checkWinner(board , finalMoveObject)) {
            gameState = GameState.SUCCESS ;
            winner = currentMovePlayer ;
        } else if(moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW ;
        }
        System.out.println("Player " + currentMovePlayer.getName() +
                " Moved at " + move.getCell().getRow() + " ," + move.getCell().getCol());
    }

    public boolean checkWinner(Board board , Move move) {
        for(WinningStrategy winningStrategy : winningStrategies) {
            if(winningStrategy.checkWinner(move , board)) {
                return true ;
            }
        }
        return false ;
    }

    public void undo() {
       if(moves.size() == 0 ) {
           System.out.println("No moves made to undo ! Make a move ") ;
            return ;
       }
       Move move = moves.get(moves.size() -1 ) ;
       moves.remove(move) ;
       Cell cell = move.getCell() ;
       cell.setPlayer(null) ;
       cell.setCellState(CellState.EMPTY);

       nextPlayerMoveIndex -=1 ;
       nextPlayerMoveIndex = (nextPlayerMoveIndex + players.size()) % players.size() ;

       for(WinningStrategy winningStrategy :winningStrategies) {
           winningStrategy.handleUndo(board,move);

       }
    }
    //Getters and Setters for all the private attributes of the class Game
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}






