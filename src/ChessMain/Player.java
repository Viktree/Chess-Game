package ChessMain;

import Pieces.*;

/**
 * Created by vikram on 24/12/16.
 */
public class Player {

    // Two Types of players
    private static Player white = new Player(0, 1);
    private static Player black = new Player(7, 6);

    // Player's Pieces
    King king;
    Queen queen;
    Bishop b_bishop, w_bishop;
    Knight b_knight, g_knight;
    Rook a_rook, h_rook;
    Pawn a_pawn, b_pawn, c_pawn, d_pawn, e_pawn, f_pawn, g_pawn, h_pawn;


    private Player(int pieceHomeRow, int pawnHomeRow){
        this.a_rook = new Rook(0, pieceHomeRow);
        this.b_knight = new Knight(1, pieceHomeRow);
        this.b_bishop = new Bishop(2, pieceHomeRow);
        this.queen = new Queen(3, pieceHomeRow);
        this.king = new King(4, pieceHomeRow);
        this.w_bishop = new Bishop(5, pieceHomeRow);
        this.g_knight = new Knight(6, pieceHomeRow);
        this.h_rook = new Rook(7, pieceHomeRow);

        this.a_pawn = new Pawn(0, pawnHomeRow);
        this.b_pawn = new Pawn(1, pawnHomeRow);
        this.c_pawn = new Pawn(2, pawnHomeRow);
        this.d_pawn = new Pawn(3, pawnHomeRow);
        this.e_pawn = new Pawn(4, pawnHomeRow);
        this.f_pawn = new Pawn(5, pawnHomeRow);
        this.g_pawn = new Pawn(6, pawnHomeRow);
        this.h_pawn = new Pawn(7, pawnHomeRow);
    }

    public static Player newWhitePlayer(){
        return white;
    }

    public static Player newBlackPlayer(){
        return black;
    }

}
