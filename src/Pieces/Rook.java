package Pieces;

import ChessMain.ChessBoard;

/**
 * Created by vikram on 20/12/16.
 */
public class Rook extends Piece{

    public Rook(int x, int y){
        super(x, y);
        this.symbol = "R";
    }

    public boolean isVaildMove(int i, int j) {
        boolean hasPiece = ChessBoard.Square[i][j] != null;
        if(j == y){
            if(i+1 < x){
                return !hasPiece && isVaildMove(i + 1,j);
            } else if(i-1 > x){
                return !hasPiece && isVaildMove(i - 1,j);
            }
        } else if (i == x) {
            if (j + 1 < y) {
                return !hasPiece && isVaildMove(i, j + 1);
            } else if (j - 1 > y) {
                return !hasPiece && isVaildMove(i, j - 1);
            }
        } else {
            return false;
        }
        return !hasPiece;
    }

}

