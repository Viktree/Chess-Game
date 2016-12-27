package ChessMain;

/**
 * Created by vikram on 20/12/16.
 */

import Pieces.*;

public class BoardManager {

    public static Piece[][] Square = new Piece[8][8];
    private static BoardManager instance = new BoardManager();

    private static Player whitePlayer, blackPlayer;

    private BoardManager(){
        // Creates Squares for the BoardManager
        for(int i  = 7; i>= 0; i--){
            for(int j = 0; j <=7; j++){
                BoardManager.Square[i][j] = null;
            }
        }

        // Players
        whitePlayer = Player.newWhitePlayer();
        blackPlayer = Player.newBlackPlayer();
    }

    public static BoardManager getInstance(){
        return instance;
    }

    private String show(){
        String board = "\n   --- --- --- --- --- --- --- --- \n";
        for(int i = 7; i>=0; i--){
                board += i + " ";
            for(int j = 0; j<=7; j++){
                board += "|";
                Piece p = BoardManager.Square[j][i];
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
        BoardManager board = BoardManager.getInstance();
        Pawn p = BoardManager.whitePlayer.a_pawn;
        //p.moveTo(3, 4);
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