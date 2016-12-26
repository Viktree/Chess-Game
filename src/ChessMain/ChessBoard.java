package ChessMain;

/**
 * Created by vikram on 20/12/16.
 */

import java.util.*;
import Pieces.*;

public class ChessBoard {

    public static Piece[][] Square = new Piece[8][8];
    private static ChessBoard instance = new ChessBoard();

    private static Player whitePlayer, blackPlayer;

    private ChessBoard(){
        // Creates Squares for the Board
        for(int i  = 7; i>= 0; i--){
            for(int j = 0; j <=7; j++){
                ChessBoard.Square[i][j] = null;
            }
        }

        // Players
        whitePlayer = Player.newWhitePlayer();
        blackPlayer = Player.newBlackPlayer();
    }

    public static ChessBoard getInstance(){
        return instance;
    }

    public String show(){
        String board = "\n   --- --- --- --- --- --- --- --- \n";
        for(int i = 7; i>=0; i--){
                board += i + " ";
            for(int j = 0; j<=7; j++){
                board += "|";
                Piece p = ChessBoard.Square[j][i];
                if (p != null){
                    board += " " + p.symbol + " ";
                } else {
                    board += "   ";
                }
            }
            board += "|\n";

            board += "   --- --- --- --- --- --- --- --- \n";
        }
        board += "    0   1   2   3   4   5   6   7  \n";
        return board;
    }

    public static void main(String[] args) {
        ChessBoard board = ChessBoard.getInstance();
        Pawn p = ChessBoard.whitePlayer.a_pawn;
        p.moveto(3, 4);
        System.out.println(board.show());
        for(int i = 7; i >= 0; i--){
            for(int j = 0; j <= 7; j++) {
                if(p.isVaildMove(i, j)){
                    System.out.println(i+ " " + j);
                }
            }
        }
    }
}
