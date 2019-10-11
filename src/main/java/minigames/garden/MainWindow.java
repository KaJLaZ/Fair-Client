package minigames.garden;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainWindow {

    private static Group layout;
    private static Scene scene;
    private static Garden garden = new Garden();
    private static final int WINDOWWIDTH = 1125;
    private static final int WINDOWHEIGHT = 800;

    public void display() {
        Stage window = new Stage();
        layout = new Group();
        scene = new Scene(layout, WINDOWWIDTH, WINDOWHEIGHT);
        for (Rectangle[] R: garden.getGarden()){
            for (Rectangle R2: R){
                layout.getChildren().add(R2);
            }
        }
        scene.setOnKeyPressed(new Mover());
        window.setScene(scene);
        window.show();
    }

    private class Mover implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case UP:
                    garden.moveUp();
                    break;
                case DOWN:
                    garden.moveDown();
                    break;
                case LEFT:
                    garden.moveLeft();
                    break;
                case RIGHT:
                    garden.moveRight();
                    break;
            }
        }
    }
}
