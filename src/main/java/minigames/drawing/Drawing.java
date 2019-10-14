package minigames.drawing;

import connection.DrawConnect;
import core.Playable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import core.Lobby;
import serverCore.Symbol;

import java.net.ConnectException;

public class Drawing implements Playable {

    private static Group layout;
    private static Scene scene;
    private static final int WINDOW_WIDTH = 1125;
    private static final int WINDOW_HEIGHT = 800;

    public Drawing(){ }
    @Override
    public void play() {
        Stage window = new Stage();
        layout = new Group();
        scene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);

        DrawConnect connect = new DrawConnect();
        String nameGoods = "";
        try {
             nameGoods = connect.getNameGoods();
        }
        catch (ConnectException ex){
            window.hide();
        }

        CorrectSymbols correctSymbols = new CorrectSymbols();
        for(Rectangle r: correctSymbols.getCorrectSymbols()) {
            layout.getChildren().add(r);
        }

        DrawField drawField = new DrawField(nameGoods);
        for (Rectangle[] r: drawField.getField()) {
            for (Rectangle r2: r) {
                layout.getChildren().add(r2);
            }
        }
        layout.getChildren().add(drawField.getName());

        Button confirm = new Button("Confirm");
        confirm.setLayoutX(500);
        confirm.setLayoutY(700);
        // переделать
        confirm.setOnAction(e -> {
            window.hide();
            connect.sendSymbol(new Symbol(drawField.getBox()));
            new Lobby();
        });
        layout.getChildren().add(confirm);

        window.setScene(scene);
        window.show();
    }

}
