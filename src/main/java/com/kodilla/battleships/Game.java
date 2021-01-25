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
        mainGrid.getGridPane().add(humanBoard.getGrid(), 0, 1);
        mainGrid.getGridPane().add(aiBoard.getGrid(), 2, 1);
    }

    public boolean aiShoot(){
        boolean shipWasShot = aiPlayer.shoot(humanBoard);
        if (aiPlayer.checkIfPlayerWon(humanBoard)){
            MainGridPane.showWinnerScreen(false);
        }
        humanPlayer.setHasTurn(true);

        return shipWasShot;
    }

    public GridPane getMainGrid() {

        return mainGrid.getGridPane();
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }
}
