package com.kodilla.battleships;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;


public class HumanShipLocatorWindow {
    private final Stage mainWindow = new Stage();
    private final VBox vBox = new VBox();
    private final Scene scene;
    HumanPlayer humanPlayer;
    private final HumanShipLocator humanShipLocator;

    public HumanShipLocatorWindow(HumanPlayer hPlayer){
        humanPlayer = hPlayer;
        humanShipLocator = new HumanShipLocator(humanPlayer.getHumanBoard());
        setVBox();
        setVBoxProperties();
        scene = new Scene(vBox, 400,700);
        openWindow();
    }

    public void openWindow(){
        mainWindow.setScene(scene);
        mainWindow.setAlwaysOnTop(true);
        mainWindow.show();
    }

    private void setVBoxProperties(){
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10,10,10,10));
    }

    private void getUserName(){
        Label label = setLabel("Name");
        TextField name = new TextField();
        name.setPrefSize(50,5);
        name.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               humanPlayer.setName(name.getText());
                name.setOpacity(1);
                name.setDisable(true);
            }
        });
        vBox.getChildren().addAll(label, name);
    }

    private void createCoordinatesFields() {
        for (Integer shipSize : Game.getShipSizes()) {
            Label label = setLabel("Ship of size " + shipSize);
            ShipPlaceHandler shipPlaceHandler = new ShipPlaceHandler(humanShipLocator);
            HBox hBox = shipPlaceHandler.createShipField(shipSize);
            vBox.getChildren().addAll(label,hBox);
        }
    }

    private Label setLabel(String text){
        Label label = new Label(text);
        label.setFont(new Font("Arial", 12));

        return label;
    }

    private void createAcceptAllButton(){
        Button button = new Button("Accept all");
        button.setMinSize(100,25);
        button.setMaxSize(100,25);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (humanShipLocator.getShipList().size() == Game.getShipSizes().size()){
                    humanShipLocator.getHumanBoard().setShipList(humanShipLocator.getShipList());
                    mainWindow.close();
                } else {
                    Game.printErrorWindow();
                }
            }
        });
        vBox.getChildren().add(button);
    }
    private void createDeleteAllButton(){
        Button button = new Button("Delete all");

        button.setMinSize(100,25);
        button.setMaxSize(100,25);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                humanShipLocator.deleteAllShips();
                setVBox();
            }
        });
        vBox.getChildren().add(button);
    }

    private void createPlaceRandomlyButton(){
        Button button = new Button("Place randomly");

        button.setMinSize(100,25);
        button.setMaxSize(100,25);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                humanShipLocator.placeShipsRandomly();
                humanShipLocator.getHumanBoard().setShipList(humanShipLocator.getShipList());
                mainWindow.close();

            }
        });
        vBox.getChildren().add(button);
    }

    private void setVBox(){
        List<Node> nodes = vBox.getChildren();
        vBox.getChildren().removeAll(nodes);
        getUserName();
        createCoordinatesFields();
        createAcceptAllButton();
        createDeleteAllButton();
        createPlaceRandomlyButton();
    }

}
