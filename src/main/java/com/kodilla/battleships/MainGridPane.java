package com.kodilla.battleships;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainGridPane {
    private final Image mainImage = new Image("file:src\\main\\resources\\blue.jpg");
    private final GridPane mainGridPane;
    InstructionBox instructionBox;

    public MainGridPane(){
        mainGridPane = new GridPane();
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(mainImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        Background background = new Background(backgroundImage);
        mainGridPane.setBackground(background);

        mainGridPane.setPadding(new Insets(20,20,20,20));
        mainGridPane.setVgap(10);
        mainGridPane.setHgap(10);

        instructionBox = new InstructionBox();
        mainGridPane.add(instructionBox.getTextBox(), 3, 1);

    }

    public GridPane getGridPane() {
        return mainGridPane;
    }

    public static void showWinnerScreen(boolean humanWon){
        Stage winnerWindow = new Stage();
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: #13acd6; " +
                "-fx-border-color: #000000;");
        Label label = new Label();
        label.setTextFill(Color.BLACK);

        label.setPadding(new Insets(20,20,20,20));
        if (humanWon){
            label.setFont(new Font("Arial", 14));
            label.setText("GAME OVER\nCongratulations, you win!!!");
        } else {
            label.setFont(new Font("Arial", 24));
            label.setText("GAME OVER\nYou lost ;<");
        }
        grid.add(label,0,0);
        Scene scene = new Scene(grid, 300, 100);

        winnerWindow.setScene(scene);
        winnerWindow.show();

    }


}
