package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;
import java.util.Map;


public class AiBoard extends Board{
   private final Map<Coordinates, Button> mapOfButtons = new HashMap<>();

    public AiBoard(){
        super();
        grid.setStyle("-fx-background-color: #13acd6;");

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Button button = new Button();
                button.setMinSize(35, 35);
                button.setMaxSize(35, 35);
                button.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000; -fx-border-width: 1px ");
                mapOfButtons.put(new Coordinates(x,y), button);
                grid.add(button, x, y);
            }
        }
    }

    public Map<Coordinates, Button> getMapOfButtons() {
        return mapOfButtons;
    }
}