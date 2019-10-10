package HitApple;

import Control.Transfer;
import javafx.geometry.Point2D;
import javafx.scene.Scene;

public class ControllerJavaFX {
    private boolean result;
    private int counterOfShuts;
    private Scene scene;
    private Court court;
    public ControllerJavaFX(Scene scene, Court court){
        counterOfShuts = 0;
        this.scene = scene;
        this.court = court;
        control();
    }

    private void control()  {

        scene.setOnMousePressed(event -> {

            if (court.aim.isGoHorizontal()) {
                if (getCounterOfShuts() == 3) {
                    return;
                }
                incrementCounterOfShuts();
                court.aim.setGoHorizontal(false);
            } else {
                shut();
            }

        });
    }

    private void shut() {
        court.aim.setGoVertical(false);
        Apple apple = new Apple(new Point2D(court.aim.getLayoutX(), court.aim.getLayoutY()));
        result = court.prisoner.contains(court.prisoner.sceneToLocal(apple.getLayoutOfApple()));
        checkOfResult(apple);
        System.out.println(result);

    }

    private void checkOfResult(Apple apple){
        if(result) {
            new Transfer().sendResult(result);
            return;
        }
        if (!result && counterOfShuts != 3) {
            court.getChildren().removeAll();
            court.init();
            court.getChildren().add(apple);
            return;
        }
        new Transfer().sendResult(result);

    }

    private int getCounterOfShuts() {
        return counterOfShuts;
    }

    private void incrementCounterOfShuts() {
        this.counterOfShuts = ++counterOfShuts;
    }
}
