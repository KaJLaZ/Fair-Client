package minigames.drawing;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import lombok.Getter;

public class CorrectSymbols {

    private static final String[] PATHS = {"/CorrectSymbols/Standart.png", "/CorrectSymbols/Fragile.png", "/CorrectSymbols/Cold.png", "/CorrectSymbols/Warm.png", "/CorrectSymbols/Danger.png"};
    private static final String[] NAMES = {"Стандарт", "Крихкий", "Холод", "Тепло", "Небезпека"};
    private static final int HEIGHT = 150;
    private static final int WIDTH = 130;
    private static final int LABELHEIGHT = 20;

    @Getter
    private Rectangle[] correctSymbols;
    @Getter
    private Label[] correctNames;

    public CorrectSymbols() {
        correctSymbols = new Rectangle[5];
        correctNames = new Label[5];
        for (int i = 0; i < correctSymbols.length; ++i) {
            correctNames[i] = new Label(NAMES[i]);
            correctNames[i].setLayoutY(i * HEIGHT);

            correctSymbols[i] = new Rectangle();
            correctSymbols[i].setFill(new ImagePattern(new Image(PATHS[i])));
            correctSymbols[i].setLayoutY(i * HEIGHT + LABELHEIGHT);
            correctSymbols[i].setHeight(HEIGHT - LABELHEIGHT);
            correctSymbols[i].setWidth(WIDTH);
        }
    }
}
