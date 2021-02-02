package com.kodilla.battleships;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

public class Game {

    private MainGridPane mainGrid;
    private final HumanPlayer humanPlayer;
    private final HumanBoard humanBoard;
    private final AiPlayer aiPlayer;
    private final AiBoard aiBoard;
    private final HumanShipLocatorWindow humanShipLocatorWindow;
    private final static List<Integer> shipSizes = new ArrayList<>(Arrays.asList(4,3,3,2,2,2,1,1,1,1));

    public Game(){

        aiPlayer = new AiPlayer();
        aiBoard = new AiBoard();
        humanBoard = new HumanBoard();
        humanPlayer = new HumanPlayer(aiPlayer, humanBoard);
        humanShipLocatorWindow = new HumanShipLocatorWindow(humanPlayer);

        setMainGridPane();
        play();
    }

    private void setMainGridPane(){
        mainGrid = new MainGridPane();
        mainGrid.getGridPane().add(humanBoard.getGrid(), 0, 1);
        mainGrid.getGridPane().add(aiBoard.getGrid(), 0, 3);
    }

    public void play(){
        humanPlayer.shoot(aiBoard);
    }

    public GridPane getMainGrid() {

        return mainGrid.getGridPane();
    }

    public static List<Integer> getShipSizes() {
        return shipSizes;
    }

    public static void printErrorWindow(){
        Stage errorWindow = new Stage();
        GridPane gridPane = new GridPane();
        Label label = new Label("Please place all ships on borad");
        label.setFont(new Font("Arial", 14));
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(label,0,0);
        gridPane.setStyle("-fx-background-color: #a4b5b7; -fx-border-color: #000000;");
        Scene scene = new Scene(gridPane, 300,100);
        errorWindow.setTitle("Error");
        errorWindow.setScene(scene);
        errorWindow.show();
    }

    public void openNewGameWindow(){
        humanShipLocatorWindow.openWindow();
    }
}
