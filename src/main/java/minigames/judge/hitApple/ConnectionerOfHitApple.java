package minigames.judge.hitApple;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionerOfHitApple {
    double coordX;
    double coordY;
    private ObjectMapper mapper;
    private URL url;


    private boolean isCatch;

    private final String ADDRESS = "http://localhost:8080/gameCommands/setSequence";


    public ConnectionerOfHitApple(double coordX, double coordY){
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public void sendCoordinateOfShut(){
        StringBuffer content = new StringBuffer();
        try{
            url = new URL(ADDRESS);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            String urlParameters = "x=" + coordX + "&y=" + coordY;
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(urlParameters);
            out.flush();
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            isCatch = getResultFromServer();
            in.close();
            con.disconnect();
        }catch (MalformedURLException e){
            System.out.println("Malformed exception");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }

    public boolean getResultFromServer(){
        try {
            mapper = new ObjectMapper();
            Boolean result = mapper.readValue(url, Boolean.class);
            return result.booleanValue();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isCatch() {
        return isCatch;
    }


}
