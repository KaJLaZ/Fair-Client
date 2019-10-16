package connection;

import java.io.*;
import java.net.*;

public class Transfer {

    private final String ADDRESS = "http://localhost:8080/gameCommands/forgivePrisoner";

    public void sendResult() {
        StringBuffer content = new StringBuffer();
        try{
            URL url = new URL(ADDRESS);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null){
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
        }catch (MalformedURLException e){
            System.out.println("Malformed exception");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);

    }
}
