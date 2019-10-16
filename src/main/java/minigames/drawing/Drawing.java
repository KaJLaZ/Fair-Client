package minigames.drawing;

import connection.DrawConnect;
import core.Playable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import core.Lobby;
import serverCore.GameRoot;
import serverCore.Symbol;

import java.net.ConnectException;

public class Drawing implements Playable {

    private Group layout;
    private Stage window;
    private Scene scene;
    private DrawConnect connect;
    private CorrectSymbols correctSymbols;
    private DrawField drawField;
    private Button confirm;

    private static final int WINDOW_WIDTH = 1125;
    private static final int WINDOW_HEIGHT = 800;
    private static int turns = GameRoot.AMOUNT_BOX_FOR_ONE_GAME;

    public Drawing(){
        layout = new Group();
        window = new Stage();
        scene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);
        connect = new DrawConnect();
        correctSymbols = new CorrectSymbols();
        for(Rectangle r: correctSymbols.getCorrectSymbols()) {
            layout.getChildren().add(r);
        }
        String nameGoods = new String();
        try {
            nameGoods = connect.getNameGoods();
        }
        catch (ConnectException ex){
            window.hide();
        }
        drawField = new DrawField(nameGoods);
        confirm = new Button("Confirm");
    }
    @Override
    public void play() {
        for (Rectangle[] r: drawField.getField()) {
            for (Rectangle r2: r) {
                layout.getChildren().add(r2);
            }
        }
        layout.getChildren().add(drawField.getName());
        confirm.setLayoutX(500);
        confirm.setLayoutY(700);
        confirm.setOnAction(e -> {
            window.hide();
            connect.sendSymbol(new Symbol(drawField.getBox()));
            if (turns > 0)
                getAnotherBox();
            else new Lobby();
        });
        layout.getChildren().add(confirm);

        window.setScene(scene);
        window.show();
    }

    private void getAnotherBox() {
        --turns;
        new Drawing().play();
    }
}
