import core.Day;
import core.Playable;
import minigames.drawing.BoxDrawWindow;
import minigames.drinkers.MainDisplay;
import minigames.garden.MainWindow;

public class Play {
    public static void Play(){
        Day day = new Day();

        Playable[] game = {new MainDisplay(), new MainWindow(), new BoxDrawWindow()};

        try {
            day.startDay();
        }
       catch (Exception ex){
            System.out.println(ex.getMessage());
       }
    }
}
