package GUI;

import Pieces.*;
import Pieces.Piece;
import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Created by vikram on 26/12/16.
 */
public class ChessBoard extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.autosize();
        Scene scene = new Scene(root);

        GridPane gridpane = createBoard();

        root.setCenter(gridpane);
        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private enum Letter{
        A,B,C,D,E,F,G,H
    }

    public GridPane createBoard(){
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(7));
        gridpane.setHgap(8);
        gridpane.setVgap(8);

        // Create Tiles
        for(int i  = 7; i>= 0; i--){
            for(int j = 0; j <=7; j++){
                StackPane tile = createTile(i, j);

                gridpane.add(tile, i+1, j);
            }
        }

        // Create Labels
        int t = 1;
        for(Letter l: Letter.values()){
            gridpane.add(new Label(l.toString()), t, 8);
            gridpane.add(new Label(String.valueOf(9-t)), 0, t-1);
            t++;
        }

        return gridpane;
    }

    private StackPane createTile(int i, int j){
        Piece p = ChessMain.ChessBoard.Square[i][j];
        ImageView image;

        if (p != null){
            image = new ImageView(p.classicImage);
        } else {
            King king = new King(3, 4, "Black");
            image = new ImageView(king.classicImage);
        }

        StackPane layout = new StackPane();

        if((i+j) % 2 == 0){
            layout.setStyle("-fx-background-color: white");
        } else {
            layout.setStyle("-fx-background-color: darkgray");
        }

        layout.getChildren().addAll(image);

        return layout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
