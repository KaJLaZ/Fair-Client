package connection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PredictionConnection {

    private static final String PATH = "http://localhost:8080/gameCommands";
    private static final String PREDICTIONER = PATH + "/prediction";
    private static final String CONSEQUENCE = PATH + "/getConsequence";
    private static final String IS_DRUNK = PATH + "/isDrunk";


    ObjectMapper mapper = new ObjectMapper();
    private String consequence;


    public String getConsequence() {
        if (getBoolFromServer(PREDICTIONER) == !getBoolFromServer(IS_DRUNK)) {
            consequence = getConsequenceFromServer();
        } else {
            consequence = "Ви занадто п'яні щоб бачити передбачення";
        }
        return consequence;
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

    public String getConsequenceFromServer() {
        StringBuffer content;
        try {
            URL url = new URL(CONSEQUENCE);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();
            return content.toString();

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
