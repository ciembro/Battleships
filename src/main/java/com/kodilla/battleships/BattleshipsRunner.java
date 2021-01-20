package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class BattleshipsRunner extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        startGame(primaryStage);
    }


    private Button createStartNewGameButton() {
        Button startNewGameButton = new Button("Start a new game");
        startNewGameButton.setFont(new Font("Arial", 24));
        Image startNewGameImage = new Image("file:src\\main\\resources\\ship.png");

        startNewGameButton.setGraphic(new ImageView(startNewGameImage));
        startNewGameButton.setMinSize(300, 100);
        startNewGameButton.setMaxSize(300, 100);

        return startNewGameButton;
    }


    private GridPane askToStartNewGame(Stage primaryStage, Stage stage) {
        GridPane windowGrid = new GridPane();

        windowGrid.setStyle("-fx-background-color: #a4b5b7; -fx-border-color: #000000;");
        Label label = new Label("Do you want to start a new game?");
        label.setFont(new Font("Arial", 14));

        HBox hBox = new HBox();
        Button yesButton = new Button("Yes");
        yesButton.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000; -fx-border-width: 1px ");
        yesButton.setMinSize(45, 30);
        yesButton.setMaxSize(45, 30);
        yesButton.setOnMouseClicked(e -> {restart(primaryStage); stage.close();});


        Button noButton = new Button(("No"));
        noButton.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000; -fx-border-width: 1px ");
        noButton.setMinSize(45, 30);
        noButton.setMaxSize(45, 30);
        noButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.close();
            }
        });

        hBox.getChildren().add(yesButton);
        hBox.getChildren().add(noButton);

        windowGrid.add(label, 0, 0);
        windowGrid.add(hBox, 0, 1);
        return windowGrid;
    }

    void cleanup() {
        // stop animations reset model ect.

    }

    void startGame(Stage primaryStage) {
        // initialisation from start method goes here
        Game game = new Game();
        Scene scene = new Scene(game.getMainGrid(), 1200, 800);

        Button startNewGameButton = createStartNewGameButton();
        game.getMainGrid().add(startNewGameButton, 0, 3);
        startNewGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage newWindow = new Stage();
                Scene scene = new Scene(askToStartNewGame(primaryStage, newWindow), 300, 100);
                newWindow.setScene(scene);
                newWindow.show();
            }
        });
        primaryStage.setTitle("Battleships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void restart(Stage stage) {
        cleanup();
        System.out.println("restart");
        startGame(stage);
    }

}





