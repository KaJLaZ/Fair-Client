package minigames.drinkers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Connector {

    private static final String PATH = "http://localhost:8080";
    private static final String DRINK = PATH+"/drink";
    private static final String PASS = PATH+"/pass";
    private static final String PREDICTIONER = PATH+"/prediction";
    private static final String WINNER = PATH+"/winner";

    private int playerIntoxication;
    private int npcIntoxication;
    private int[] stats;
    private boolean endGame;

    private static ObjectMapper mapper = new ObjectMapper();


    private int[] getStatsFromServer(String string){
        try {
            URL url =new URL(string);
            return mapper.readValue(url,int[].class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stats;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public int[] drink(){
        stats=getStatsFromServer(DRINK);
        return stats;
    }

    public int[] pass(){
        stats=getStatsFromServer(PASS);
        endGame=true;
        return stats;
    }

    public int getNpcIntoxication(){
        npcIntoxication=stats[1];
        return npcIntoxication;
    }

    public int getPlayerIntoxication(){
        playerIntoxication=stats[0];
        return playerIntoxication;
    }

    public boolean getIsAbleToSeePrediction(){
        return getBoolFromServer(PREDICTIONER);
    }

    public boolean isWon() {
        return getBoolFromServer(WINNER);
    }


    private boolean getBoolFromServer(String address) {
        try {
            URL url = new URL(address);
            return mapper.readValue(url,boolean.class);
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
}
