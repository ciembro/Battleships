package com.kodilla.battleships;

public abstract class Player {

    public abstract boolean shoot(Board board);
    protected boolean hasTurn;
    protected String name;
    protected int numOfMoves = 0;

    public boolean checkIfPlayerWon(Board board){
        if (board instanceof HumanBoard) {
            HumanBoard humanBoard = (HumanBoard) board;
            for (Ship ship : humanBoard.getShipList()){
                if (!ship.checkIfShipIsSunk()){
                    return false;
                }
            }
        } else {
            AiBoard aiBoard = (AiBoard) board;
            for (Ship ship : aiBoard.getShipList()){
                if (!ship.checkIfShipIsSunk()){
                    return false;
                }
            }
        }
        return true;
    }
    public void setHasTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfMoves(){
        return numOfMoves;
    }
}
