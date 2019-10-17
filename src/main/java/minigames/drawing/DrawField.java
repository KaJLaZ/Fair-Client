package minigames.drawing;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import lombok.Getter;

@Getter
public class DrawField {

    private static final String TRUE = "/True.png";
    private static final String FALSE = "/False.png";

    private static final int HEIGHT = 100;
    private static final int WIDTH = 100;
    private static final int START_HEIGHT = 200;
    private static final int START_WIDTH = 400;

    private String productName;
    private boolean[][] box;
    private Rectangle[][] field;
    private Label name;

    public DrawField(String productName) {
        name = new Label(productName);
        name.setLayoutX(START_WIDTH);
        name.setFont(new Font(24));

        this.productName = productName;
        this.box = new boolean[4][4];
        field = new Rectangle[4][4];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Rectangle(j * WIDTH + START_WIDTH, i * HEIGHT + START_HEIGHT, WIDTH, HEIGHT);
                field[i][j].setFill(Paint.valueOf("red"));
                int finalI = i;
                int finalJ = j;
                field[i][j].setOnMouseClicked(e -> {
                    draw(finalI, finalJ);
                });
            }
        }
    }

    public void draw(int x, int y) {
        try {
            box[x][y] = !box[x][y];
            if (box[x][y]) {
                field[x][y].setFill(Paint.valueOf("green"));
            } else {
                field[x][y].setFill(Paint.valueOf("red"));
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
