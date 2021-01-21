package com.kodilla.battleships;

public abstract class Player {

    public abstract boolean shoot(Board board);

    public boolean checkIfPlayerWon(Board board){
        for (Ship ship : board.getShipList()){
            if (!ship.checkIfShipIsSunk()){
                return false;
            }
        }
        return true;
    }

}
