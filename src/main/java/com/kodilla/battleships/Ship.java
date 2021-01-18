package com.kodilla.battleships;

import java.util.HashMap;

public class Ship {
    private final int shipSize;
    private final int xStartIdx;
    private final int yStartIdx;
    private boolean isAvailable;
    private final boolean isHorizontal;
    private HashMap<Integer, Boolean> isShot = new HashMap<>();

    public Ship(int shipSize, int xStartIdx, int yStartPosition, boolean isHorizontal) {
        this.shipSize = shipSize;
        this.xStartIdx = xStartIdx;
        this.yStartIdx = yStartPosition;
        this.isHorizontal = isHorizontal;
        this.isAvailable = true;
//        for (int i = startIdx; i < startIdx + shipSize; i++) {
//            isShot.put(i, false);
//        }
    }

    public int getShipSize() {
        return shipSize;
    }

    public int getxStartIdx() {
        return xStartIdx;
    }

    public int getyStartIdx() {
        return yStartIdx;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public HashMap<Integer, Boolean> getIsShot() {
        return isShot;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Ship ship = (Ship) o;
//
//        if (getShipSize() != ship.getShipSize()) return false;
//        if (getStartIdx() != ship.getStartIdx()) return false;
//        if (isAvailable() != ship.isAvailable()) return false;
//        if (isHorizontal() != ship.isHorizontal()) return false;
//        return getIsShot().equals(ship.getIsShot());
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getShipSize();
//        result = 31 * result + getStartIdx();
//        result = 31 * result + (isAvailable() ? 1 : 0);
//        result = 31 * result + (isHorizontal() ? 1 : 0);
//        result = 31 * result + getIsShot().hashCode();
//        return result;
//    }
}
