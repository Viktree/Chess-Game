package GUI;

import Pieces.Piece;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Created by vikram on 29/12/16.
 */
public class Board extends GridPane {

    public boolean toBeReset = false;
    public Piece currentPiece = null;

    private Piece[][] board;

    public Board(Piece[][] board){
        this.board = board;
        this.setPadding(new Insets(7));
        this.setHgap(8);
        this.setVgap(8);

        // Create Tiles
        for(int i  = 7; i>= 0; i--){
            for(int j = 0; j <=7; j++){
                StackPane tile = createTile(i, 7 - j);
                this.add(tile, i+1, j);
            }
        }

        // Create Labels
        int t = 1;
        for(Letter l: Letter.values()){
            this.add(new Label(l.toString()), t, 8);
            this.add(new Label(String.valueOf(9-t)), 0, t-1);
            t++;
        }

    }

    private StackPane createTile(int i, int j){
        StackPane tile = new StackPane();

        Piece piece = this.board[i][j];

        ImageView image = new ImageView();

        if (piece != null){
            image = new ImageView(piece.classicImage);
        }

        image.setFitHeight(70.0);
        image.setFitWidth(70.0);

        if((i+j) % 2 == 1){
            tile.setStyle("-fx-background-color: white");
        } else {
            tile.setStyle("-fx-background-color: darkgray");
        }

        image.setOnMouseClicked(this.pieceOnClick(tile, piece));
        tile.getChildren().addAll(image);
        tile.setOnMouseClicked(this.tileOnClick(tile, i, j));

        return tile;
    }

    private EventHandler<MouseEvent> tileOnClick(StackPane tile, int i, int j){
        return event -> {
            boolean samePanel = tile.getStyle().contains("-fx-background-color: red");

            if(pieceSelected() && !samePanel){
                tile.setStyle("-fx-background-color: greenyellow");
                currentPiece.moveTo(i, j);
                toBeReset = true;
            }
        };
    }

    private EventHandler<MouseEvent> pieceOnClick(StackPane tile, Piece p){
        return new EventHandler<MouseEvent>() {

            String initalStyle = tile.getStyle();

            @Override
            public void handle(MouseEvent event) {
                if (tile.getStyle() == initalStyle){
                    tile.setStyle("-fx-background-color: red");
                    currentPiece = p;
                } else {
                    tile.setStyle(initalStyle);
                }
            }
        };
    }

    private boolean pieceSelected(){
        return currentPiece == null;
    }

}
