package core;

import javafx.application.Application;
import javafx.stage.Stage;

public class Day {
    private Application[] games;

    private GameContext context;

    public Day(Application[] games, GameContext context) {
        this.games = games;
        this.context = context;
    }

    public void startDay() throws Exception{
        games[2].start(new Stage());
    }
}
