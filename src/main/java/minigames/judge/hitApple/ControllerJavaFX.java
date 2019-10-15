package minigames.judge.hitApple;

import javafx.stage.Stage;
import connection.Transfer;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import core.Lobby;

public class ControllerJavaFX {
    private boolean result;
    private int counterOfShuts;
    private Scene scene;
    private Court court;
    private Stage stage;

    public ControllerJavaFX(Scene scene, Court court, Stage stage){
        counterOfShuts = 0;
        this.scene = scene;
        this.court = court;
        this.stage = stage;
        control();
    }

    private void control()  {

        scene.setOnMousePressed(event -> {

            if (court.aim.isGoHorizontal()) {
                if (getCounterOfShuts() == 3) {
                    return;
                }
                court.aim.setGoHorizontal(false);
            } else {
                shut();
            }

        });
    }

    private void shut() {
        ++counterOfShuts;
        court.aim.setGoVertical(false);
        Apple apple = new Apple(new Point2D(court.aim.getLayoutX(), court.aim.getLayoutY()));
        result = court.prisoner.contains(court.prisoner.sceneToLocal(apple.getLayoutOfApple()));
        checkOfResult(apple);
        System.out.println(result);

    }

    private void checkOfResult(Apple apple){
        if(result) {
            new Transfer().sendResult(result);
            stage.hide();
            new Lobby();
            return;
        }
        if (!result && counterOfShuts != 3) {
            court.getChildren().removeAll();
            court.init();
            court.getChildren().add(apple);
            return;
        }
        new Transfer().sendResult(result);
        stage.hide();
        new Lobby();

    }

    private int getCounterOfShuts() {
        return counterOfShuts;
    }

}
