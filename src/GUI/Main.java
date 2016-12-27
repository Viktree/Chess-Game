package GUI;

import ChessMain.BoardManager;
import Pieces.Piece;
import Pieces.*;
import javafx.application.Application;

import javafx.beans.Observable;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import java.util.Observer;

/**
 * Created by vikram on 26/12/16.
 */
public class Main extends Application {

    private Board chessBoard;

    public Main(){
        this.chessBoard = new Board();

        Piece p = BoardManager.Square[0][7];
        p.addObserver(this.chessBoard);
        p.moveTo(3, 4);

    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.autosize();
        Scene scene = new Scene(root);

        root.setCenter(chessBoard);
        primaryStage.setTitle("Chess BoardManager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
