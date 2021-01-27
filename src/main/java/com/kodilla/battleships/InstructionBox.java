package com.kodilla.battleships;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class InstructionBox{
    private final VBox instructionBox = new VBox();
    private final Font font = new Font("Arial",18);

    public InstructionBox(){
        instructionBox.setSpacing(15);
        instructionBox.setPadding(new Insets(20,20,20,20));
        setLabel();
        instructionBox.getChildren().add(setText());
        instructionBox.getChildren().add(printAvailableShips());
    }

    public VBox getInstructionBox() {
        return instructionBox;
    }

    private Text setText(){
        Text rulesText = new Text();
        rulesText.setFont(font);
        rulesText.setFill(Color.BLACK);
        rulesText.setTextAlignment(TextAlignment.JUSTIFY);
        rulesText.setLineSpacing(1.5);
        rulesText.setText("- try and sink all of the other player's \n  before they sink all of your ships\n" +
                "- the ships can only be placed vertically \n  or horizontally\n" +
                "- diagonal placement is not allowed\n" +
                "- ships may not overlap each other \n  or touch each other\n" +
                "- no ships may be placed on another ship\n");
        return rulesText;

    }

    private void setLabel(){
        Label rulesLabel = new Label("RULES");
        rulesLabel.setTextFill(Color.BLACK);
        rulesLabel.setFont(new Font("Arial", 24));
        rulesLabel.setLabelFor(instructionBox);
        rulesLabel.setAlignment(Pos.CENTER);
        instructionBox.getChildren().add(rulesLabel);
    }

    private VBox printAvailableShips(){
        Label label = new Label("AVAILABLE FLEET:");
        label.setTextFill(Color.BLACK);
        label.setFont(new Font("Arial", 20));

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();
        HBox row4 = new HBox();
        row1.setSpacing(3);
        row2.setSpacing(5);
        row3.setSpacing(3);
        row4.setSpacing(5);
        vBox.getChildren().add(label);
        vBox.getChildren().addAll(row1, row2, row3, row4);
        row1.getChildren().add(new Rectangle(140,35, Color.BLACK));
        row2.getChildren().addAll(new Rectangle(105,35, Color.BLACK),
                new Rectangle(105,35, Color.BLACK));
        row3.getChildren().addAll(new Rectangle(70,35, Color.BLACK),
                new Rectangle(70,35, Color.BLACK),
                new Rectangle(70,35, Color.BLACK));
        row4.getChildren().addAll(new Rectangle(35,35, Color.BLACK),
                new Rectangle(35,35, Color.BLACK),
                new Rectangle(35,35, Color.BLACK),
                new Rectangle(35,35, Color.BLACK));

        return vBox;
    }

}
