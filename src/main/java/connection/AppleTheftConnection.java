package connection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppleTheftConnection {
    private static final String PATH = "http://localhost:8080/gameCommands/";
    private static final String ARRAY = PATH + "array";
    private static final String UP = PATH + "up";
    private static final String DOWN = PATH + "down";
    private static final String LEFT = PATH + "left";
    private static final String RIGHT = PATH + "right";
    private static final String END = PATH + "end";
    private static final String WiN = PATH + "win";

    private static ObjectMapper mapper = new ObjectMapper();

    @Getter
    private int[][] map;

    public int[][] getArray() {
        map = getMapFromServer(ARRAY);
        return map;
    }

    public int[][] up() {
        map = getMapFromServer(UP);
        return map;
    }

    public int[][] down() {
        map = getMapFromServer(DOWN);
        return map;
    }

    public int[][] left() {
        map = getMapFromServer(LEFT);
        return map;
    }

    public int[][] right() {
        map = getMapFromServer(RIGHT);
        return map;
    }

    public boolean isGameEnded() {
        return getBoolFromServer(END);
    }

    public boolean isWon() {
        return getBoolFromServer(WiN);
    }

    private int[][] getMapFromServer(String address) {
        try {
            URL url = new URL(address);
            return mapper.readValue(url, int[][].class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private boolean getBoolFromServer(String address) {
        try {
            URL url = new URL(address);
            return mapper.readValue(url, boolean.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void print() {
        String message = new String();
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                message = message + " " + map[i][j];
            }
            message = message + "\n";
        }
        System.out.println(message);
    }
}
