package GUI;

import ChessMain.BoardManager;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by vikram on 26/12/16.
 */
public class App extends Application {

    private BoardManager controller = BoardManager.getInstance();
    private Board chessBoard = controller.getCurrBoard();

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.autosize();
        root.setCenter(chessBoard);

        chessBoard.setOnMouseClicked(this.reloadBoard(stage));

        stage.setTitle("Chess Board");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private EventHandler<MouseEvent> reloadBoard(Stage stage){
        return event -> {
            if (chessBoard.toBeReset) {
                chessBoard = controller.getCurrBoard();
                start(stage);
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }

}
