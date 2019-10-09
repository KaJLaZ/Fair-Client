package minigames.judge;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Court court = new Court();
        Scene scene = new Scene(court);
        primaryStage.setScene(scene);
        primaryStage.show();
        new ControllerJavaFX(scene, court);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
