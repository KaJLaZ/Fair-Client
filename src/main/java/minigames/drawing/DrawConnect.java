package minigames.drawing;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DrawConnect {
    private ObjectMapper mapper;

    public DrawConnect() {
        mapper = new ObjectMapper();
    }

    public Box getBox() {
        try {
            URL url = new URL("http://localhost:8080/gameCommands/getBox");
            return mapper.readValue(url,Box.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
