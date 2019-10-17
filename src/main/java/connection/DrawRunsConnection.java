package connection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import serverCore.Symbol;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DrawRunsConnection {
    String path;
    private ObjectMapper mapper;

    public DrawRunsConnection() {
        mapper = new ObjectMapper();
    }

    public String getNameGoods() throws ConnectException {
        try {
            String nameGoods = "";
            URL url = new URL("http://localhost:8080/gameCommands/getNameGoods");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            nameGoods = in.readLine();
            in.close();
            con.disconnect();
            return nameGoods;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new ConnectException();
        } catch (JsonParseException e) {
            e.printStackTrace();
            throw new ConnectException();
        } catch (JsonMappingException e) {
            e.printStackTrace();
            throw new ConnectException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConnectException();
        }
    }

    public void sendSymbol(Symbol symbol) {
        StringBuffer content;
        try {
            URL url = new URL("http://localhost:8080/gameCommands/checkSymbol");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            String urlParameters = "appearance=" + mapper.writeValueAsString(transformAppearance(symbol.getAppearance()));
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(urlParameters);
            out.flush();
            out.close();
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
    }

    private String[][] transformAppearance(boolean[][] appearance) {
        String[][] newAppearance = new String[Symbol.AMOUNT_ROWS][Symbol.AMOUNT_COLUMNS];

        for (int i = 0; i < Symbol.AMOUNT_ROWS; i++) {
            for (int j = 0; j < Symbol.AMOUNT_COLUMNS; j++) {
                newAppearance[i][j] = String.valueOf(appearance[i][j]);
            }
        }

        return newAppearance;
    }
}
