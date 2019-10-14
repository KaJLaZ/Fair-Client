package minigames.prediction;

import connection.Connector;
import core.Playable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Prediction implements Playable {
    private static Group layout;
    private static Scene scene;
    Connector connector = new Connector();
    Label consequence;


    @Override
    public void play() {
        Stage stage = new Stage();
        layout = new Group();

        Label label = new Label("Сон");

        label.setLayoutX(480);
        label.setLayoutY(0);
        consequence = new Label();
        consequence.setText(connector.getConsequenceFromServer());
        consequence.setLayoutX(0);
        consequence.setLayoutY(15);
        layout.getChildren().addAll(label,consequence);


        scene = new Scene(layout, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }
}
