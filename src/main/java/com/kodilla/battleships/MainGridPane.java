package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainGridPane {
    private Image mainImage = new Image("file:src\\main\\resources\\blue.jpg");
    private GridPane mainGridPane;
    InstructionBox instructionBox;

    public MainGridPane(){
        mainGridPane = new GridPane();
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(mainImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        Background background = new Background(backgroundImage);
        mainGridPane.setBackground(background);

//        mainGridPane.add(new Insets(15, 20, 15, 20));
        mainGridPane.setVgap(10);
        mainGridPane.setHgap(10);

        instructionBox = new InstructionBox();
        mainGridPane.add(instructionBox.getTextBox(), 3, 1);

    }

    public GridPane getGridPane() {
        return mainGridPane;
    }


}
