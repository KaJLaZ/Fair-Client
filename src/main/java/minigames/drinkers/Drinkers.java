package minigames.drinkers;

import javafx.application.Application;
import javafx.stage.Stage;

public class Drinkers extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainDisplay.display();
    }

    public static void main(String[] args) {
        launch();
    }
}
