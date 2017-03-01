package polytech.si3.ihm.tobeortohave.model;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.InputStream;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class JSONReader {

    public JSONReader() {

        JSONParser parser = new JSONParser();

        try {
            InputStream is = getClass().getResourceAsStream("json/common.json");

            Object obj = parser.parse(String.valueOf(is));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
