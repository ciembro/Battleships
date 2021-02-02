package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RulesButton extends GameButton {

    public RulesButton(){
        button = new Button("Rules");
        setSize();
        setStyle();
        handleClick();
    }

    @Override
    public void handleClick(){
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                createRulesWindow();
            }
        });
    }

    private void createRulesWindow(){
        Stage rulesWindow = new Stage();
        InstructionBox instructionBox = new InstructionBox();
        Scene scene = new Scene(instructionBox.getInstructionBox(), 400,500, Color.DARKGRAY);

        rulesWindow.setTitle("Rules");
        rulesWindow.setScene(scene);
        rulesWindow.show();
    }

}
