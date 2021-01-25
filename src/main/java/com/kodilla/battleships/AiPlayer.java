package com.kodilla.battleships;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class AiPlayer extends Player {

//    public AiPlayer(){
//        this.hasTurn = false;
//    }

    @Override
    public boolean shoot(Board board) {
        Random random = new Random();
        int x, y;
        Coordinates shotCoordinates;

        //znalezc niezestrzelone miejsce
        do {
            x = random.nextInt(10);
            y = random.nextInt(10);
            shotCoordinates = new Coordinates(x, y);
        } while (board.isShot.contains(shotCoordinates));

        //sprawdzic czy jest tam statek
        Ship ship = checkIfShipIsThere(board, shotCoordinates);
        Rectangle rectangle;
        if (ship == null){
            rectangle = new Rectangle(35,35, Color.DARKGRAY);
        } else {
            rectangle = new Rectangle(35,35, Color.RED);
        }
        board.addShotCoordinates(shotCoordinates);
//        System.out.println(shotCoordinates);
        board.getGrid().add(rectangle, shotCoordinates.getX(), shotCoordinates.getY());

        //zaktualizowac stan statku
        if (ship != null){
            ship.updateShipState(shotCoordinates);
        }


       return ship == null;
    }

        private Ship checkIfShipIsThere(Board board, Coordinates c){
            for (Ship ship : board.getShipList()){
                if (ship.getShipCoordinatesList().contains(c)){
                    return ship;
                }
            }
            return null;
    }

}
