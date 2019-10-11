import core.Day;
import core.Playable;
import minigames.drawing.BoxDrawWindow;
import minigames.drinkers.MainDisplay;
import minigames.judge.story.MainWindow;

import java.util.ArrayList;

public class Play {
    public static void Play(){
        ArrayList<Playable> games = new ArrayList<>();
        games.add(new MainWindow());

        Day day = new Day(games);

        try {
            day.startDay();
        }
       catch (Exception ex){
            System.out.println(ex.getMessage());
       }
    }
}
