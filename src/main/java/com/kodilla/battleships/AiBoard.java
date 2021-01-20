package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


public class AiBoard extends Board{
    HumanPlayer humanPlayer = new HumanPlayer();


    public AiBoard(){
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


                    }
                });
            }
        }
    }

    private void takeShot(){

    }

}
