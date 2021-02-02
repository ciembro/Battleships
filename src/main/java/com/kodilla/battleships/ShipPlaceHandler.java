package com.kodilla.battleships;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ShipPlaceHandler {

    private final MenuButton xMenuButton;
    private final MenuButton yMenuButton;
    private final CheckBox positionCheckBox;
    private final HumanShipLocator humanShipLocator;
    private Ship ship;

    public ShipPlaceHandler(HumanShipLocator humanShipLocator){
        this.humanShipLocator = humanShipLocator;
        xMenuButton = new MenuButton(null,null);
        yMenuButton = new MenuButton(null,null);
        positionCheckBox = new CheckBox();
    }

    public HBox createShipField(int shipSize){
        HBox hBox = new HBox();
        hBox.setSpacing(5);
        Label xLabel = setLabel("x");
        Label yLabel = setLabel("y");
        Label posLabel = setLabel("horizontal");

        setButtonSize(xMenuButton, 50, 25);
        setButtonSize(yMenuButton, 50, 25);


        for (int j = 1; j <= 10 ; j++) {
            MenuItem xMenuItem =  new MenuItem(String.valueOf(j));
            MenuItem yMenuItem = new MenuItem(String.valueOf(j));

            xMenuItem.setOnAction(e -> xMenuButton.setText(xMenuItem.getText()));
            yMenuItem.setOnAction(e -> yMenuButton.setText(yMenuItem.getText()));
            xMenuButton.getItems().add(xMenuItem);
            yMenuButton.getItems().add(yMenuItem);

        }
        Button okButton = createOkButton();
        Button delButton = createDelButton();
        delButton.setDisable(true);
        okButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!xMenuButton.getText().equals("") && !yMenuButton.getText().equals("")){
                    int x = Integer.parseInt(xMenuButton.getText()) - 1;
                    int y = Integer.parseInt(yMenuButton.getText()) - 1;
                    boolean isHorizontal = positionCheckBox.isSelected();
                    if (isHorizontal && x <= 10 - shipSize || !isHorizontal && y <= 10 - shipSize){
                        Coordinates initCoordinates = new Coordinates(x, y);
                        ship = new Ship(shipSize, initCoordinates, isHorizontal);
                        if (humanShipLocator.placeShip(ship)){
                            xMenuButton.setDisable(true);
                            yMenuButton.setDisable(true);
                            okButton.setDisable(true);
                            delButton.setDisable(false);
                        }
                    }

                }

            }
        });

        delButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (humanShipLocator.deleteShip(ship)){
                    okButton.setDisable(false);
                    xMenuButton.setDisable(false);
                    yMenuButton.setDisable(false);
                    delButton.setDisable(true);
                }
            }
        });
        if (shipSize == 1) {
            hBox.getChildren().addAll(xLabel, xMenuButton,
                    yLabel, yMenuButton, okButton, delButton);
        } else {
            hBox.getChildren().addAll(xLabel, xMenuButton,
                    yLabel, yMenuButton, posLabel, positionCheckBox, okButton, delButton);
        }
        return hBox;
    }


    public Ship getShip() {
        return ship;
    }

    private Button createOkButton(){
        Button button = new Button("Accept");
        button.setMinSize(60,25);
        button.setMaxSize(60,25);
        return button;
    }

    private Button createDelButton(){
        Button button = new Button("Delete");
        button.setMinSize(60,25);
        button.setMaxSize(60,25);
        return button;
    }

    private Label setLabel(String text){
        Label label = new Label(text);
        label.setFont(new Font("Arial", 12));

        return label;
    }

    private void setButtonSize(MenuButton button, int width, int height ){
        button.setMinWidth(width);
        button.setMaxWidth(width);
        button.setMinHeight(height);
        button.setMaxHeight(height);
    }

}
