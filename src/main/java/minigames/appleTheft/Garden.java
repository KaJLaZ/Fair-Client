package minigames.appleTheft;

import connection.Connection;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import lombok.Getter;

public class Garden {
    private static final int HEIGHT = 75;
    private static final int WIDTH = 75;

    private static final String EMPTYPATH = "file:///Empty.png";
    private static final String HEROPATH = "file:///Hero.png";
    private static final String WALLPATH = "file:///Wall.png";
    private static final String DOGPATH = "file:///Dog.png";
    private static final String TREEPATH = "file:///Tree.png";
    private static final String EXITPATH = "file:///Exit.png";

    private static final int EMPTY = 0;
    private static final int HERO = 1;
    private static final int WALL = 2;
    private static final int DOG = 3;
    private static final int TREE = 4;
    private static final int EXIT = 5;

    private static Connection connect = new Connection();


    @Getter
    private Rectangle[][] garden;
    @Getter
    private int [][] map;

    public Garden() {
        map = connect.getArray();
        if (map == null) {
            // TODO
        }
        garden = new Rectangle[map.length][map[0].length];
        drawGarden();
    }

    public void moveUp() {
        map = connect.up();
        drawGarden();
    }

    public void moveDown() {
        map = connect.down();
        drawGarden();
    }

    public void moveLeft() {
        map = connect.left();
        drawGarden();
    }

    public void moveRight() {
        map = connect.right();
        drawGarden();
    }

    private void drawGarden() {
        if(map == null)
            System.out.println("Found");
        for (int i = 0; i < garden.length; ++i) {
            for (int j = 0; j < garden[i].length; ++j) {
                if(garden[i][j] == null) {
                    garden[i][j] = new Rectangle(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
                }
                switch (map[i][j]) {
                    case EMPTY:
                        garden[i][j].setFill(Paint.valueOf("#9ACD32"));
                        break;
                    case HERO:
                        garden[i][j].setFill(Paint.valueOf("#1E90FF"));
                        break;
                    case WALL:
                        garden[i][j].setFill(Paint.valueOf("#006400"));
                        break;
                    case DOG:
                        garden[i][j].setFill(Paint.valueOf("red"));
                        break;
                    case TREE:
                        garden[i][j].setFill(Paint.valueOf("gold"));
                        break;
                    case EXIT:
                        garden[i][j].setFill(Paint.valueOf("black"));
                        break;
                }
            }
        }
        showInfoWhenGameEnded();
    }

    private void showInfoWhenGameEnded() {
        if(connect.isGameEnded()) {
            AppleTheft.window.hide();
            if(connect.isWon()) {
                InformationWindow.display("You Won!");
            }
            else {
                InformationWindow.display("You lose(");
            }
        }
    }
}
