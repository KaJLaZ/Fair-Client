package connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import serverCore.Litigation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ChooseFateConnection {

    private static final String ADDRESS_GET_LITIGATION = "http://localhost:8080/gameCommands/getLigation";
    private final String ADDRESS_SEND_RESULT = "http://localhost:8080/gameCommands/forgivePrisoner";

    private ObjectMapper mapper;

    public Litigation getLitigationFromServer() {
        try {
            mapper = new ObjectMapper();
            URL url = new URL(ADDRESS_GET_LITIGATION);
            return mapper.readValue(url, Litigation.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Litigation();
        }
    }

    public void forgivePrisoner() {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(ADDRESS_SEND_RESULT);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Malformed exception");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);

    }


}
