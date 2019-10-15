package minigames.drinkers;

import connection.Connect;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.awt.*;

public class Drinking {

    private static Connect connect =new Connect();

    Label npcDrunk;
    Label playerDrunk;
    Label status;
    javafx.scene.shape.Rectangle glass;
    javafx.scene.shape.Rectangle leave;
    javafx.scene.shape.Rectangle intoxicationBar;
    double barY=400;
    Label maxIntoxicationLevel;
    Label toDrink;
    Label toPass;


    public Drinking() {

        glass= new javafx.scene.shape.Rectangle(10,40,100,100);
        leave= new javafx.scene.shape.Rectangle(250,40,100,100);
        toDrink=new Label("Випити");
        toPass=new Label("Спасувати");
        toDrink.setLayoutX(20);
        toDrink.setLayoutY(145);

        toPass.setLayoutX(250);
        toPass.setLayoutY(145);

        intoxicationBar= new javafx.scene.shape.Rectangle(450,100,50,10);
        maxIntoxicationLevel = new Label("1000");
        maxIntoxicationLevel.setFont(new Font("Times New Roman",20));
        maxIntoxicationLevel.setLayoutX(450);
        maxIntoxicationLevel.setLayoutY(410);

        playerDrunk=new Label();
        playerDrunk.setLayoutX(10);
        playerDrunk.setLayoutY(350);
        playerDrunk.setFont(new Font("Times New Roman",30));

        npcDrunk=new Label();
        npcDrunk.setLayoutX(400);
        npcDrunk.setLayoutY(330);
        npcDrunk.setFont(new Font("Times New Roman",30));

        status=new Label();
        status.setLayoutX(400);
        status.setLayoutY(400);
        status.setFont(new Font("Times New Roman",30));
    }


    public void drink(){

        connect.drink();
        intoxicationBar.setHeight(connect.getPlayerIntoxication()/3);
        /*latIntoxicationLevel=intoxicationBar.getHeight();
        intoxicationBar.setY(barY-latIntoxicationLevel);
        barY=intoxicationBar.getY();*/

        playerDrunk.setText("Ваш рівень сп'яніння : "+ connect.getPlayerIntoxication());
    }

    public void pass(){
        connect.pass();
        npcDrunk.setText("Рівень сп'яніння оппонента : "+ connect.getNpcIntoxication());
        status.setText(connect.getWinner());
    }
}
