package HitApple;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Target extends Pane {
    Rectangle r;
    public Target(){
        init();
    }

    private void init() {
        r = new Rectangle(90,90, Color.GRAY);
        setLayoutX(550);
        setLayoutY(200);
        getChildren().add(r);
    }
}
