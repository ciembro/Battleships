package com.kodilla.battleships;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Board {
    protected Map<Coordinates, Boolean> isShot = new HashMap<>();
    protected List<Ship> shipList;
    protected GridPane grid = new GridPane();

    public abstract void shoot();

    public Board(){
        ColumnConstraints[] columnConstraints = createColumns(10);
        grid.getColumnConstraints().addAll(columnConstraints);

        RowConstraints[] rowConstraints = createRows(10);
        grid.getRowConstraints().addAll(rowConstraints);

        for (int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                isShot.put(new Coordinates(x,y), false);
            }
        }
        ShipLocator shipLocator = new ShipLocator();
        shipLocator.placeShipsOnBoard();
        this.shipList = shipLocator.getShipList();
    }

    private ColumnConstraints[] createColumns(int numOfColumns) {
        ColumnConstraints[] columnConstraints = new ColumnConstraints[numOfColumns];
        for (int i = 0; i < numOfColumns; i++) {
            columnConstraints[i] = new ColumnConstraints(35, 35, 35);
        }
        return columnConstraints;
    }

    private RowConstraints[] createRows(int numOfRows) {
        RowConstraints[] rowConstraints = new RowConstraints[numOfRows];
        for (int i = 0; i < numOfRows; i++) {
            rowConstraints[i] = new RowConstraints(35, 35, 35);
        }
        return rowConstraints;
    }

    public Label setLabel(String text){
        Label label = new Label(text);
        label.setTextFill(Color.LIGHTBLUE);
        label.setFont(new Font("Arial", 24));
        return label;
    }

    public GridPane getGrid() {
        return grid;
    }
}
