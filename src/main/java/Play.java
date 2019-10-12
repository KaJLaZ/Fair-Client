import core.Day;
import core.Playable;
import javafx.application.Application;
import minigames.drawing.BoxDrawWindow;
import minigames.drinkers.MainDisplay;
import minigames.judge.story.MainWindow;

import java.util.ArrayList;

public class Play {
    public static void Play(){
        ArrayList<Playable> games = new ArrayList<>();
        games.add(new MainWindow());
        games.add(new MainDisplay());
        Day day = new Day(games);

        day.startDay();
    }
}
