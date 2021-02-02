package com.kodilla.battleships;

import java.util.ArrayList;
import java.util.List;

public class HumanBoard extends Board{

    private List<Ship> shipList = new ArrayList<>();

    public HumanBoard(){
        super();
        grid.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000;");
        grid.setGridLinesVisible(true);
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList){
        this.shipList = shipList;
    }
}

