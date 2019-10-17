package minigames.prediction;

import connection.PredictionConnection;
import core.Lobby;
import core.Playable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Prediction implements Playable {
    private static Group layout;
    private static Scene scene;
    private PredictionConnection connector = new PredictionConnection();
    private Text consequence;
    private Button button = new Button("OK");


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
        layout.getChildren().addAll(label, consequence);
        layout.getChildren().add(button);
        button.setLayoutX(240);
        button.setLayoutY(250);
        button.setOnAction(event -> {
            stage.hide();
            new Lobby();
        });

        scene = new Scene(layout, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
}
