package GUI;

import ChessMain.BoardManager;
import Pieces.Piece;

import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vikram on 26/12/16.
 */
public class Board extends GridPane implements Observer {

    private boolean clickable = false;

    public Board(){
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

        Piece p = BoardManager.Square[i][j];

        ImageView image = new ImageView();

        if (p != null){
            image = new ImageView(p.classicImage);
        }

        image.setFitHeight(70.0);
        image.setFitWidth(70.0);

        if((i+j) % 2 == 1){
            tile.setStyle("-fx-background-color: white");
        } else {
            tile.setStyle("-fx-background-color: darkgray");
        }

        image.setOnMouseClicked(new EventHandler<MouseEvent>() {

            String initalStyle = tile.getStyle();

            @Override
            public void handle(MouseEvent event) {

                if (tile.getStyle() == initalStyle){
                    tile.setStyle("-fx-background-color: red");
                    //clickable = true;

                    System.out.println(p.symbol);
                    for(int i  = 7; i>= 0; i--){
                        for(int j = 0; j <=7; j++){
                            if (p.isVaildMove(i,j)){
                                System.out.println(i + ", " + j);
                            }
                        }
                    }
                } else {
                    tile.setStyle(initalStyle);
                }

            }
        });

        tile.getChildren().addAll(image);

        tile.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                boolean samePanel = tile.getStyle().contains("-fx-background-color: red");

                if(clickable && !samePanel){
                    tile.setStyle("-fx-background-color: greenyellow");
                    clickable = false;
                }
            }
        });

        return tile;
    }


    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("hello!");
    }
}
