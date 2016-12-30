package Pieces;

import ChessMain.BoardManager;

/**
 * Created by vikram on 21/12/16.
 */
public class King extends Piece {
    public King(int x, int y, String colour){
        super(x, y, colour);
        this.symbol = "K";
        this.classicImage = "/Pieces/" + colour +"_King_Classic.png";
    }

    public boolean isVaildMove(int i, int j) {
        boolean validx = (i == x) || (i - 1 == x) || (i + 1 == x);
        boolean validy = (j == y) || (j - 1 == y) || (j + 1 == y);
        boolean notSameSquare = (i == x) && (j == y);


        return validx && validy && !notSameSquare &&  !BoardManager.hasPiece(i, j);
    }
}
