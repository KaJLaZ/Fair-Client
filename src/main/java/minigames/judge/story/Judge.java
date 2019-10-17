package minigames.judge.story;

import connection.ChooseFateConnection;
import connection.HitAppleConnection;
import core.Lobby;
import core.Playable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import minigames.judge.hitApple.LaunchHitApple;
import serverCore.Litigation;

public class Judge implements Playable {
    private Litigation litigation;
    private Stage stage;
    private Text personDescription;
    private Text faultDesc;
    private Text descPosChoice;
    private Text descNegChoice;
    private Group group;
    private Scene scene;
    private Button nextButton;
    private Button guilty;
    private Button forgive;
    private Button goAway;
    private Button throwApple;

    public void play() {
        initLitigation();
        initComponents();
        initStage();
        control();
    }

    private void initLitigation() {
        litigation = new ChooseFateConnection().getLitigationFromServer();
    }

    private void initComponents() {
        initTextAndButtons();
        group = new Group(personDescription, nextButton);
        scene = new Scene(group);
    }

    private void initTextAndButtons() {

        personDescription = new Text(litigation.getPersonDescription());
        setFeaturesOfTexts(personDescription);

        faultDesc = new Text(litigation.getFaultDesc());
        setFeaturesOfTexts(faultDesc);

        descPosChoice = new Text(litigation.getDescPosChoice());
        setFeaturesOfTexts(descPosChoice);

        descNegChoice = new Text(litigation.getDescNegChoice());
        setFeaturesOfTexts(descNegChoice);

        nextButton = new Button("Ok");
        nextButton.setLayoutX(350);
        nextButton.setLayoutY(300);

        forgive = new Button("Пробачити");
        forgive.setLayoutX(300);
        forgive.setLayoutY(300);

        guilty = new Button("Винний");
        guilty.setLayoutX(390);
        guilty.setLayoutY(300);

        goAway = new Button("Піти");
        goAway.setLayoutX(350);
        goAway.setLayoutY(300);

        throwApple = new Button("Кинути яблуко");
        throwApple.setLayoutX(350);
        throwApple.setLayoutY(300);

    }

    private void setFeaturesOfTexts(Text text) {
        text.setLayoutX(8);
        text.setLayoutY(20);
        text.setFont(Font.font("Verdana", 14));
    }

    private void initStage() {
        stage = new Stage();
        stage.setHeight(500);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.show();
    }

    private void control() {
        nextButton.setOnAction(event -> {
            group.getChildren().removeAll(personDescription, nextButton);
            group.getChildren().addAll(faultDesc, forgive, guilty);
        });
        forgive.setOnAction(event -> {
            group.getChildren().removeAll(faultDesc, forgive, guilty);
            group.getChildren().addAll(descNegChoice, goAway);
        });
        guilty.setOnAction(event -> {
            group.getChildren().removeAll(faultDesc, forgive, guilty);
            group.getChildren().add(descPosChoice);
            if (new HitAppleConnection().isHaveApple())
                group.getChildren().add(throwApple);
            else
                group.getChildren().add(goAway);

        });
        goAway.setOnAction(event -> {
            new ChooseFateConnection().forgivePrisoner();
            stage.hide();
            new Lobby();
        });
        throwApple.setOnAction(event -> {
            stage.hide();
            new LaunchHitApple();
        });
    }
}
