package Pieces;

import ChessMain.BoardManager;

/**
 * Created by vikram on 20/12/16.
 */
public class Queen extends Piece {
    public Queen(int x, int y, String colour){
        super(x, y, colour);
        this.symbol = "Q";
        this.classicImage = "/Pieces/" + colour +"_Queen_Classic.png";
    }

    public boolean isVaildMove(int i, int j) {

        if(j == y) {
            if(Math.abs(x-i) > 1){
                int unitCloserX = (x-i)/Math.abs(x-i);
                return this.board.squareIsFree(i, j) && isVaildMove(i + unitCloserX, j);
            }
            return this.board.squareIsFree(i, j) ;
        } else if(j-i == y-x){
            if(Math.abs(x-i) > 1){
                int unitCloserX = (x-i)/Math.abs(x-i);
                return this.board.squareIsFree(i, j) && isVaildMove(i + unitCloserX, j + unitCloserX);
            }
            return this.board.squareIsFree(i, j);
        } else if (i == x) {
            if(Math.abs(y-j) > 1){
                int unitCloserY = (y-j)/Math.abs(y-j);
                return this.board.squareIsFree(i, j) && isVaildMove(i, j + unitCloserY);
            }
            return this.board.squareIsFree(i, j);
        } else if (i+j == y+x) {
            int unitCloserY = (y-j)/Math.abs(y-j);
            if (Math.abs(y-j) > 1) {
                return this.board.squareIsFree(i, j) && isVaildMove(i - unitCloserY, j + unitCloserY);
            }
            return this.board.squareIsFree(i, j);
        }

        return false;
    }
}
