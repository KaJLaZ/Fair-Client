package minigames.drinkers;

import core.Lobby;
import core.Playable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Drinkers implements Playable {

    private static Drinking drinking = new Drinking();
    private Group layout;
    private Scene scene;
    private Stage stage;

    @Override
    public void play() {
        stage = new Stage();
        layout = new Group();
        scene = new Scene(layout, 600, 600);
        layout.getChildren().addAll(drinking.getGlass(), drinking.getLeave(),
                drinking.getIntoxicationBar(), drinking.getMaxIntoxicationLevel(),
                drinking.getToDrink(), drinking.getToPass());

        scene.setOnMouseClicked(event -> {
            LeftMouseClick(event.getX(), event.getY());
        });

        stage.setScene(scene);
        stage.show();
    }


    public void LeftMouseClick(double x, double y) {
        Point2D pointer = new Point2D(x, y);
        if (drinking.getGlass().contains(pointer)) {
            drinking.drink();
        } else {
            if (drinking.getLeave().contains(pointer)) {
                drinking.pass();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeight(300);
                alert.setTitle("Результат гри");
                alert.setHeaderText("Результат");
                alert.setContentText(drinking.getStatus().getText());
                alert.showAndWait();


                stage.hide();
                new Lobby();
            }
        }
    }


}
