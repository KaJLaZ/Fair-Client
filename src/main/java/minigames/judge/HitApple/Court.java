package HitApple;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Court extends Group {
    Aim aim;
    Rectangle r;
    Target prisoner;
    public Court(){
        init();
    }

    public void init(){
        r = new Rectangle(1200,700, Color.GREEN);
        aim = new Aim();
        prisoner = new Target();
        getChildren().addAll(r, prisoner, aim);
        new Thread(aim).start();
    }
}
