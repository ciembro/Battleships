package com.kodilla.battleships;

import javafx.scene.layout.*;

public class Game {

    private MainGridPane mainGrid;
    private HumanPlayer humanPlayer;
    private HumanBoard humanBoard;
    private AiPlayer aiPlayer;
    private AiBoard aiBoard;

    public Game(){
        humanPlayer = new HumanPlayer();
        humanBoard = new HumanBoard();
        aiPlayer = new AiPlayer();
        aiBoard = new AiBoard();
        setMainGridPane();
    }

    private void setMainGridPane(){
        mainGrid = new MainGridPane();
        mainGrid.getGridPane().add(humanBoard.setLabel("Your board"), 0, 0);
        mainGrid.getGridPane().add(humanBoard.getGrid(), 0, 1);

        mainGrid.getGridPane().add(aiBoard.setLabel("Enemy's board"), 2, 0);
        mainGrid.getGridPane().add(aiBoard.getGrid(), 2, 1);
    }


    public GridPane getMainGrid() {
        return mainGrid.getGridPane();
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public HumanBoard getHumanBoard() {
        return humanBoard;
    }

    public AiPlayer getAiPlayer() {
        return aiPlayer;
    }

    public AiBoard getAiBoard() {
        return aiBoard;
    }



}
