package com.kodilla.battleships;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
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
        winnerWindow.initModality(Modality.APPLICATION_MODAL);
        String textToShow;
        if (humanWon){
            textToShow = "Congratulations, you win in " + moves + " moves" ;
        } else {
            textToShow = "You lost ;< Enemy won in " + moves + " moves" ;
        }
        GridPane grid = createGridPane(textToShow);
        Scene scene = new Scene(grid, 300, 100);

        winnerWindow.setTitle("GAME OVER");
        winnerWindow.setScene(scene);
        winnerWindow.setAlwaysOnTop(true);
        winnerWindow.show();
    }

    public static void showSunkShipScreen(){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Button button = new Button("You sunk enemy's ship");
        button.setOnAction(e->stage.close());

        Scene scene = new Scene(button, 300,100);
        stage.setScene(scene);
        stage.show();
    }

    public static GridPane createGridPane(String textToShow){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setStyle("-fx-background-color: #13acd6; " +
                "-fx-border-color: #000000;");
        grid.setAlignment(Pos.CENTER);

        Text text = createTextToShow(textToShow);
        grid.add(text,0,0);
        return grid;
    }
    private static Text createTextToShow(String textToShow){
        Text text = new Text(textToShow);
        text.setStyle("-fx-background-color: #13acd6; ");
        text.setFont(new Font("Arial", 14));
        return text;
    }

}
