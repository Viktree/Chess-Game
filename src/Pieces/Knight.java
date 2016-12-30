package Pieces;

import ChessMain.BoardManager;

/**
 * Created by vikram on 20/12/16.
 */
public class Knight extends Piece{
    public Knight(int x, int y, String colour){
        super(x, y, colour);
        this.symbol = "N";
        this.classicImage = "/Pieces/" + colour + "_Knight_Classic.png";
    }

    public boolean isVaildMove(int i, int j) {
        if((Math.abs(x-i) == 1 & Math.abs(y-j) == 2) || (Math.abs(x-i) == 2 & Math.abs(y-j) == 1)){
            return this.board.squareIsFree(i, j);
        }
        return false;
    }
}
