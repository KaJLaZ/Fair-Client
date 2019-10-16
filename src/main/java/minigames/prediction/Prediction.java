package minigames.prediction;

import connection.PredictionConnection;
import core.Playable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Prediction implements Playable {
    private static Group layout;
    private static Scene scene;
    PredictionConnection connector = new PredictionConnection();
    Text consequence;


    @Override
    public void play() {
        Stage stage = new Stage();
        layout = new Group();

        Label label = new Label("Сон");

        label.setLayoutX(250);
        label.setLayoutY(0);
        consequence = new Text();
        consequence.setText(connector.getConsequence());
        consequence.setY(35);
        consequence.setWrappingWidth(500);
        layout.getChildren().addAll(label,consequence);


        scene = new Scene(layout, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
}
