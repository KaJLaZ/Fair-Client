package minigames.judge.hitApple;


import connection.HitAppleConnection;
import core.Lobby;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerJavaFX {
    private Scene scene;
    private Court court;
    private Stage stage;

    protected ControllerJavaFX(Scene scene, Court court, Stage stage) {
        this.scene = scene;
        this.court = court;
        this.stage = stage;
        control();
    }

    private void control() {

        scene.setOnMousePressed(event -> {

            if (court.aim.isGoHorizontal()) {
                court.aim.setGoHorizontal(false);
            } else {
                shut();
            }
        });
    }

    private void shut() {
        court.aim.setGoVertical(false);
        new HitAppleConnection().sendCoordinateOfShut(court.aim.getLayoutX(), court.aim.getLayoutY());
        stage.hide();
        new Lobby();
    }

}
