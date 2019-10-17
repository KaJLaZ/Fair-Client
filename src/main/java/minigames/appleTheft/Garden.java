package minigames.appleTheft;

import connection.AppleTheftConnection;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import lombok.Getter;

public class Garden {
    private static final int HEIGHT = 75;
    private static final int WIDTH = 75;

    private static final String EMPTYPATH = "/Garden/Empty.png";
    private static final ImagePattern EMPTYIMAGE = new ImagePattern(new Image(EMPTYPATH));
    private static final String HEROPATH = "/Garden/Hero.png";
    private static final ImagePattern HEROIMAGE = new ImagePattern(new Image(HEROPATH));
    private static final String WALLPATH = "/Garden/Wall.png";
    private static final ImagePattern WALLIMAGE = new ImagePattern(new Image(WALLPATH));
    private static final String DOGPATH = "/Garden/Dog.png";
    private static final ImagePattern DOGIMAGE = new ImagePattern(new Image(DOGPATH));
    private static final String TREEPATH = "/Garden/Tree.png";
    private static final ImagePattern TREEIMAGE = new ImagePattern(new Image(TREEPATH));
    private static final String EXITPATH = "/Garden/Exit.png";
    private static final ImagePattern EXITIMAGE = new ImagePattern(new Image(EXITPATH));

    private static final int EMPTY = 0;
    private static final int HERO = 1;
    private static final int WALL = 2;
    private static final int DOG = 3;
    private static final int TREE = 4;
    private static final int EXIT = 5;

    @Getter
    private AppleTheftConnection connect;
    @Getter
    private Rectangle[][] garden;
    @Getter
    private int[][] map;

    public Garden() {
        connect = new AppleTheftConnection();
        map = connect.getArray();
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
        for (int i = 0; i < garden.length; ++i) {
            for (int j = 0; j < garden[i].length; ++j) {
                if (garden[i][j] == null) {
                    garden[i][j] = new Rectangle(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT);
                }
                switch (map[i][j]) {
                    case EMPTY:
                        garden[i][j].setFill(EMPTYIMAGE);
                        break;
                    case HERO:
                        garden[i][j].setFill(HEROIMAGE);
                        break;
                    case WALL:
                        garden[i][j].setFill(WALLIMAGE);
                        break;
                    case DOG:
                        garden[i][j].setFill(DOGIMAGE);
                        break;
                    case TREE:
                        garden[i][j].setFill(TREEIMAGE);
                        break;
                    case EXIT:
                        garden[i][j].setFill(EXITIMAGE);
                        break;
                }
            }
        }
    }

}
