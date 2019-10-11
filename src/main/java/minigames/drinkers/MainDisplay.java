package minigames.drinkers;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainDisplay {

    private static Group layout;
    private static Scene scene;
    private static Drinking drinking = new Drinking();

    public  void display() {
        Label hint=new Label("NUM 1 to drink | NUM2 to pass");
        hint.setLayoutX(0);
        hint.setLayoutY(0);
        Stage stage = new Stage();
        layout = new Group();
        scene = new Scene(layout, 1000, 800);
        layout.getChildren().add(drinking.playerDrunk);
        layout.getChildren().add(hint);


        scene.setOnKeyPressed(new Keyboard());
        stage.setScene(scene);
        stage.show();
    }


    private static class Keyboard implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case NUMPAD1:
                    drinking.drink();
                    break;
                case NUMPAD2:
                    drinking.pass();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeight(300);
                    alert.setTitle("Results");
                    alert.setHeaderText(drinking.npcDrunk.getText());
                    alert.setContentText(drinking.status.getText());

                    alert.showAndWait();
                    break;
            }
        }
    }
}
