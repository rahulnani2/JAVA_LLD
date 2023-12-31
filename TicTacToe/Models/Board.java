package TicTacToe.Models;
import java.util.List ;
public class Board {
 private int Size ;

 public Board(int dimension) {
     this.Size = dimension ;
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
