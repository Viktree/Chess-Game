package Pieces;

import ChessMain.BoardManager;

import java.util.Observable;

/**
 * Created by vikram on 21/12/16.
 */
public abstract class Piece extends Observable{

    public String symbol;
    public String classicImage;
    protected String colour;
    protected int x, y;

    public Piece(int x, int y, String colour){
        this.x = x;
        this.y = y;
        this.colour = colour;
        BoardManager.Square[x][y] = this;
    }

    public abstract boolean isVaildMove(int i, int j);

    public void moveTo(int i, int j){
        BoardManager.Square[i][j] = this;
        BoardManager.Square[x][y] = null;
        x = i;
        y = j;
        notifyObservers();
        System.out.println("Made it here!" + this.countObservers());

    }
}