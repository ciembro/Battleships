package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class InstructionBox {
    private VBox textBox = new VBox();
    private Font font = new Font("Arial",24);

    public InstructionBox(){
        textBox.setSpacing(15);
        setLabel();
        setText();
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
}
