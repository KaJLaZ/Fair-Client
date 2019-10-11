package minigames.judge.сontrol;

import javafx.application.Application;
import javafx.stage.Stage;
import minigames.judge.story.MainWindow;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new MainWindow().display();
    }
}
