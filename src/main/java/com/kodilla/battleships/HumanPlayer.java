package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;
import java.util.Map;

public class HumanPlayer extends Player {


    @Override
    public boolean shoot(Board board) {
        AiBoard aiBoard = (AiBoard) board;

        for (Map.Entry<Coordinates, Button> button : aiBoard.getMapOfButtons().entrySet()){

            button.getValue().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Ship ship = checkIfShipIsThere(aiBoard, button.getKey());
                    if (ship == null){
                        button.getValue().setStyle("-fx-background-color: #A9A9A9; " +
                                "-fx-border-color: #000000; -fx-border-width: 1px ");
                    } else {
                        button.getValue().setStyle("-fx-background-color: #FF0000; " +
                                "-fx-border-color: #000000; -fx-border-width: 1px ");
                        ship.updateShipState(button.getKey());
                    }
                    button.getValue().setDisable(true);
                }
            });
        }


        return false;
    }
    
    
    private Ship checkIfShipIsThere(Board board, Coordinates shotCoordinates){
        
        for (Ship ship : board.getShipList()){
            if (ship.getShipCoordinatesList().contains(shotCoordinates)){
                return ship;
            }
        }
        return null;
    }
}
