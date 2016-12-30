package ChessMain;

import GUI.Board;
import Pieces.*;

/**
 * Created by vikram on 29/12/16.
 */
public class BoardManager {

    private static Piece[][] Square = new Piece[8][8];
    private static BoardManager instance = new BoardManager();
    private Player whitePlayer, blackPlayer;

    private BoardManager(){

        whitePlayer = Player.newWhitePlayer();
        blackPlayer = Player.newBlackPlayer();
    }

    public static BoardManager getInstance(){
        return BoardManager.instance;
    }

    public static void addPiece(int i, int j, Piece piece){
        BoardManager.Square[i][j] = piece;
    }

    public static void removePiece(Piece piece){
        BoardManager.Square[piece.x][piece.y] = null;
    }

    public static Board getCurrBoard(){
        return new Board(BoardManager.Square);
    }

    public static boolean hasPiece(int i, int j){
        return BoardManager.Square[i][j] == null;
    }

    public String show(){
        String board = "\n   --- --- --- --- --- --- --- --- \n";
        for(int i = 7; i>=0; i--){
            board += i + " ";
            for(int j = 0; j<=7; j++){
                board += "|";
                Piece p = this.Square[j][i];
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
        BoardManager board = BoardManager.instance;
        System.out.println(board.show());

    }
}
