package minigames.judge.story;

import core.Playable;
import minigames.judge.сontrol.Transfer;
import minigames.judge.hitApple.StageOfGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import minigames.judge.hitApple.StageOfGame;
import minigames.judge.сontrol.Transfer;

public class MainWindow implements Playable {
    private Litigation litigation;
    private Stage stage;
    private Text personDescription;
    private Text faultDesc;
    private Group group;
    private Scene scene;
    private Button nextButton;
    private Button throwApple;
    private Button forgive;
    private boolean choice;

    public MainWindow(){
        display();
    }
    @Override
    public void display(){
        initLitigation();
        initComponents();
        initStage();
        control();
    }

    private void initStage(){
        stage = new Stage();
        stage.setHeight(500);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.show();
    }
    private void initLitigation(){
        litigation = new Connectioner().getLitigation();
    }


    private void initComponents(){
        initTextAndButtons();
        group = new Group(personDescription, nextButton);
        scene = new Scene(group);
    }
    private void initTextAndButtons(){
        personDescription = new Text(litigation.getPersonDescription());
        setFeaturesOfTexts(personDescription);

        faultDesc = new Text(litigation.getFaultDesc());
        setFeaturesOfTexts(faultDesc);


        nextButton = new Button("Ok");
        nextButton.setLayoutX(350);
        nextButton.setLayoutY(300);

        forgive = new Button("Forgive");
        forgive.setLayoutX(320);
        forgive.setLayoutY(300);

        throwApple = new Button("Throw apple");
        throwApple.setLayoutX(380);
        throwApple.setLayoutY(300);

    }
    private void setFeaturesOfTexts(Text text){
        text.setLayoutX(8);
        text.setLayoutY(20);
        text.setFont(Font.font("Verdana", 14));
    }

    private void control(){
        nextButton.setOnAction(event -> {
            group.getChildren().removeAll(personDescription, nextButton);
            group.getChildren().addAll(faultDesc, forgive, throwApple);
        });

        forgive.setOnAction(event -> {
            choice = true;
            new Transfer().sendResult(choice);
            stage.hide();
        });
        throwApple.setOnAction(event -> {
            stage.hide();
            new StageOfGame();
        });
    }
}
