package minigames.drawing;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;

public class BoxDrawWindow {

    private static Group layout;
    private static Scene scene;
    private static final int WINDOW_WIDTH = 1125;
    private static final int WINDOW_HEIGHT = 800;

    public void display() {
        Stage window = new Stage();
        layout = new Group();
        scene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);

        DrawConnect connect = new DrawConnect();
        Box box = connect.getBox();

        CorrectSymbols correctSymbols = new CorrectSymbols();
        for(Rectangle r: correctSymbols.getCorrectSymbols()) {
            layout.getChildren().add(r);
        }

        DrawField drawField = new DrawField(box.getNameGoods());
        for (Rectangle[] r: drawField.getField()) {
            for (Rectangle r2: r) {
                layout.getChildren().add(r2);
            }
        }
        layout.getChildren().add(drawField.getName());

        Button confirm = new Button("Confirm");
        confirm.setLayoutX(500);
        confirm.setLayoutY(700);
        confirm.setOnAction(e -> {
            // крч в цьому блоці має бути логіка яку робить кнопка
            //було б збс зробити в DrawConnect функцію,яка відправляє відповідь і
            // тут просто її викликати
            //sout тут чисто для тестування,всьо збс
            boolean win = false;
            for(Symbol S: box.getCorrectSymbols()) {
                if (Arrays.deepEquals(S.getAppearance(), drawField.getBox())) {
                    win = true;
                }
            }
            if (win)
                System.out.println("U won");
            else System.out.println("U wonn`t");
        });
        layout.getChildren().add(confirm);

        window.setScene(scene);
        window.show();
    }

}
