package Pieces;

import ChessMain.ChessBoard;

/**
 * Created by vikram on 21/12/16.
 */
public class King extends Piece {
    public King(int x, int y){
        super(x, y);
        this.symbol = "K";
    }

    public boolean isVaildMove(int i, int j) {
        boolean validx = (i == x) || (i - 1 == x) || (i + 1 == x);
        boolean validy = (j == y) || (j - 1 == y) || (j + 1 == y);
        boolean notSameSquare = (i == x) && (j == y);
        boolean hasPiece = ChessBoard.Square[i][j] != null;

        return validx && validy && !notSameSquare &&  !hasPiece;
    }
}
