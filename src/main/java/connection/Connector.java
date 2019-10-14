package connection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Connector {

    private static final String PATH = "http://localhost:8080/gameCommands/getConsequence";

    ObjectMapper mapper = new ObjectMapper();
    private String consequence;


    public String getConsequence(){

        
         consequence = "Ви занадто п'яні щоб бачити передбачення";

        return consequence;
    }

    public String getConsequenceFromServer() {
        try {
            URL url = new URL(PATH);
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
