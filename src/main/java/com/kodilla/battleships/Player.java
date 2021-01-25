package com.kodilla.battleships;

public abstract class Player {

    public abstract boolean shoot(Board board);
    protected boolean hasTurn;

    public boolean checkIfPlayerWon(Board board){
        for (Ship ship : board.getShipList()){
            if (!ship.checkIfShipIsSunk()){
                return false;
            }
        }
        return true;
    }

    public boolean getHasTurn() {
        return hasTurn;
    }

    public void setHasTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }
}
