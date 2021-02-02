package com.kodilla.battleships;

import java.util.*;

public class ShipLocator {
    private Set<Coordinates> setOfTakenPositions;
    private final List<Ship> shipList;

    public ShipLocator(){
        this.shipList = placeShipsOnBoard();
    }

    private List<Ship> placeShipsOnBoard(){
        setOfTakenPositions = new HashSet<>();
        List<Ship> ships = new ArrayList<>();
        for (Integer size : Game.getShipSizes()) {
            Ship ship = new Ship(size);
            do {
                do {
                    ship.placeShip();
                } while (!checkIfPositionAvailable(ship.getShipCoordinatesList()));
                ships.add(ship);
                updateAvailability(ship);
            } while (ships.size() <= Game.getShipSizes().size() && setOfTakenPositions.size() > 85);
        }
        return ships;
    }

    private void updateAvailability(Ship ship){
        int xInit, yInit;
        int shipSize = ship.getSize();
        xInit = ship.getInitCoordinates().getX();
        yInit = ship.getInitCoordinates().getY();

        if (ship.isHorizontal()) {
            for (int x = xInit - 1; x <= xInit + shipSize; x++){
                for (int y = yInit - 1 ; y <= yInit + 1; y++){
                    if (x >= 0 && x <= 9 && y >= 0 && y <= 9){
                        updateSetOfTakenPositions(x,y);

                    }
                }
            }
        } else {
            for (int x = xInit - 1; x <= xInit + 1; x++){
                for (int y = yInit - 1; y <= yInit + shipSize; y++){
                    if (x >= 0 && x <= 9 && y >= 0 && y <= 9){
                        updateSetOfTakenPositions(x,y);

                    }
                }
            }
        }

    }

    private void updateSetOfTakenPositions(int x, int y){

        setOfTakenPositions.add(new Coordinates(x,y));
    }

    private boolean checkIfPositionAvailable(List<Coordinates> coordinatesList){
        for (Coordinates c : coordinatesList){
            if (setOfTakenPositions.contains(c)){
                return false;
            }
        }
        return true;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

}
