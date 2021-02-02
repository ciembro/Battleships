package com.kodilla.battleships;

import javafx.scene.control.Button;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AiBoard extends Board{
   private final Map<Coordinates, Button> mapOfButtons = new HashMap<>();
   private final List<Ship> shipList;

    public AiBoard(){
        super();
        grid.setStyle("-fx-background-color: #13acd6;");

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Button button = new Button();
                button.setMinSize(35, 35);
                button.setMaxSize(35, 35);
                button.setStyle("-fx-background-color: #13acd6; " +
                        "-fx-border-color: #000000; " +
                        "-fx-border-width: 1px;" +
                        "-fx-opacity: 1; ");
                mapOfButtons.put(new Coordinates(x,y), button);
                grid.add(button, x, y);
            }
        }
        ShipLocator shipLocator = new ShipLocator();
        this.shipList = shipLocator.getShipList();
    }

    public Map<Coordinates, Button> getMapOfButtons() {
        return mapOfButtons;
    }

    public List<Ship> getShipList() {
        return shipList;
    }
}
