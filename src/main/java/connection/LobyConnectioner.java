package connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import serverCore.Game;

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
            System.out.println("d");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Game getGame() {
        return game;
    }

}
