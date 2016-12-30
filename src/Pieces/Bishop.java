package Pieces;

import ChessMain.BoardManager;

/**
 * Created by vikram on 20/12/16.
 */
public class Bishop extends Piece{
    public Bishop(int x, int y, String colour){
        super(x, y, colour);
        this.symbol = "B";
        this.classicImage = "/Pieces/" + colour +"_Bishop_Classic.png";
    }

    public boolean isVaildMove(int i, int j) {

        if(j-i == y-x){
            if(Math.abs(x-i) > 1){
                int unitCloser = (x-i)/Math.abs(x-i);
                return !BoardManager.hasPiece(i, j) && isVaildMove(i + unitCloser, j + unitCloser);
            }
            return !BoardManager.hasPiece(i, j);
        } else if (i+j == y+x) {
            if (Math.abs(y-j) > 1) {
                int unitCloser = (y-j)/Math.abs(y-j);
                return !BoardManager.hasPiece(i, j) && isVaildMove(i - unitCloser, j + unitCloser);
            }
            return !BoardManager.hasPiece(i, j);
        }

        return false;
    }
}
