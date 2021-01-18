package com.kodilla.battleships;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class Board {

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
