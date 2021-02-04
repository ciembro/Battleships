package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.Map;

public class HumanPlayer extends Player {

    AiPlayer aiPlayer;
    HumanBoard humanBoard;

    public HumanPlayer(AiPlayer aiPlayer, HumanBoard humanBoard){
        this.name = "player";
        this.aiPlayer = aiPlayer;
        this.humanBoard = humanBoard;
        this.hasTurn = true;
    }

    @Override
    public boolean shoot(Board board) {
        AiBoard aiBoard = (AiBoard) board;
            for (Map.Entry<Coordinates, Button> button : aiBoard.getMapOfButtons().entrySet()) {
                button.getValue().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (humanBoard.getShipList().size() == Game.getShipSizes().size()) {
                            numOfMoves++;
                            if (hasTurn) {
                                Ship ship = checkIfShipIsThere(aiBoard, button.getKey());
                                if (ship == null) {
                                    markAsEmpty(button.getValue());
                                    hasTurn = false;

                                    aiPlayer.shoot(humanBoard);
                                    if (aiPlayer.checkIfGameFinished(humanBoard)) {
                                        MainGridPane.showWinnerScreen(false, aiPlayer.getNumOfMoves());
                                        disableAllButtons(aiBoard);
                                    }
                                    setHasTurn(true);

                                } else {
                                    markAsShot(button.getValue());
                                    ship.updateShipState(button.getKey());
                                    if (ship.checkIfShipIsSunk()){
                                        MainGridPane.showSunkShipScreen();
                                        markShipSurroundings(ship, aiBoard);
                                    }
                                    hasTurn = true;
                                }
                                button.getValue().setDisable(true);
                                if (checkIfGameFinished(board)) {
                                    disableAllButtons(aiBoard);
                                    MainGridPane.showWinnerScreen(true, numOfMoves);
                                }
                            }

                        }
                    }
                });
        }
        return false;
    }

    public void setName(String name){
        this.name = name;
    }

    private Ship checkIfShipIsThere(AiBoard board, Coordinates shotCoordinates){
        
        for (Ship ship : board.getShipList()){
            if (ship.getShipCoordinatesList().contains(shotCoordinates)){
                return ship;
            }
        }
        return null;
    }

    private void markAsEmpty(Button button){
        button.setMaxSize(35,35);
        button.setMinSize(35,35);
        button.setStyle("-fx-background-color: #A9A9A9; " +
                "-fx-border-color: #000000; -fx-border-width: 1px; " +
                "-fx-opacity: 1");
    }

    private void markAsShot(Button button){
        button.setStyle("-fx-background-color: #FF0000; " +
                "-fx-border-color: #000000; -fx-border-width: 1px;" +
                "-fx-opacity: 1");
    }

    private void markShipSurroundings(Ship ship, AiBoard aiBoard){
        int xInit = ship.getInitCoordinates().getX();
        int yInit = ship.getInitCoordinates().getY();
        if (ship.isHorizontal()) {
            for (int x = xInit - 1; x <= xInit + ship.getSize(); x++){
                for (int y = yInit - 1 ; y <= yInit + 1; y++){
                    if (x >= 0 && x <= 9 && y >= 0 && y <= 9 && !ship.getShipCoordinatesList().contains(new Coordinates(x,y))){
                        Button button = new Button();
                        markAsEmpty(button);
                        aiBoard.getMapOfButtons().replace(new Coordinates(x,y), button);
                        aiBoard.getGrid().add(button, x, y);

                    }
                }
            }
        } else {
            for (int x = xInit - 1; x <= xInit + 1; x++){
                for (int y = yInit - 1; y <= yInit + ship.getSize(); y++){
                    if (x >= 0 && x <= 9 && y >= 0 && y <= 9 && !ship.getShipCoordinatesList().contains(new Coordinates(x,y))){
                        Button button = new Button();
                        markAsEmpty(button);
                        aiBoard.getMapOfButtons().replace(new Coordinates(x,y), button);
                        aiBoard.getGrid().add(button, x, y);
                    }
                }
            }
        }
    }

    public HumanBoard getHumanBoard(){
        return humanBoard;
    }

    private void disableAllButtons(Board board) {
        AiBoard aiBoard = (AiBoard) board;
        for (Map.Entry<Coordinates, Button> button : aiBoard.getMapOfButtons().entrySet()) {
            button.getValue().setDisable(true);
        }
    }


}
