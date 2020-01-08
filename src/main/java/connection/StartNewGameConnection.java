package connection;

import java.io.IOException;
import java.net.URL;

public class StartNewGameConnection {
    private static final String ADDRESS = "http://localhost:8080/gameCommands/startNewGame";

    public void startNewGame() {
        try {
            URL url = new URL(ADDRESS);
            url.openConnection().connect();
            url.getContent();
        } catch (IOException e) {
            String message = e.getMessage();

            if(!message.equals("no content-type"))
                System.out.println(message);
        }

    }
}



