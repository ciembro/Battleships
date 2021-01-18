package com.kodilla.battleships;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShipsManager {
    List<Ship> shipList = new ArrayList<>();
    private Random random = new Random();

    public ShipsManager(){
        findShipPlace(4);
    }

    private void findShipPlace(int shipSize){
        int xStartIdx = findPlace(shipSize);
        int yStartIdx = findPlace(shipSize);
        Ship ship = new Ship(shipSize, xStartIdx, yStartIdx, isHorizontal());
        shipList.add(ship);
    }

    private boolean isHorizontal(){
        return random.nextBoolean();
    }

    private int findPlace(int shipSize){
        int startIdx = random.nextInt(10);
        while (startIdx > 10 - shipSize){
            startIdx = random.nextInt(10);
        }
        return startIdx;
    }

    public List<Ship> getShipList() {
        return shipList;
    }


    public static void main(String[] args) {

//        for (int i = 0; i < 2; i++) {
//            ShipsManager shipsManager = new ShipsManager();
//            Ship ship = shipsManager.getShipList().get(0);
//            System.out.println(ship.getShipSize());
//            System.out.println(ship.getxStartIdx());
//            System.out.println(ship.getyStartIdx());
//            System.out.println(ship.isHorizontal());
//            System.out.println("--------------------");
//
//        }
    }
}
