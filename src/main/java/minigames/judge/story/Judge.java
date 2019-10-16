package minigames.judge.story;

import connection.ConnectionChooseFate;
import connection.ConnectionerOfHitApple;
import core.Playable;

import minigames.judge.hitApple.LaunchHitApple;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import core.Lobby;
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
    private static final boolean isGuilty = false;

    public void play() {
        initLitigation();
        initComponents();
        initStage();
        control();
    }

    private void initLitigation() {
        litigation = new ConnectionChooseFate().getLitigationFromServer();
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

        forgive = new Button("Forgive");
        forgive.setLayoutX(320);
        forgive.setLayoutY(300);

        guilty = new Button("Guilty");
        guilty.setLayoutX(380);
        guilty.setLayoutY(300);

        goAway = new Button("goAway");
        goAway.setLayoutX(350);
        goAway.setLayoutY(300);

        throwApple = new Button("throwApple");
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
            if (new ConnectionerOfHitApple().isHaveApple())
                group.getChildren().add(throwApple);
            else
                group.getChildren().add(goAway);

        });
        goAway.setOnAction(event -> {
            new ConnectionChooseFate().forgivePrisoner();
            stage.hide();
            new Lobby();
        });
        throwApple.setOnAction(event -> {
            stage.hide();
            new LaunchHitApple();
        });
    }
}
