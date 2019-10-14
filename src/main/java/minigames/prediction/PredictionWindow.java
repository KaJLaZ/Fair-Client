package minigames.prediction;

import core.Playable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PredictionWindow implements Playable {
    private static Group layout;
    private static Scene scene;
    Prediction prediction=new Prediction();
    Label consequence;


    @Override
    public void display() {
        Stage stage = new Stage();
        layout = new Group();

        Label label=new Label("ПЕРЕДБАЧЕННЯ");

        label.setLayoutX(480);
        label.setLayoutY(0);
        consequence=new Label();
        consequence.setText(prediction.getConsequence());
        consequence.setLayoutX(0);
        consequence.setLayoutY(15);
        layout.getChildren().addAll(label,consequence);


        scene = new Scene(layout, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }
}
