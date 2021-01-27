package com.kodilla.battleships;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class HumanBoard extends Board{

    public HumanBoard(){
        super();
        super.putShipsOnBoard();
        grid.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000;");
        grid.setGridLinesVisible(true);

        for (Ship ship : shipList){
            for (Coordinates c : ship.getShipCoordinatesList()){
                Rectangle rectangle = new Rectangle(35,35, Color.BLACK);
                grid.add(rectangle, c.getX(), c.getY());
            }
        }
    }

}

