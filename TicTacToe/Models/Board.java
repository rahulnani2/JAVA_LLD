package TicTacToe.Models;
import java.util.ArrayList;
import java.util.List ;
public class Board {
 private int Size ;
 private List<List<Cell>> board ;


    public Board(int dimension) {
        this.Size = dimension ;
        board = new ArrayList<>() ;
        // Initalize a new arraylist for each cell
        for(int i =0 ; i < dimension ; i++) {
            board.add(new ArrayList<>()) ;
            for(int j= 0; j < dimension ; j++) {
                board.get(i).add(new Cell(i , j)) ;
            }
        }
    }
    public void printBoard() {
        for(List<Cell> row :board) {
            for(Cell cell : row) {
                cell.display() ;
            }
            System.out.println();
        }
    }
    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }


    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public List<List<Cell>> getCell() {
        return cell;
    }

    public void setCell(List<List<Cell>> cell) {
        this.cell = cell;
    }

    private List<List<Cell>> cell ;

}
