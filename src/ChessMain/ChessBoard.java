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
        for(int i  = 7; i>=0; i--){
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
        String board = " --- --- --- --- --- --- --- --- \n";
        for(int i = 7; i>=0; i--){
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

            board += " --- --- --- --- --- --- --- --- \n";
        }
        return board;
    }

    public static void main(String[] args) {
        ChessBoard board = ChessBoard.getInstance();
        Knight p = ChessBoard.whitePlayer.b_knight;
        System.out.println(board.show());
        for(int i = 7; i>=0; i--){
            for(int j = 0; j<=7; j++) {
                if(p.isVaildMove(i, j)){
                    System.out.println(i+ " " + j);
                }
            }
        }
    }
}
