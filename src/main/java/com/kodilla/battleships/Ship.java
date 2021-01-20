package com.kodilla.battleships;

import java.util.*;

public class Ship {
    private final int size;
    private final boolean isHorizontal;
    private Coordinates initCoordinates;
    private Map<Coordinates, Boolean> shipState = new HashMap<>();
    private Random random = new Random();

    public Ship(int size){
        this.size = size;
        isHorizontal = random.nextBoolean();
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
        shipState.clear();
        initCoordinates = findShipCoordinates();
        int xInit = initCoordinates.getX();
        int yInit = initCoordinates.getY();
        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                shipState.put(new Coordinates(xInit + i, yInit), true);
            } else {
                shipState.put(new Coordinates(xInit, yInit + i), true);
            }
        }


    }

    private void printShipState(){
        for (Map.Entry<Coordinates, Boolean> entry : shipState.entrySet()){
            System.out.print(entry.getKey());
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }


    public List<Coordinates> getShipCoordinatesList(){

        return new ArrayList<>(shipState.keySet());
    }

    public Coordinates getInitCoordinates() {
        return initCoordinates;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10 ; i++) {
            Ship ship = new Ship(1);
            ship.placeShip();
            ship.printShipState();
            ship.placeShip();
            ship.printShipState();
            System.out.println();
        }
    }
}
