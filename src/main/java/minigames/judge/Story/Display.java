package Story;

import Control.Transfer;
import HitApple.StageOfGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display {
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
    public Display(){
        initStage();
    }

    private void initStage(){
        litigation = new Litigation("Person Description",
                "faultDesc", "descPosChoice", "descNegChoice");
        initComponents();
        stage = new Stage();
        stage.setHeight(500);
        stage.setWidth(800);
        stage.setScene(scene);
        control();
        stage.show();
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
//comment
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
