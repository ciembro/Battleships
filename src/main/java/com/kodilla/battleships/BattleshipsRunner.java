package com.kodilla.battleships;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class BattleshipsRunner extends Application {
    Image mainImage = new Image("file:src\\main\\resources\\blue.jpg");
    PlayerBoard playerBoard = new PlayerBoard();
    EnemyBoard enemyBoard = new EnemyBoard();
    GridPane mainGridPane = new GridPane();
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(mainImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        Background background = new Background(backgroundImage);

        mainGridPane.setBackground(background);

        mainGridPane.add(playerBoard.setLabel("Your board"), 0, 0);
        mainGridPane.add(playerBoard.getGrid(), 0, 1);

        mainGridPane.add(enemyBoard.setLabel("Enemy's board"), 2, 0);
        mainGridPane.add(enemyBoard.getGrid(), 2, 1);

        mainGridPane.setPadding(new Insets(15, 20, 15, 20));
        mainGridPane.setHgap(10);
        mainGridPane.setVgap(10);

        InstructionBox instructionBox = new InstructionBox();
        mainGridPane.add(instructionBox.getTextBox(), 3, 1);


        mainGridPane.add(createStartNewGameButton(),0,3);

        Scene scene = new Scene(mainGridPane, 1200, 800);

        primaryStage.setTitle("Battleships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private Button createStartNewGameButton(){
        Button startNewGameButton = new Button("Start new game");
        startNewGameButton.setFont(new Font("Arial", 24));
        Image startNewGameImage = new Image("file:src\\main\\resources\\ship.png");

        startNewGameButton.setGraphic(new ImageView(startNewGameImage));
        startNewGameButton.setMinSize(275, 100);
        startNewGameButton.setMaxSize(275, 100);
        startNewGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage newWindow = new Stage();
                Scene scene = new Scene(askToStartNewGame(newWindow), 300, 100);

                newWindow.setScene(scene);
                newWindow.show();
            }
        });
        return startNewGameButton;
    }



    private GridPane askToStartNewGame(Stage stage){
        GridPane windowGrid = new GridPane();
        windowGrid.setStyle("-fx-background-color: #a4b5b7; -fx-border-color: #000000;");
        Label label = new Label("Do you want to start a new game?");
        label.setFont(new Font("Arial", 14));


        HBox hBox = new HBox();
        Button yesButton = new Button("Yes");
        yesButton.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000; -fx-border-width: 1px ");
        yesButton.setMinSize(45, 30);
        yesButton.setMaxSize(45, 30);
        yesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                setPlayerBoard(new PlayerBoard());
                setEnemyBoard(new EnemyBoard());
                mainGridPane.add(playerBoard.setLabel("Your board"), 0, 0);
                mainGridPane.add(playerBoard.getGrid(), 0, 1);

                mainGridPane.add(enemyBoard.setLabel("Enemy's board"), 2, 0);
                mainGridPane.add(enemyBoard.getGrid(), 2, 1);
                stage.close();
            }
        });

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

    public void setPlayerBoard(PlayerBoard playerBoard) {
        this.playerBoard = playerBoard;
    }

    public void setEnemyBoard(EnemyBoard enemyBoard) {
        this.enemyBoard = enemyBoard;
    }

    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }

    public EnemyBoard getEnemyBoard() {
        return enemyBoard;
    }
}


