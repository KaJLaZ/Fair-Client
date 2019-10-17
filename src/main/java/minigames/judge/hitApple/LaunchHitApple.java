package minigames.judge.hitApple;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class LaunchHitApple {

    private Stage stage;
    private Court court;

    public LaunchHitApple() {
        init();
    }

    private void init() {
        stage = new Stage();
        court = new Court();
        Scene scene = new Scene(court);
        stage.setScene(scene);
        stage.show();
        new ControllerJavaFX(scene, court, stage);
    }

}
