package com.kodilla.battleships;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GameSaver {

//    private Game game;
//    private Map<String, Integer> wins = new HashMap<>();
//    private final File savedHashMap = new File("ranking.list");
//
//    public GameSaver(Game game){
//        this.game = game;
//    }
//
//    public void saveMap() {
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedHashMap));
//            oos.writeObject(wins);
//            oos.close();
//        } catch (Exception e) {
//            // obsługa błędów
//        }
//    }
//
//    public void loadMap() {
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMap));
//            Object readMap = ois.readObject();
//            if (readMap instanceof HashMap) {
//                wins.putAll((HashMap) readMap);
//            }
//            ois.close();
//        } catch (Exception e) {
//            // obsługa błędów
//        }
//    }
//
//    public void setWins(String winner, int score){
//        wins.put(winner, score);
//    }


}
