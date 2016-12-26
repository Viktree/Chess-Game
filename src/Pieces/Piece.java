package Pieces;

import ChessMain.ChessBoard;

/**
 * Created by vikram on 21/12/16.
 */
public abstract class Piece {

    public String symbol;
    public String classicImage;
    private String colour;
    protected int x, y;

    public Piece(int x, int y, String colour){
        this.x = x;
        this.y = y;
        this.colour = colour;
        ChessBoard.Square[x][y] = this;
    }

    public abstract boolean isVaildMove(int i, int j);

    public void moveto(int i, int j){
        ChessBoard.Square[i][j] = this;
        ChessBoard.Square[x][y] = null;
        x = i;
        y = j;
    }
}