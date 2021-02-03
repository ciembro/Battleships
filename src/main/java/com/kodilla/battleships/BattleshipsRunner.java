package com.kodilla.battleships;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BattleshipsRunner extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        startGame(primaryStage);

    }

    static void startGame(Stage primaryStage) {
        Game game = new Game();
        Scene s = new Scene(game.getMainGrid(), 1200, 800);
        primaryStage.setTitle("Battleships");
        primaryStage.setScene(s);
        primaryStage.show();

    }

       public static void restart(Stage primaryStage) {
            startGame(primaryStage);
        }

        private void setPrimaryStage(Stage pStage){
            primaryStage = pStage;
        }

        public static Stage getPrimaryStage(){
            return primaryStage;
        }

    }






