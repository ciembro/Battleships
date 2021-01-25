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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainGridPane {
    private final Image mainImage = new Image("file:src\\main\\resources\\blue.jpg");
    private final GridPane mainGridPane;
    private Button createNewGameButton;
    private Button enemyTurnButton;
    private Font buttonFont;
    private Label humanTurnLabel;
    private Label aiTurnLabel;
    InstructionBox instructionBox;

    public MainGridPane(){
        mainGridPane = new GridPane();
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true,
                true, false);
        BackgroundImage backgroundImage = new BackgroundImage(mainImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        Background background = new Background(backgroundImage);
        mainGridPane.setBackground(background);

        mainGridPane.setPadding(new Insets(20,20,20,20));
        mainGridPane.setVgap(8);
        mainGridPane.setHgap(50);
        setButtonFont();

        Font font = new Font("Arial", 16);
        Label playerLabel = new Label("YOUR BOARD");
        Label aiLabel = new Label("ENEMY'S BOARD");

        playerLabel.setFont(font);
        aiLabel.setFont(font);

        playerLabel.setTextFill(Color.LIGHTBLUE);
        aiLabel.setTextFill(Color.LIGHTBLUE);

        mainGridPane.add(playerLabel, 0, 0);
        mainGridPane.add(aiLabel, 0, 2);

//        VBox turnsBox = new VBox();
//        turnsBox.setSpacing(15);
//        createAiTurnLabel();
//        createHumanTurnLabel();
//        turnsBox.getChildren().addAll(humanTurnLabel, aiTurnLabel);
//        mainGridPane.add(turnsBox, 1,1);
        mainGridPane.add(infoHBox(), 1,3);
    }

    private void setButtonFont(){
        buttonFont = new Font("Arial", 20);
    }
    public GridPane getGridPane() {
        return mainGridPane;
    }

    public HBox infoHBox(){
        HBox hBox = new HBox();
        hBox.setSpacing(15);
        VBox buttonBox = createButtonBox();

        hBox.getChildren().addAll(buttonBox);

        return hBox;
    }

    private VBox createButtonBox(){
        VBox buttonBox = new VBox();
        buttonBox.setSpacing(15);

        createNewGameButton = createStartNewGameButton();
        enemyTurnButton = createEnemyTurnButton();
        Button rulesButton = createRulesButton();
        rulesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                createRulesWindow();
            }
        });
        buttonBox.getChildren().addAll(createNewGameButton, rulesButton, enemyTurnButton);

        return buttonBox;
    }

    public static void showWinnerScreen(boolean humanWon){
        Stage winnerWindow = new Stage();
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: #13acd6; " +
                "-fx-border-color: #000000;");
        Label label = new Label();
        label.setTextFill(Color.BLACK);

        label.setPadding(new Insets(20,20,40,20));
        if (humanWon){
            label.setFont(new Font("Arial", 14));
            label.setText("GAME OVER\nCongratulations, you win!!!");
        } else {
            label.setFont(new Font("Arial", 24));
            label.setText("GAME OVER\nYou lost ;<");
        }
        grid.add(label,0,0);
        Scene scene = new Scene(grid, 300, 100);

        winnerWindow.setScene(scene);
        winnerWindow.show();
    }

    private void createRulesWindow(){
        Stage rulesWindow = new Stage();
        instructionBox = new InstructionBox();
        Scene scene = new Scene(instructionBox.getInstructionBox(), 400,500, Color.DARKGRAY);

        rulesWindow.setTitle("Rules");
        rulesWindow.setScene(scene);
        rulesWindow.show();
    }

    private Button createStartNewGameButton() {
        Button startNewGameButton = new Button("Start a new game");
        startNewGameButton.setFont(buttonFont);
        Image startNewGameImage = new Image("file:src\\main\\resources\\ship.png");

        startNewGameButton.setGraphic(new ImageView(startNewGameImage));
        startNewGameButton.setMinSize(300, 75);
        startNewGameButton.setMaxSize(300, 75);

        return startNewGameButton;
    }

    private Button createEnemyTurnButton(){
        Button enemyMove = new Button("Start enemy's turn");
        enemyMove.setFont(buttonFont);
        enemyMove.setMinSize(300, 75);
        enemyMove.setMaxSize(300, 75);
        Image shootImage = new Image("file:src\\main\\resources\\shoot.png");
        enemyMove.setGraphic(new ImageView(shootImage));

        return enemyMove;
    }

    private Button createRulesButton(){
        Button rulesButton = new Button("Rules");
        rulesButton.setFont(buttonFont);
        rulesButton.setMinSize(300, 75);
        rulesButton.setMaxSize(300, 75);
        return rulesButton;
    }

//    private void createHumanTurnLabel(){
//        humanTurnLabel = new Label();
//        humanTurnLabel.setText("Your turn");
//        humanTurnLabel.setFont(new Font("Arial",24));
//        humanTurnLabel.setTextFill(Color.LIGHTBLUE);
//    }
//
//
//    private void createAiTurnLabel(){
//        aiTurnLabel = new Label();
//        aiTurnLabel.setText("Enemy's turn");
//        aiTurnLabel.setFont(new Font("Arial",24));
//        aiTurnLabel.setTextFill(Color.LIGHTBLUE);
//    }


    public Button getCreateNewGameButton() {
        return createNewGameButton;
    }

    public Button getEnemyTurnButton() {
        return enemyTurnButton;
    }
}
