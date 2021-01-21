package com.kodilla.battleships;

import javafx.scene.layout.*;

public class Game {

    private MainGridPane mainGrid;
    private final HumanPlayer humanPlayer;
    private final HumanBoard humanBoard;
    private final AiPlayer aiPlayer;
    private final AiBoard aiBoard;

    public Game(){
        humanPlayer = new HumanPlayer();
        humanBoard = new HumanBoard();
        aiPlayer = new AiPlayer();
        aiBoard = new AiBoard();
        setMainGridPane();
        humanPlayer.shoot(aiBoard);
    }

    private void setMainGridPane(){
        mainGrid = new MainGridPane();
        mainGrid.getGridPane().add(humanBoard.setLabel("Your board"), 0, 0);
        mainGrid.getGridPane().add(humanBoard.getGrid(), 0, 1);

        mainGrid.getGridPane().add(aiBoard.setLabel("Enemy's board"), 2, 0);
        mainGrid.getGridPane().add(aiBoard.getGrid(), 2, 1);
    }

    public boolean aiShoot(){
        boolean shipWasShot = aiPlayer.shoot(humanBoard);
        aiPlayer.checkIfPlayerWon(humanBoard);
        return shipWasShot;
    }

    public GridPane getMainGrid() {

        return mainGrid.getGridPane();
    }

}
