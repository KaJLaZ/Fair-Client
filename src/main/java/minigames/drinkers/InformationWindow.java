package minigames.drinkers;

import core.Lobby;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InformationWindow {

    private static final int WINDOWWIDTH = 200;
    private static final int WINDOWHEIGHT = 100;

    private Stage window;
    private Group layout;
    private Scene scene;
    private Label info;
    private Button button;


    public InformationWindow(String message) {
        window = new Stage();
        layout = new Group();
        scene = new Scene(layout, WINDOWWIDTH, WINDOWHEIGHT);
        info = new Label(message);
        button = new Button("OK");
    }


    public void display() {
        info.setLayoutX(50);
        button.setLayoutX(50);
        button.setLayoutY(50);
        button.setOnAction(e -> {
            window.hide();
            new Lobby();
        });

        layout.getChildren().addAll(info, button);
        window.setScene(scene);
        window.show();
    }
}