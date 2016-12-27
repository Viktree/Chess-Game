package Pieces;

import ChessMain.BoardManager;

/**
 * Created by vikram on 20/12/16.
 */
public class Pawn extends Piece{

    public Pawn(int x, int y, String colour){
        super(x, y, colour);
        this.symbol = "p";
        this.classicImage = "/Pieces/" + colour + "_Pawn_Classic.png";
    }

    public boolean isVaildMove(int i, int j) {
        boolean hasPiece = BoardManager.Square[i][j] != null;

        if(this.colour == "White"){
            if (i == x && j == y + 1) {
                return !hasPiece;
            } else if (i == x && y == 1 && j == 3) {
                return !hasPiece;
            }
        } else if(this.colour == "Black"){
            if (i == x && j == y - 1) {
                return !hasPiece;
            } else if (i == x && y == 6 && j == 4) {
                return !hasPiece;
            }
        }

        return false;
    }
}
