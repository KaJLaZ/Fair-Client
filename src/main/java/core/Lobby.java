package core;

import connection.LobbyConnection;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import minigames.appleTheft.AppleTheft;
import minigames.drawing.Drawing;
import minigames.drinkers.Drinkers;
import minigames.judge.story.Judge;
import minigames.prediction.Prediction;
import serverCore.GameRoot;

import java.util.ArrayList;
import java.util.Arrays;

public class Lobby {

    private ArrayList<Playable> games;
    private Stage stage;
    private Group group;
    private int numberOfGame;
    private String describe;
    private Text text;
    private Button nextGame;
    private GameRoot gameRoot;

    public Lobby() {
        init();
    }

    private void init() {
        initArrayGames();
        initGame();
        initTextAndButton();
        initGroup();
        initStage();
    }

    private void initArrayGames() {
        games = new ArrayList<>(Arrays.asList(
                new AppleTheft(), new Judge(), new Drawing(), new Drinkers(), new Prediction()));
    }

    private void initGame() {
        gameRoot = new LobbyConnection().getGameRoot();
        numberOfGame = gameRoot.getGame().getNumberOfGame();
        describe = gameRoot.getDescription();
    }

    private void initTextAndButton() {

        text = new Text(describe);
        text.setLayoutX(8);
        text.setLayoutY(20);
        text.setFont(Font.font("Verdana", 14));

        nextGame = new Button("Ok");
        nextGame.setLayoutX(350);
        nextGame.setLayoutY(300);
    }

    private void initGroup() {
        group = new Group();
        group.getChildren().addAll(text, nextGame);
    }

    private void initStage() {
        stage = new Stage();
        stage.setScene(new Scene(group));
        stage.show();
        control();
    }

    private void control() {
        nextGame.setOnAction(event -> {
            if (numberOfGame != 5)
                games.get(numberOfGame).play();
            stage.hide();
        });
    }

}
