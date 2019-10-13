import core.Day;
import core.Playable;
import minigames.drinkers.MainDisplay;
import minigames.judge.story.Judge;

import java.util.ArrayList;

public class Play {
	public static void Play(){
		ArrayList<Playable> games = new ArrayList<>();
		games.add(new Judge());
		games.add(new MainDisplay());
		Day day = new Day(games);

		day.startDay();
	}
}