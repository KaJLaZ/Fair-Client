package minigames.prediction;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Prediction {

    private static final String PATH = "http://localhost:8080/gameCommands";
    private static final String CONSEQUENCE = PATH + "/getConsequence";
    private static final String PREDICTIONER = PATH+"/prediction";

    ObjectMapper mapper =new ObjectMapper();
    private String consequence ;


    public String getConsequence(){

        
         consequence="Ви занадто п'яні щоб бачити передбачення";

        return consequence;
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

    public String getStringFromServer(String string) {
        try {
            URL url = new URL(string);
            consequence=mapper.readValue(url,String.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consequence;
    }
}
