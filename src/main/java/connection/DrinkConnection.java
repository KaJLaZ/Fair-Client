package connection;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class DrinkConnection {

    private static final String PATH = "http://localhost:8080/gameCommands";
    private static final String DRINK = PATH + "/drink";
    private static final String PASS = PATH + "/pass";
    private static final String PREDICTIONER = PATH + "/prediction";
    private static final String WINNER = PATH + "/winner";
    private static ObjectMapper mapper = new ObjectMapper();
    private int playerIntoxication;
    private int npcIntoxication;
    private int[] stats;
    private boolean endGame;
    private String winner;

    private int[] getStatsFromServer(String string) {
        try {
            URL url = new URL(string);
            return mapper.readValue(url, int[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stats;
    }

    public int[] drink() {
        stats = getStatsFromServer(DRINK);
        return stats;
    }

    public int[] pass() {
        stats = getStatsFromServer(PASS);
        endGame = true;
        return stats;
    }

    public int getNpcIntoxication() {
        npcIntoxication = stats[1];
        return npcIntoxication;
    }

    public int getPlayerIntoxication() {
        playerIntoxication = stats[0];
        return playerIntoxication;
    }

    public String getWinner() {
        winner = getStringFromServer(WINNER);
        return winner;
    }

    public String getStringFromServer(String string) {
        try {
            URL url = new URL(string);
            winner = mapper.readValue(url, String.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return winner;
    }
}
