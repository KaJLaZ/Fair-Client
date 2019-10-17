package connection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HitAppleConnection {
    private static final String ADDRESS = "http://localhost:8080/gameCommands/checkHit";
    private ObjectMapper mapper;
    private URL url;

    public void sendCoordinateOfShut(double x, double y) {
        mapper = new ObjectMapper();
        StringBuffer content = new StringBuffer();
        try {
            url = new URL(ADDRESS);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            String urlParameters = "x=" + x + "&y=" + y;
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(urlParameters);
            out.flush();
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Malformed exception");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }

    public boolean isHaveApple() {
        String address = "http://localhost:8080/gameCommands/hasApple";
        mapper = new ObjectMapper();
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

}
