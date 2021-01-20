package com.kodilla.battleships;

import java.util.*;

public class ShipLocator {
    private Set<Coordinates> setOfTakenPositions;
    private List<Ship> shipList;

    public void placeShipsOnBoard() {
        placeShips();
        boolean isOk;
        do {
            isOk = placeShips();
        }while (!isOk);
    }

    private boolean placeShips(){
        setOfTakenPositions = new HashSet<>();
        shipList = new ArrayList<>();
        List<Integer> shipSizes = new ArrayList<>();
        shipSizes.add(4);
        shipSizes.add(3);
        shipSizes.add(3);
        shipSizes.add(2);
        shipSizes.add(2);
        shipSizes.add(2);
        shipSizes.add(1);
        shipSizes.add(1);
        for (Integer size : shipSizes) {
            Ship ship = new Ship(size);
            do {
                ship.placeShip();
            } while (!checkIfPositionAvailable(ship.getShipCoordinatesList()));
            shipList.add(ship);
            updateAvailability(ship);
            if (shipList.size() <= shipSizes.size() && setOfTakenPositions.size() > 85){
                return false;
            }
        }
        return true;
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

    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++){
//            ShipLocator shipLocator = new ShipLocator();
//            shipLocator.placeShipsOnBoard();
//            for (Ship ship : shipLocator.getShipList()){
//                for (Coordinates c : ship.getShipCoordinatesList()){
//                    System.out.print(c);
//                }
//                System.out.println();
//            }
//            System.out.println("-----------");
//        }

    }
}
