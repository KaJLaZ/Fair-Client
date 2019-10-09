package minigames.drinkers;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class Drinking {

    private static Connector connector = new Connector();
    private static final String GLASS="/Glass.png";
    private static final String DOOR="/Door.png";

    Image imgGlass ;
    ImageView glass ;
    Image imgDoor ;
    ImageView door;
    Label npcDrunk;
    Label playerDrunk;
    Label status;

    public Drinking() {
        imgGlass=new Image(GLASS);
        glass=new ImageView();

        playerDrunk=new Label();
        playerDrunk.setLayoutX(400);
        playerDrunk.setLayoutY(330);
        playerDrunk.setFont(new Font("Times New Roman",30));

        npcDrunk=new Label();
        npcDrunk.setLayoutX(400);
        npcDrunk.setLayoutY(330);
        npcDrunk.setFont(new Font("Times New Roman",30));

        status=new Label();
        status.setLayoutX(400);
        status.setLayoutY(400);
        status.setFont(new Font("Times New Roman",30));


        glass.setImage(imgGlass);
        imgDoor=new Image(DOOR);
        door=new ImageView();
        door.setImage(imgDoor);
        door.setFitHeight(300);
        door.setFitWidth(200);
        glass.setFitHeight(300);
        glass.setFitWidth(200);
        door.setX(500);
        playerDrunk.setLayoutX(10);
        playerDrunk.setLayoutY(400);

    }

    public void drink(){
        connector.drink();
        playerDrunk.setText("Your intoxication : "+connector.getPlayerIntoxication());
    }

    public void pass(){
        connector.pass();
        npcDrunk.setText("Opponent's intoxication : "+connector.getNpcIntoxication());
        if (connector.isWon()){
            status.setText("You have won");
        }else{
            status.setText("You have lost");
        }



    }

    private void showInfoWhenGameEnded() {
        if(connector.isEndGame()) {
            if(connector.isWon()) {
                InformationWindow.display("You Won!");
            }
            else {
                InformationWindow.display("You lose(");
            }
        }
    }

}
