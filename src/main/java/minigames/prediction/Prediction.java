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

        label.setLayoutX(250);
        label.setLayoutY(0);
        consequence = new Label();
        consequence.setText(connector.getConsequence());
        consequence.setLayoutX(0);
        consequence.setLayoutY(15);
        layout.getChildren().addAll(label,consequence);


        scene = new Scene(layout, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
}
