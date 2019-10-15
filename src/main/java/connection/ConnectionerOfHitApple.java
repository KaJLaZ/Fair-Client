package connection;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionerOfHitApple {
    private ObjectMapper mapper;
    private URL url;
    private double x;
    private double y;


    private boolean isCatch;

    private final String ADDRESS = "http://localhost:8080/gameCommands/checkHit";


    public ConnectionerOfHitApple(double x, double y){
        this.x = x;
        this.y = y;
        sendCoordinateOfShut();
    }

    private void sendCoordinateOfShut(){
        mapper = new ObjectMapper();
        StringBuffer content = new StringBuffer();
        try{
            url = new URL(ADDRESS);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            String urlParameters ="x=" + x + "&y=" + y;
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(urlParameters);
            out.flush();
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            in.close();
            con.disconnect();
        }catch (MalformedURLException e){
            System.out.println("Malformed exception");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }

    public boolean isCatch() {
        return isCatch;
    }


}
