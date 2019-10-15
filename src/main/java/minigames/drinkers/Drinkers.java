package minigames.drinkers;

import core.Playable;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import core.Lobby;

public class Drinkers implements Playable {

    private  Group layout;
    private  Scene scene;
    private  Stage stage;
    private static Drinking drinking = new Drinking();


    @Override
    public void play() {
        Label hint=new Label("First rectangle for drink| Second rectangle for pass");
        hint.setLayoutX(0);
        hint.setLayoutY(0);
        stage = new Stage();
        layout = new Group();
        scene = new Scene(layout, 600, 600);
        layout.getChildren().add(hint);
        layout.getChildren().addAll(drinking.playerDrunk,drinking.glass,drinking.leave,
                drinking.intoxicationBar,drinking.maxIntoxicationLevel,drinking.toDrink,drinking.toPass);

        scene.setOnMouseClicked(event -> {
                LeftMouseClick(event.getX(),event.getY());
        });

        stage.setScene(scene);
        stage.show();
    }


    public void LeftMouseClick(double x,double y){
        Point2D pointer =new Point2D(x,y);
        if(drinking.glass.contains(pointer)){
            drinking.drink();
        }else{
            if (drinking.leave.contains(pointer)){
                drinking.pass();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeight(300);
                alert.setTitle("Результат гри");
                alert.setHeaderText(drinking.npcDrunk.getText());
                alert.setContentText(drinking.status.getText());
                alert.showAndWait();
                stage.hide();
                new Lobby();
            }
        }
    }


}
