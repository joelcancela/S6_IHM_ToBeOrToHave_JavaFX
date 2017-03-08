package polytech.si3.ihm.tobeortohave.model;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class JSONReader {

    JSONObject jsonObject;
    private List<String> keywords;
    private List<Field> fields;


    public JSONReader() {
    }

    public void parse() {

        try {

            String jsonPath = "common/src/main/resources/json/database.json";
            String content = readFile(jsonPath, StandardCharsets.UTF_8);

            jsonObject = new JSONObject(content);


        } catch (Exception e) {
            e.printStackTrace();
        }


        parseKeywords();
        parseFields();
        parseBrands();
        parseProducts();
        parseStores();

    }

    private void parseStores() {
    }

    private void parseProducts() {
    }

    private void parseBrands() {
    }

    private void parseKeywords() {
        JSONArray jsonArray = jsonObject.getJSONArray("keywords");
        keywords = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            keywords.add(jsonObject.getString("label"));
        }

        System.out.println("ALL KEYWORDS");
        System.out.println(keywords);

    }

    private void parseFields() {
        JSONArray jsonArray = jsonObject.getJSONArray("fields");
        fields = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            List<String> keywords = new ArrayList<>();
            JSONObject currentField = jsonArray.getJSONObject(i);
            String name = currentField.getString("label");
            JSONArray innerArray = currentField.getJSONArray("keywords");
            for (int j = 0; j < innerArray.length(); j++) {
                keywords.add(this.keywords.get(j));
            }
            fields.add(new Field(name,keywords));
        }
        System.out.println("ALL FIELDS");
        System.out.println(fields);
    }


    private String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
