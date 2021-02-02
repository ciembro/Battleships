package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewGameButton extends GameButton{

    public NewGameButton(){
        Image startNewGameImage = new Image("file:src\\main\\resources\\ship.png");
        button = new Button("Start a new game");
        setSize();
        setStyle(startNewGameImage);
        handleClick();
    }

    @Override
    public void handleClick() {
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage newWindow = new Stage();
                Scene scene = new Scene(askToStartNewGame(BattleshipsRunner.getPrimaryStage(), newWindow),
                        300, 100);
                newWindow.setScene(scene);
                newWindow.show();
            }
        });
    }

    public GridPane askToStartNewGame(Stage primaryStage, Stage newWindow) {
        GridPane windowGrid = new GridPane();

        windowGrid.setStyle("-fx-background-color: #a4b5b7; -fx-border-color: #000000;");
        Label label = new Label("Do you want to start a new game?");
        label.setFont(new Font("Arial", 16));
        windowGrid.setPadding(new Insets(20,20,20,20));
        windowGrid.setHgap(10);
        windowGrid.setVgap(10);
        windowGrid.setAlignment(Pos.CENTER);


        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        Button yesButton = createYesButton();
        yesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BattleshipsRunner.restart(primaryStage);
                newWindow.close();
            }
        });

        Button noButton = createNoButton();
        noButton.setOnMouseClicked(e -> newWindow.close());

        hBox.getChildren().add(yesButton);
        hBox.getChildren().add(noButton);

        windowGrid.add(label, 0, 0);
        windowGrid.add(hBox, 0, 1);
        return windowGrid;
    }

    public Button getButton() {
        return button;
    }

    private static Button createYesButton(){
        Button yesButton = new Button("Yes");
        yesButton.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000; -fx-border-width: 1px ");
        yesButton.setMinSize(60, 30);
        yesButton.setMaxSize(60, 30);

        return yesButton;
    }

    private static Button createNoButton(){
        Button noButton = new Button(("No"));
        noButton.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000; -fx-border-width: 1px ");
        noButton.setMinSize(60, 30);
        noButton.setMaxSize(60, 30);

        return noButton;
    }
}
