package connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import serverCore.GameRoot;

import java.io.IOException;
import java.net.URL;

public class LobbyConnection {
    private static final String ADDRESS = "http://localhost:8080//gameCommands/getGame";
    private ObjectMapper mapper;
    private GameRoot gameRoot;

    public LobbyConnection() {
        getGameFromServer();
    }

    private void getGameFromServer() {
        try {
            mapper = new ObjectMapper();
            URL url = new URL(ADDRESS);
            gameRoot = mapper.readValue(url, GameRoot.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public GameRoot getGameRoot() {
        return gameRoot;
    }

}
