package com.kodilla.battleships;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanShipLocator {
    private Set<Coordinates> setOfTakenPositions = new HashSet<>();
    private List<Ship> shipList;
    private final HumanBoard humanBoard;

    public HumanShipLocator(HumanBoard humanBoard){
        shipList = new ArrayList<>();
        this.humanBoard = humanBoard;
    }

    public boolean placeShip(Ship ship){
        ship.placeHumanShip();
        boolean isAvailablePos = checkIfPositionAvailable(ship.getShipCoordinatesList());
        if (isAvailablePos){
            updateAvailability(ship);
            shipList.add(ship);
            drawShipOnBoard(ship);
            return true;
        }
        return false;
    }

    private void drawShipOnBoard(Ship ship){
        Rectangle rectangle;
        for (Coordinates coordinates : ship.getShipCoordinatesList()){
            rectangle = new Rectangle(35,35, Color.BLACK);
            humanBoard.getGrid().add(rectangle, coordinates.getX(), coordinates.getY());
        }
    }

    public boolean deleteShip(Ship ship){
        if (shipList.remove(ship)){
            removeShipFromBoard(ship);
            setOfTakenPositions = new HashSet<>();
            for (Ship currentShip : shipList){
                updateAvailability(currentShip);
            }
            return true;
        }
        return false;
    }

    private void removeShipFromBoard(Ship ship){
            for (Coordinates coordinates: ship.getShipCoordinatesList()){
                humanBoard.getGrid().add(getNewRectangle(), coordinates.getX(), coordinates.getY());
        }
    }

    private Rectangle getNewRectangle(){
        Color color = Color.color(0.07451,0.67451,0.83922);
        Rectangle rectangle = new Rectangle(35,35, color);
        rectangle.setStyle("-fx-border-color: #000000; -fx-border-width: 1px;-fx-opacity: 1");

        return rectangle;
    }

    public void deleteAllShips(){
        shipList = new ArrayList<>();
        setOfTakenPositions = new HashSet<>();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                humanBoard.getGrid().add(getNewRectangle(), x, y);
            }
        }
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

    public void placeShipsRandomly(){
        ShipLocator shipLocator = new ShipLocator();
        shipList = shipLocator.getShipList();
        for (Ship ship : shipList){
            drawShipOnBoard(ship);
        }
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public HumanBoard getHumanBoard() {
        return humanBoard;
    }
}
