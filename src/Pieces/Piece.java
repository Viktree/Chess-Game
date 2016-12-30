package Pieces;

import ChessMain.BoardManager;


/**
 * Created by vikram on 21/12/16.
 */
public abstract class Piece{
    private BoardManager board = BoardManager.getInstance();
    public String symbol;
    public String classicImage;
    protected String colour;
    public int x, y;

    public Piece(int x, int y, String colour){
        this.x = x;
        this.y = y;
        this.colour = colour;
        board.addPiece(x, y, this);
    }

    public void moveTo(int i, int j){
        board.removePiece(this);
        board.addPiece(i, j, this);
        this.x = i;
        this.y = j;
    }

    public abstract boolean isVaildMove(int i, int j);

}