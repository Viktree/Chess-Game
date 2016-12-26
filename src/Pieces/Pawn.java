package Pieces;

import ChessMain.ChessBoard;

/**
 * Created by vikram on 20/12/16.
 */
public class Pawn extends Piece{

    private String colour;

    public Pawn(int x, int y, String colour){
        super(x, y, colour);
        this.symbol = "p";
        this.classicImage = "/Pieces/" + colour + "_Pawn_Classic.png";
    }

    public boolean isVaildMove(int i, int j) {
        boolean hasPiece = ChessBoard.Square[i][j] != null;

        if(colour == "white"){
            if (i == x && j == y + 1) {
                return !hasPiece;
            } else if (i == x && y == 1 && j == 3) {
                return !hasPiece;
            }
        } else if(colour == "black"){
            if (i == x && j == y - 1) {
                return !hasPiece;
            } else if (i == x && y == 6 && j == 4) {
                return !hasPiece;
            }
        }

        return false;
    }
}
