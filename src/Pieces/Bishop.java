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
        boolean squareIsFree = this.board.squareIsFree(i, j);

        if(j-i == y-x){
            if(Math.abs(x-i) > 1){
                int unitCloser = (x-i)/Math.abs(x-i);
                return squareIsFree && isVaildMove(i + unitCloser, j + unitCloser);
            }
            return squareIsFree;
        } else if (i+j == y+x) {
            if (Math.abs(y-j) > 1) {
                int unitCloser = (y-j)/Math.abs(y-j);
                return squareIsFree && isVaildMove(i - unitCloser, j + unitCloser);
            }
            return squareIsFree;
        }

        return false;
    }
}
