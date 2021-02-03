package com.kodilla.battleships;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import java.util.*;


public abstract class Board {
    protected Set<Coordinates> isShot = new HashSet<>();
    protected GridPane grid = new GridPane();

    public Board(){
        ColumnConstraints[] columnConstraints = createColumns(10);
        grid.getColumnConstraints().addAll(columnConstraints);

        RowConstraints[] rowConstraints = createRows(10);
        grid.getRowConstraints().addAll(rowConstraints);
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
    public GridPane getGrid() {
        return grid;
    }

    public Set<Coordinates> getIsShot() {
        return isShot;
    }

    public void addShotCoordinates(Coordinates coordinates){
        isShot.add(coordinates);
    }

}
