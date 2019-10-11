package minigames.drawing;

import javafx.application.Application;
import javafx.stage.Stage;

public class Drawing extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new BoxDrawWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
