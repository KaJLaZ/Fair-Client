package minigames.prediction;

import javafx.application.Application;
import javafx.stage.Stage;

public class PredictionDisplayer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        PredictionWindow predictionWindow =new PredictionWindow();
        predictionWindow.display();
    }
}
