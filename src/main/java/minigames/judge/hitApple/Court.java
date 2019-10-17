package minigames.judge.hitApple;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Court extends Group {
    protected Aim aim;
    private Rectangle r;
    private Target prisoner;

    public Court() {
        init();
    }

    private void init() {
        r = new Rectangle(1200, 700, Color.GREEN);
        aim = new Aim();
        prisoner = new Target();
        getChildren().addAll(r, prisoner, aim);
        new Thread(aim).start();
    }
}
