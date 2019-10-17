package minigames.drinkers;

import connection.DrinkConnection;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import lombok.Getter;

@Getter
public class Drinking {

    private static final Image imgGlass = new Image("/Drinking/Glass.jpg");
    private static final Image imgDoor = new Image("/Drinking/Door.png");
    private static DrinkConnection connect = new DrinkConnection();
    private Label npcDrunk;
    private Label playerDrunk;
    private Label status;
    private javafx.scene.shape.Rectangle glass;
    private javafx.scene.shape.Rectangle leave;
    private javafx.scene.shape.Rectangle intoxicationBar;
    private double lastIntoxication = 0;
    private double delta = 0;
    private Label maxIntoxicationLevel;
    private Label toDrink;
    private Label toPass;


    public Drinking() {

        glass = new javafx.scene.shape.Rectangle(10, 70, 200, 270);
        glass.setFill(new ImagePattern(imgGlass));
        leave = new javafx.scene.shape.Rectangle(250, 70, 150, 300);
        leave.setFill(new ImagePattern(imgDoor));

        toDrink = new Label("Випити");
        toPass = new Label("Спасувати");
        toDrink.setLayoutX(70);
        toDrink.setLayoutY(300);
        toDrink.setFont(new Font(20));


        toPass.setLayoutX(285);
        toPass.setLayoutY(370);
        toPass.setFont(new Font(20));

        intoxicationBar = new javafx.scene.shape.Rectangle(450, 400, 60, 0);
        maxIntoxicationLevel = new Label("П'яний");
        maxIntoxicationLevel.setTextFill(Color.BLACK);
        maxIntoxicationLevel.setFont(new Font("Times New Roman", 20));
        maxIntoxicationLevel.setLayoutX(450);
        maxIntoxicationLevel.setLayoutY(65);

        playerDrunk = new Label();
        playerDrunk.setLayoutX(10);
        playerDrunk.setLayoutY(350);
        playerDrunk.setFont(new Font("Times New Roman", 30));

        npcDrunk = new Label();
        npcDrunk.setLayoutX(400);
        npcDrunk.setLayoutY(330);
        npcDrunk.setFont(new Font("Times New Roman", 30));

        status = new Label();
        status.setLayoutX(401);
        status.setLayoutY(400);
        status.setFont(new Font("Times New Roman", 30));
    }


    public void drink() {

        connect.drink();
        paintColorBar();
        intoxicationBar.setHeight(connect.getPlayerIntoxication() / 3);
        delta = intoxicationBar.getHeight() - lastIntoxication;
        intoxicationBar.setY(intoxicationBar.getY() - delta);
        lastIntoxication = intoxicationBar.getHeight();
        playerDrunk.setText("Ваш рівень сп'яніння : " + connect.getPlayerIntoxication());
    }

    public void paintColorBar() {
        if (intoxicationBar.getHeight() < 500 / 4) {
            intoxicationBar.setFill(Color.GREEN);
        } else if (intoxicationBar.getHeight() < 1000 / 4.5) {
            intoxicationBar.setFill(Color.YELLOW);
        } else {
            intoxicationBar.setFill(Color.RED);
        }
    }

    public void pass() {
        connect.pass();

        npcDrunk.setText("Рівень сп'яніння оппонента : " + connect.getNpcIntoxication());
        status.setText(connect.getWinner());
    }
}
