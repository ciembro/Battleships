package com.kodilla.battleships;

import java.util.*;

public class Ship {
    private final int size;
    private final boolean isHorizontal;
    private Coordinates initCoordinates;
    private Map<Coordinates, Boolean> mapOfShotCoordinates = new HashMap<>();
    private Random random = new Random();

    public Ship(int size){
        this.size = size;
        isHorizontal = random.nextBoolean();
    }

    public Ship(int size, Coordinates initCoordinates, boolean isHorizontal){
        this.size = size;
        this.initCoordinates = initCoordinates;
        this.isHorizontal = isHorizontal;
    }

    private Coordinates findShipCoordinates(){
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        if (isHorizontal){
            while (x > 10 - size){
                x = random.nextInt(10);
            }
        } else {
            while (y > 10 - size){
                y = random.nextInt(10);
            }
        }
        return new Coordinates(x,y);
    }

    public void placeShip() {
        mapOfShotCoordinates.clear();
        initCoordinates = findShipCoordinates();
        int xInit = initCoordinates.getX();
        int yInit = initCoordinates.getY();
        createMapOfShotCoordinates(isHorizontal, xInit, yInit);
    }

    public void placeHumanShip(){
        mapOfShotCoordinates.clear();
        int xInit = initCoordinates.getX();
        int yInit = initCoordinates.getY();
        createMapOfShotCoordinates(isHorizontal, xInit, yInit);
    }

    private void createMapOfShotCoordinates(boolean isHorizontal, int xInit, int yInit){
        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                mapOfShotCoordinates.put(new Coordinates(xInit + i, yInit), false);
            } else {
                mapOfShotCoordinates.put(new Coordinates(xInit, yInit + i), false);
            }
        }
    }

    public void updateShipState(Coordinates shotCoordinates){
        mapOfShotCoordinates.replace(shotCoordinates, true);   // = this place is shot
    }

    public boolean checkIfShipIsSunk(){
        return !mapOfShotCoordinates.containsValue(false);
    }

    public int getSize() {
        return size;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public List<Coordinates> getShipCoordinatesList(){
        return new ArrayList<>(mapOfShotCoordinates.keySet());
    }

    public Coordinates getInitCoordinates() {
        return initCoordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (getSize() != ship.getSize()) return false;
        if (isHorizontal() != ship.isHorizontal()) return false;
        if (!getInitCoordinates().equals(ship.getInitCoordinates())) return false;
        return mapOfShotCoordinates.equals(ship.mapOfShotCoordinates);
    }

}
