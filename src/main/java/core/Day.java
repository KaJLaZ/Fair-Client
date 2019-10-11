package core;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collection;

public class Day {
    private ArrayList<Playable> games;

    public void addGame(@NonNull Playable game){
        games.add(game);
    }

    public void addGames(@NonNull Collection<Playable> games){
        for(Playable i : games){
            if(i == null)
                throw new NullPointerException("one of Collections element is null");
        }
        this.games.addAll(games);
    }

    public void startDay() throws Exception{
        for (Playable i: games)
            i.display();
    }
}
