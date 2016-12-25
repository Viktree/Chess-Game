package Pieces;

import ChessMain.ChessBoard;

/**
 * Created by vikram on 20/12/16.
 */
public class Queen extends Piece {
    public Queen(int x, int y){
        super(x, y);
        this.symbol = "Q";
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
        } else if(j-i == y-x){
            if(i+1 < x){
                return !hasPiece && isVaildMove(i + 1,j + 1);
            } else if(i-1 > x){
                return !hasPiece && isVaildMove(i - 1,j - 1);
            }
        } else if (i+j == y+x) {
            if (j + 1 < y) {
                return !hasPiece && isVaildMove(i - 1, j + 1);
            } else if (j - 1 > y) {
                return !hasPiece && isVaildMove(i + 1, j - 1);
            }
        } else {
            return false;
        }
        return !hasPiece;
    }
}
