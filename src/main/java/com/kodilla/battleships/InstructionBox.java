package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class InstructionBox {
    private VBox textBox = new VBox();
    private Font font = new Font("Arial",24);

    public InstructionBox(){
        textBox.setSpacing(15);
        setLabel();
        setText();
        createStartNewGameButton();
    }

    public VBox getTextBox() {
        return textBox;
    }

    private void setText(){
        Text rulesText = new Text();
        rulesText.setFont(font);
        rulesText.setFill(Color.LIGHTBLUE);
        rulesText.setTextAlignment(TextAlignment.JUSTIFY);
        rulesText.setText(" This is basic rule\n This is basic rule\n This is basic rule\n This is basic rule\n This is basic rule\n");
        textBox.getChildren().add(rulesText);
    }

    private void setLabel(){
        Label rulesLabel = new Label("Rules");
        rulesLabel.setTextFill(Color.LIGHTBLUE);
        rulesLabel.setFont(font);
        rulesLabel.setAlignment(Pos.CENTER);
        textBox.getChildren().add(rulesLabel);
    }

    public void createStartNewGameButton(){
        Button startNewGameButton = new Button("Start new game");
        startNewGameButton.setFont(font);
        Image startNewGameImage = new Image("file:src\\main\\resources\\ship.png");

        startNewGameButton.setGraphic(new ImageView(startNewGameImage));
        startNewGameButton.setMinSize(275, 100);
        startNewGameButton.setMaxSize(275, 100);
        startNewGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ///
            }
        });
        textBox.getChildren().add(startNewGameButton);
    }
}
