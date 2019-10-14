package minigames.judge.hitApple;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Apple extends Pane {

    private Circle apple;
    private Point2D layoutOfApple;

    private final static double WIND = 15;
    public Apple(Point2D layoutOfAim){
        layoutOfApple(layoutOfAim);
        init();
    }

    private void layoutOfApple(Point2D layoutOfAim){
        layoutOfApple = new Point2D(layoutOfAim.getX(), layoutOfAim.getY());
    }
    private void init(){
        setLayoutX(layoutOfApple.getX());
        setLayoutY(layoutOfApple.getY());
        apple = new Circle(10, Color.RED);
        getChildren().add(apple);
    }

    public Point2D getLayoutOfApple() {
        return layoutOfApple;
    }

}

