package com.kodilla.battleships;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class AiPlayer extends Player {

    Board humanBoard = new HumanBoard();


    @Override
    public void shoot() {  //set isShot, shipList
        Random random = new Random();
        int x, y;
        Coordinates shotCoordinates;

        //znalezc niezestrzelone miejsce
        do {
            x = random.nextInt(10);
            y = random.nextInt(10);
            shotCoordinates = new Coordinates(x, y);
        } while (!humanBoard.isShot.contains(shotCoordinates));

        //sprawdzic czy jest tam statek
        Ship ship = checkIfShipIsThere(shotCoordinates);
        Rectangle rectangle;
        if (ship == null){
            rectangle = new Rectangle(35,35, Color.BLUE);
        } else {
            rectangle = new Rectangle(35,35, Color.DARKGRAY);
        }
        humanBoard.addShotCoordinates(shotCoordinates);
        humanBoard.getGrid().add(rectangle, shotCoordinates.getX(), shotCoordinates.getY());

        //zaktualizowac stan statku

    }

        private Ship checkIfShipIsThere( Coordinates c){
            for (Ship ship : humanBoard.getShipList()){
                if (ship.getShipCoordinatesList().contains(c)){
                    return ship;
                }
            }
            return null;
    }

}
