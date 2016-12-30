package Pieces;

import ChessMain.BoardManager;

/**
 * Created by vikram on 20/12/16.
 */
public class Rook extends Piece{

    public Rook(int x, int y, String colour){
        super(x, y, colour);
        this.symbol = "R";
        this.classicImage = "/Pieces/" + colour +"_Rook_Classic.png";
    }

    public boolean isVaildMove(int i, int j) {

        if(j == y) {
            if(Math.abs(x-i) > 1){
                int unitCloser = (x-i)/Math.abs(x-i);
                return this.board.squareIsFree(i, j) && isVaildMove(i + unitCloser, j);
            }
            return this.board.squareIsFree(i, j);
        } else if (i == x) {
            if(Math.abs(y-j) > 1){
                int unitCloser = (y-j)/Math.abs(y-j);
                return this.board.squareIsFree(i, j) && isVaildMove(i, j + unitCloser);
            }
            return this.board.squareIsFree(i, j);
        }

        return false;
    }

}

