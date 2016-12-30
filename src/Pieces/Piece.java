package Pieces;

import ChessMain.BoardManager;


/**
 * Created by vikram on 21/12/16.
 */
public abstract class Piece{

    public int x, y;
    public String symbol;
    public String classicImage;

    protected String colour;
    protected static BoardManager board = BoardManager.getInstance();

    public Piece(int x, int y, String colour){
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.board.addPiece(x, y, this);
    }

    public void moveTo(int i, int j){
        System.out.println(this.isVaildMove(i,j));
        if(this.isVaildMove(i,  j)){
            this.board.removePiece(this);
            this.board.addPiece(i, j, this);
            this.x = i;
            this.y = j;
        }
    }

    public abstract boolean isVaildMove(int i, int j);

}