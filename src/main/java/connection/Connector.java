package connection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Connector {

    private static final String PATH = "http://localhost:8080/gameCommands";
    private static final String PREDICTIONER = PATH+"/prediction";
    private static final String CONSEQUENCE = PATH+"/getConsequence";


    ObjectMapper mapper = new ObjectMapper();
    private String consequence;


    public String getConsequence(){
        if (getBoolFromServer(PREDICTIONER)) {
            consequence = "Ви занадто п'яні щоб бачити передбачення";
        }else{
            //взяти наслідок з сервера
        }
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

    public String getConsequenceFromServer() {
        try {
            URL url = new URL(CONSEQUENCE);
            consequence = mapper.readValue(url, String.class);

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
