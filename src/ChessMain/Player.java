package ChessMain;

import Pieces.*;

import java.util.ArrayList;

/**
 * Created by vikram on 24/12/16.
 */
public class Player {

    // Two Types of players
    private static Player white = new Player(0, 1, "White");
    private static Player black = new Player(7, 6, "Black");
    public ArrayList<Piece> pieces = new ArrayList<>();

    // Player's Pieces
    King king;
    Queen queen;
    Bishop b_bishop, w_bishop;
    Knight b_knight, g_knight;
    Rook a_rook, h_rook;
    Pawn a_pawn, b_pawn, c_pawn, d_pawn, e_pawn, f_pawn, g_pawn, h_pawn;


    private Player(int pieceHomeRow, int pawnHomeRow, String colour){
        this.a_rook = new Rook(0, pieceHomeRow, colour);
        this.b_knight = new Knight(1, pieceHomeRow, colour);
        this.b_bishop = new Bishop(2, pieceHomeRow, colour);
        this.queen = new Queen(3, pieceHomeRow, colour);
        this.king = new King(4, pieceHomeRow, colour);
        this.w_bishop = new Bishop(5, pieceHomeRow, colour);
        this.g_knight = new Knight(6, pieceHomeRow, colour);
        this.h_rook = new Rook(7, pieceHomeRow, colour);

        this.a_pawn = new Pawn(0, pawnHomeRow, colour);
        this.b_pawn = new Pawn(1, pawnHomeRow, colour);
        this.c_pawn = new Pawn(2, pawnHomeRow, colour);
        this.d_pawn = new Pawn(3, pawnHomeRow, colour);
        this.e_pawn = new Pawn(4, pawnHomeRow, colour);
        this.f_pawn = new Pawn(5, pawnHomeRow, colour);
        this.g_pawn = new Pawn(6, pawnHomeRow, colour);
        this.h_pawn = new Pawn(7, pawnHomeRow, colour);
    }

    public static Player newWhitePlayer(){
        return white;
    }

    public static Player newBlackPlayer(){
        return black;
    }

}
