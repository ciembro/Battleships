package com.kodilla.battleships;

import javafx.scene.layout.VBox;

public class ButtonVBox {
    VBox buttonBox = new VBox();
    private final NewGameButton newGameButton;


    public ButtonVBox(){
        buttonBox.setSpacing(15);
        newGameButton = new NewGameButton();
        RulesButton rulesButton = new RulesButton();

        buttonBox.getChildren().addAll(newGameButton.getButton(), rulesButton.getButton());

    }



    public NewGameButton getNewGameButton() {
        return newGameButton;
    }

//    public RulesButton getRulesButton() {
//        return rulesButton;
//    }

    public VBox getVBox() {
        return buttonBox;
    }
}
