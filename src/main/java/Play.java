import core.Day;
import core.GameContext;
import javafx.application.Application;
import minigames.drawing.Drawing;
import minigames.drinkers.Drinkers;
import minigames.garden.Gardens;
import minigames.judge.Judge;

public class Play {
    public static void Play(){
        GameContext context = new GameContext();
        Application[] games = new Application[4];
        games[0] = new Drawing();
        games[1] = new Drinkers();
        games[2] = new Gardens();
        games[3] = new Judge();
        Day day = new Day(games, context);

        try {
            day.startDay();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
