package com.kodilla.battleships;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainGridPane {
    private final GridPane mainGridPane;

    public MainGridPane(){
        Image mainImage = new Image("file:src\\main\\resources\\blue.jpg");
        mainGridPane = new GridPane();
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true,
                true, false);
        BackgroundImage backgroundImage = new BackgroundImage(mainImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        Background background = new Background(backgroundImage);
        mainGridPane.setBackground(background);

        mainGridPane.setPadding(new Insets(20,20,20,20));
        mainGridPane.setVgap(8);
        mainGridPane.setHgap(50);

        Font font = new Font("Arial", 16);
        Label playerLabel = new Label("YOUR BOARD");
        Label aiLabel = new Label("ENEMY'S BOARD");

        playerLabel.setFont(font);
        aiLabel.setFont(font);

        playerLabel.setTextFill(Color.LIGHTBLUE);
        aiLabel.setTextFill(Color.LIGHTBLUE);

        mainGridPane.add(playerLabel, 0, 0);
        mainGridPane.add(aiLabel, 0, 2);

        ButtonVBox buttonVBox = new ButtonVBox();
        mainGridPane.add(buttonVBox.getVBox(), 1,1);
    }

    public GridPane getGridPane() {
        return mainGridPane;
    }

    public static void showWinnerScreen(boolean humanWon, int moves){
        Stage winnerWindow = new Stage();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setStyle("-fx-background-color: #13acd6; " +
                "-fx-border-color: #000000;");
        Text text = new Text();
        text.setStyle("-fx-background-color: #13acd6; ");
        text.setFont(new Font("Arial", 14));


        if (humanWon){
            text.setText("Congratulations, you win in " + moves + " moves" );
        } else {
            text.setText("You lost ;< Enemy won in " + moves + " moves" );
        }
        grid.setAlignment(Pos.CENTER);
        grid.add(text,0,0);
        Scene scene = new Scene(grid, 300, 100);

        winnerWindow.setTitle("GAME OVER");
        winnerWindow.setScene(scene);
        winnerWindow.show();
    }

}
