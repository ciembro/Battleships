package com.kodilla.battleships;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public abstract class GameButton {
    protected Button button;

    protected void setSize(){
        button.setMinSize(300, 75);
        button.setMaxSize(300, 75);
    }
    public abstract void handleClick();

    protected void setStyle(Image image){
        button.setGraphic(new ImageView(image));
        button.setFont(new Font("Arial", 16));
    }

    protected void setStyle(){
        button.setFont(new Font("Arial", 16));
    }

    public Button getButton() {
        return button;
    }
}
