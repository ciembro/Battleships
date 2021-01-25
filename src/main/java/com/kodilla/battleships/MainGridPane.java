package com.kodilla.battleships;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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

        Font font = new Font("Arial", 24);
        Label playerLabel = new Label("YOUR BOARD");
        Label aiLabel = new Label("ENEMY'S BOARD");

        playerLabel.setFont(font);
        aiLabel.setFont(font);

        playerLabel.setTextFill(Color.LIGHTBLUE);
        aiLabel.setTextFill(Color.LIGHTBLUE);

        mainGridPane.add(playerLabel, 0, 0);
        mainGridPane.add(aiLabel, 2, 0);

        instructionBox = new InstructionBox();
        mainGridPane.add(instructionBox.getTextBox(), 3, 1);
        mainGridPane.add(printAvailableShips(), 3,2);

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

        label.setPadding(new Insets(20,20,40,20));
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

    private VBox printAvailableShips(){
        Label label = new Label("AVAILABLE FLEET:");
        label.setTextFill(Color.LIGHTBLUE);
        label.setFont(new Font("Arial", 24));

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();
        HBox row4 = new HBox();
        row1.setSpacing(3);
        row2.setSpacing(5);
        row3.setSpacing(3);
        row4.setSpacing(5);
        vBox.getChildren().add(label);
        vBox.getChildren().addAll(row1, row2, row3, row4);
        row1.getChildren().add(new Rectangle(140,35, Color.BLACK));
        row2.getChildren().addAll(new Rectangle(105,35, Color.BLACK),
                new Rectangle(105,35, Color.BLACK));
        row3.getChildren().addAll(new Rectangle(70,35, Color.BLACK),
                new Rectangle(70,35, Color.BLACK),
                new Rectangle(70,35, Color.BLACK));
        row4.getChildren().addAll(new Rectangle(35,35, Color.BLACK),
                new Rectangle(35,35, Color.BLACK),
                new Rectangle(35,35, Color.BLACK),
                new Rectangle(35,35, Color.BLACK));

        return vBox;


    }


}
