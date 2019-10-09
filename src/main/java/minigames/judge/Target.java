package minigames.judge;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Target extends Pane{
    Rectangle r;
    public Target(){
        init();
    }

    private void init() {
        r = new Rectangle(90,90, Paint.valueOf("gray"));
        setLayoutX(550);
        setLayoutY(200);
        getChildren().add(r);
    }
}
