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

        if(this.colour == "White"){
            if (i == x && j == y + 1) {
                return !BoardManager.hasPiece(i, j);
            } else if (i == x && y == 1 && j == 3) {
                return !BoardManager.hasPiece(i, j);
            }
        } else if(this.colour == "Black"){
            if (i == x && j == y - 1) {
                return !BoardManager.hasPiece(i, j);
            } else if (i == x && y == 6 && j == 4) {
                return !BoardManager.hasPiece(i, j);
            }
        }

        return false;
    }
}
