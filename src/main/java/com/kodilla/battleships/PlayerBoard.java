package com.kodilla.battleships;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PlayerBoard extends Board{

    public PlayerBoard(){
        super();
        grid.setStyle("-fx-background-color: #229dc1; -fx-border-color: #000000;");
        grid.setGridLinesVisible(true);
    }


}
