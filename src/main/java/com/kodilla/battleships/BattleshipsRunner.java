package com.kodilla.battleships;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;


import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BattleshipsRunner extends Application {
    Image mainImage = new Image("file:src\\main\\resources\\blue.jpg");

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
        GridPane mainGridPane = new GridPane();
        mainGridPane.setBackground(background);

        Font basicFont = new Font("Arial", 24);

        PlayerBoard playerBoard = new PlayerBoard();
        mainGridPane.add(playerBoard.setLabel("Your board"), 0, 0);
        mainGridPane.add(playerBoard.getGrid(), 0, 1);

        EnemyBoard enemyBoard = new EnemyBoard();
        mainGridPane.add(enemyBoard.setLabel("Enemy's board"), 2, 0);
        mainGridPane.add(enemyBoard.getGrid(), 2, 1);

        mainGridPane.setPadding(new Insets(15, 20, 15, 20));
        mainGridPane.setHgap(10);
        mainGridPane.setVgap(10);

        InstructionBox instructionBox = new InstructionBox();
        mainGridPane.add(instructionBox.getTextBox(), 3, 1);


        Scene scene = new Scene(mainGridPane, 1200, 800);

        primaryStage.setTitle("Battleships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


