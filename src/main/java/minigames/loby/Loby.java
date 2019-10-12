package minigames.loby;

import core.Playable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import minigames.drinkers.MainDisplay;
import minigames.judge.story.MainWindow;

import java.util.ArrayList;

public class Loby {

    private ArrayList<Playable> games = new ArrayList<>();
    Stage stage;
    Group group;
    int num; // number of game, will get it from server
    String describe; // describe of the next game, will get it from server
    Text text;
    Button nextGame;

    public Loby(){
        init();
    }

    private void init() {
        games.add(new MainWindow());
        games.add(new MainDisplay());
        stage = new Stage();
        num = 0;
        describe = "Teeeeeeeeeeeeeeeeeeexxxxxxxxxxxxxxxxttttttttttttt";
        group = new Group();
        text = new Text(describe);

        nextGame = new Button("Ok");
        nextGame.setLayoutX(350);
        nextGame.setLayoutY(300);

        text.setLayoutX(8);
        text.setLayoutY(20);
        text.setFont(Font.font("Verdana", 14));

        group.getChildren().addAll(text, nextGame);
        stage.setScene(new Scene(group));

        stage.show();
        control();

    }
    public void control(){
        nextGame.setOnAction(event -> {
            games.get(num).display();
            stage.hide();
        });
    }

}
