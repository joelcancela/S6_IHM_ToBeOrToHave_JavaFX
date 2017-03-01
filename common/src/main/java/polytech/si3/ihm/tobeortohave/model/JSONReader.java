package polytech.si3.ihm.tobeortohave.model;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class JSONReader {

    public JSONReader(){
    }

    public void parse(){
        JSONParser parser = new JSONParser();

        try {
            String jsonPath = "common/src/main/resources/json/common.json";

            Object obj = parser.parse(new FileReader(jsonPath));

            JSONObject jsonObject = (JSONObject) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
