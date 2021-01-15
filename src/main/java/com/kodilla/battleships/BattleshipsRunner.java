package com.kodilla.battleships;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

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

//        ColumnConstraints[] columnConstraints = createColumns(4);
//        mainGridPane.getColumnConstraints().addAll(columnConstraints);
//
//        RowConstraints[] rowConstraints = createRows(4);
//        mainGridPane.getRowConstraints().addAll(rowConstraints);

        BackgroundFill boardFill = new BackgroundFill(Color.LIGHTGRAY, null, null);
        Background boardBackground = new Background(boardFill);

        GridPane playerBoard = new GridPane();
        playerBoard.setBackground(boardBackground);
        playerBoard.setGridLinesVisible(true);
        playerBoard.setAlignment(Pos.CENTER);

        ColumnConstraints[] columnConstraints= createColumns(10);
        playerBoard.getColumnConstraints().addAll(columnConstraints);

        RowConstraints[] rowConstraints = createRows(10);
        playerBoard.getRowConstraints().addAll(rowConstraints);

        Font basicFont = new Font("Arial", 24);

        Label pLabel = new Label("Your board");
        pLabel.setTextFill(Color.LIGHTBLUE);
        pLabel.setFont(basicFont);
        pLabel.setAlignment(Pos.CENTER);

        mainGridPane.add(pLabel, 0, 0);
        mainGridPane.add(playerBoard, 0, 1);

        GridPane enemyBoard = new GridPane();
        enemyBoard.setBackground(boardBackground);
        enemyBoard.setGridLinesVisible(true);
        enemyBoard.setAlignment(Pos.CENTER);
        enemyBoard.getColumnConstraints().addAll(columnConstraints);
        enemyBoard.getRowConstraints().addAll(rowConstraints);

        Label eLabel = new Label();
        eLabel.setText("Enemy board");
        eLabel.setTextFill(Color.LIGHTBLUE);
        eLabel.setFont(basicFont);
        eLabel.setAlignment(Pos.CENTER);

        mainGridPane.add(eLabel,2 , 0);
        mainGridPane.add(enemyBoard,2,1);

        mainGridPane.setPadding(new Insets(15,20,15,20));;
        mainGridPane.setHgap(10);
        mainGridPane.setVgap(10);

        VBox textBox = new VBox();
        textBox.setSpacing(15);

        Label rulesLabel = new Label("Rules");
        rulesLabel.setTextFill(Color.LIGHTBLUE);
        rulesLabel.setFont(basicFont);
        rulesLabel.setAlignment(Pos.CENTER);
        textBox.getChildren().add(rulesLabel);
        mainGridPane.add(textBox, 3,1);

        Text rulesText = new Text();
        rulesText.setFont(basicFont);
        rulesText.setFill(Color.LIGHTBLUE);
        rulesText.setTextAlignment(TextAlignment.JUSTIFY);
        rulesText.setText(" This is basic rule\n This is basic rule\n This is basic rule\n This is basic rule\n This is basic rule\n");

        textBox.getChildren().add(rulesText);

        Button startNewGameButton = new Button("Start new game");
        startNewGameButton.setFont(basicFont);
        Image startNewGameImage = new Image("file:src\\main\\resources\\ship.png");

        startNewGameButton.setGraphic(new ImageView(startNewGameImage));
        startNewGameButton.setMinSize(275,100);
        startNewGameButton.setMaxSize(275,100);
        textBox.getChildren().add(startNewGameButton);

        Scene scene = new Scene(mainGridPane, 1200, 800);

        primaryStage.setTitle("Battleships");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    static ColumnConstraints[] createColumns(int numOfColumns) {
        ColumnConstraints[] columnConstraints = new ColumnConstraints[numOfColumns];
        double columnPercentWidth = 100.0 / numOfColumns;
        for (int i = 0; i < numOfColumns; i++) {
            columnConstraints[i] = new ColumnConstraints(35,35,35);
//            columnConstraints[i].setPercentWidth(columnPercentWidth);
        }
        return columnConstraints;
    }

    static RowConstraints[] createRows(int numOfRows) {
        RowConstraints[] rowConstraints = new RowConstraints[numOfRows];
        double rowPercentHeight = 100.0 / numOfRows;
        for (int i = 0; i < numOfRows; i++) {
            rowConstraints[i] = new RowConstraints(35,35,35);
//            rowConstraints[i].setPercentHeight(rowPercentHeight);
        }
        return rowConstraints;
    }
}
