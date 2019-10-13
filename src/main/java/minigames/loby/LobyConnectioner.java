package minigames.loby;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class LobyConnectioner {
    private static final String ADDRESS = "http://localhost:8080//gameCommands/getGame";
    private ObjectMapper mapper;
    private Game game;

    public LobyConnectioner(){
        getGameFromServer();
    }

    private void getGameFromServer(){
        try {
            mapper = new ObjectMapper();
            URL url = new URL(ADDRESS);
            game = mapper.readValue(url, Game.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Game getGame() {
        return game;
    }

}
