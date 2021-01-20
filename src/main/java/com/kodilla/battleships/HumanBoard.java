package com.kodilla.battleships;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class HumanBoard extends Board{


    public HumanBoard(){
        super();
        grid.setStyle("-fx-background-color: #13acd6; -fx-border-color: #000000;");
        grid.setGridLinesVisible(true);

        for (Ship ship : shipList){
            for (Coordinates c : ship.getShipCoordinatesList()){
                Rectangle rectangle = new Rectangle(35,35, Color.BLACK);
                grid.add(rectangle, c.getX(), c.getY());
            }
        }
    }



//    public Node findButton(int x, int y){
//        Node result = null;
//        ObservableList<Node> children = grid.getChildren();
//        for(Node node : children) {
//            if(GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x) {
//                result = node;
//                break;
//            }
//        }
//        return result;
//    }

}

