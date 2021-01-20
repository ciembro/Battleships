package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class EnemyBoard extends Board{

    public EnemyBoard(){
        super();
        grid.setStyle("-fx-background-color: #13acd6;");

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Button button = new Button();
                button.setMinSize(35, 35);
                button.setMaxSize(35, 35);
                button.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000; -fx-border-width: 1px ");
                grid.add(button, x, y);
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
//                        System.out.println(GridPane.getColumnIndex(button) + "," + GridPane.getRowIndex(button));
                        button.setStyle("-fx-background-color: #000000; -fx-border-color: #000000; -fx-border-width: 0px ");
                        button.setDisable(true);
//                        aiTurn(playerBoard.getGrid());
                    }
                });
            }
        }
    }

//    void aiTurn(GridPane playerBoard) {
//        Random random = new Random();
//        Rectangle rectangle = new Rectangle(35, 35, Color.BLACK);
//        int x = random.nextInt(10);
//        int y = random.nextInt(10);
//        playerBoard.add(rectangle, x, y);
//    }


}
