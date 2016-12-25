package Pieces;

import ChessMain.ChessBoard;

/**
 * Created by vikram on 20/12/16.
 */
public class Knight extends Piece{
    public Knight(int x, int y){
        super(x,y);
        this.symbol = "N";
    }

    public boolean isVaildMove(int i, int j) {
        if((Math.abs(x-i) == 1 & Math.abs(y-j) == 2) || (Math.abs(x-i) == 2 & Math.abs(y-j) == 1)){
            return ChessBoard.Square[i][j] == null;
        }
        return false;
    }
}
