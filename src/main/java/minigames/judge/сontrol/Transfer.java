package minigames.judge.сontrol;

import java.io.*;
import java.net.*;

public class Transfer {

    private final String ADDRESS = "http://localhost:8080/gameCommands/setSequence";

    public void sendResult(boolean result) {
        StringBuffer content = new StringBuffer();
        //Box box = new Box();
        try{
            URL url = new URL(ADDRESS);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            String urlParameters = "choice=true";
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(urlParameters);
            out.flush();
            out.close();
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
