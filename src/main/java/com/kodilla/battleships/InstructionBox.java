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
    private final VBox textBox = new VBox();
    private final Font font = new Font("Arial",20);

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
        rulesText.setLineSpacing(1.5);
        rulesText.setText("- try and sink all of the other player's \n  before they sink all of your ships\n" +
                "- the ships can only be placed vertically \n  or horizontally\n" +
                "- diagonal placement is not allowed\n" +
                "- ships may not overlap each other \n  or touch each other\n" +
                "- no ships may be placed on another ship\n");
        textBox.getChildren().add(rulesText);
    }

    private void setLabel(){
        Label rulesLabel = new Label("RULES");
        rulesLabel.setTextFill(Color.LIGHTBLUE);
        rulesLabel.setFont(new Font("Arial", 24));
        rulesLabel.setLabelFor(textBox);
        rulesLabel.setAlignment(Pos.CENTER);
        textBox.getChildren().add(rulesLabel);
    }
}
