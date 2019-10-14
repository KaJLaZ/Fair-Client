package connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import serverCore.Litigation;

import java.io.IOException;
import java.net.URL;

public class Connectioner {
    private static final String ADDRESS = "http://localhost:8080/gameCommands/getLigation";
    private ObjectMapper mapper;
    private Litigation litigation;

    public Connectioner(){
        getLitigationFromServer();
    }

    private void getLitigationFromServer(){
        try {
            mapper = new ObjectMapper();
            URL url = new URL(ADDRESS);
            litigation = mapper.readValue(url, Litigation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Litigation getLitigation() {
        return litigation;
    }



}
