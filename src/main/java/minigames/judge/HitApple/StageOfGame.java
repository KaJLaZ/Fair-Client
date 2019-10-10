package HitApple;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageOfGame {
    private Stage stage;
    private Court court;
    public StageOfGame(){
        init();
    }
    public void init(){
        stage = new Stage();
        court = new Court();
        Scene scene = new Scene(court);
        stage.setScene(scene);
        stage.show();
        new ControllerJavaFX(scene, court);
    }
}
