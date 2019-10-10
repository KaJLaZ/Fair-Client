package minigames.drinkers;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Drinking {

    private static Connector connector=new Connector();

    Label npcDrunk;
    Label playerDrunk;
    Label status;

    public Drinking() {
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
        status.setText(connector.getWinner());
    }
}
