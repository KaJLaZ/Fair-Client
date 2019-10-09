package minigames.garden;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InformationWindow {

    private static Group layout;
    private static Scene scene;
    private static final int WINDOWWIDTH = 200;
    private static final int WINDOWHEIGHT = 100;

    public static void display(String message) {
        Stage window = new Stage();
        layout = new Group();
        scene = new Scene(layout, WINDOWWIDTH, WINDOWHEIGHT);

        Label info = new Label(message);
        info.setLayoutX(50);
        Button button = new Button("OK");
        button.setLayoutX(50);
        button.setLayoutY(50);
        button.setOnAction(e -> {
//            window.close();
            Platform.exit();
        });

        layout.getChildren().addAll(info,button);
        window.setScene(scene);
        window.show();
    }
}
