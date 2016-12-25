package Pieces;

/**
 * Created by vikram on 20/12/16.
 */
public class Pawn extends Piece{
    public Pawn(int x, int y){
        super(x, y);
        this.symbol = "p";
    }

    public boolean isVaildMove(int i, int j) {
        return true;
    }
}
