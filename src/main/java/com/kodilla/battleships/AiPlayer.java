package com.kodilla.battleships;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class AiPlayer extends Player {

    public AiPlayer(){
        this.name = "ai";
    }

    @Override
    public boolean shoot(Board board) {
        HumanBoard humanBoard = (HumanBoard) board;
        Ship ship;
        Coordinates shotCoordinates;
        do {
            numOfMoves++;
            shotCoordinates = findAvailableCoordinates(humanBoard);
            ship = checkIfShipIsThere(humanBoard, shotCoordinates);


            Rectangle rectangle;
            if (ship == null){
                rectangle = new Rectangle(35,35, Color.DARKGRAY);
            } else {
                rectangle = new Rectangle(35,35, Color.RED);
            }
            System.out.println(shotCoordinates);
            board.addShotCoordinates(shotCoordinates);
            board.getGrid().add(rectangle, shotCoordinates.getX(), shotCoordinates.getY());

            if (ship != null){
                ship.updateShipState(shotCoordinates);
            }

        } while (ship != null);
        System.out.println();

       return true;
    }

        private Ship checkIfShipIsThere(HumanBoard board, Coordinates c){
            for (Ship ship : board.getShipList()){
                if (ship.getShipCoordinatesList().contains(c)){
                    return ship;
                }
            }
            return null;
    }

    private Coordinates findAvailableCoordinates(HumanBoard board){
        Random random = new Random();
        int x,y;
        Coordinates shot;
        do {
            x = random.nextInt(10);
            y = random.nextInt(10);
            shot = new Coordinates(x, y);
        } while (board.isShot.contains(shot));

        return shot;
    }


}
