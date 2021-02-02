package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.Map;

public class HumanPlayer extends Player {

    AiPlayer aiPlayer;
    HumanBoard humanBoard;

    public HumanPlayer(AiPlayer aiPlayer, HumanBoard humanBoard){
        this.name = "human";
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
                                    if (aiPlayer.checkIfPlayerWon(humanBoard)) {
                                        MainGridPane.showWinnerScreen(false, aiPlayer.getNumOfMoves());
                                    }
                                    setHasTurn(true);

                                } else {
                                    markAsShot(button.getValue());
                                    ship.updateShipState(button.getKey());
                                    hasTurn = true;
                                }
                                button.getValue().setDisable(true);
                                if (checkIfPlayerWon(board)) {
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
        button.setStyle("-fx-background-color: #A9A9A9; " +
                "-fx-border-color: #000000; -fx-border-width: 1px; " +
                "-fx-opacity: 1");
    }

    private void markAsShot(Button button){
        button.setStyle("-fx-background-color: #FF0000; " +
                "-fx-border-color: #000000; -fx-border-width: 1px;" +
                "-fx-opacity: 1");
    }

    public HumanBoard getHumanBoard(){
        return humanBoard;
    }


}
