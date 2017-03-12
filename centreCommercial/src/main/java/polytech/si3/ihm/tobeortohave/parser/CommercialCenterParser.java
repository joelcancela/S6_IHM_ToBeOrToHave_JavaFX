package polytech.si3.ihm.tobeortohave.parser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Jehan on 12/03/2017.
 */
public class CommercialCenterParser {

    JSONObject jsonObject;
    Map<String, Double> visitorsPerYear;
    Map<String, Integer> visitorsProfile;
    Map<String, Integer> visitorsAge;

    public CommercialCenterParser() {
        visitorsPerYear = new TreeMap<>();
        visitorsProfile = new TreeMap<>();
        visitorsAge = new TreeMap<>();
        parse();
    }

    public void parse() {

        try {

            String jsonPath = "centreCommercial/src/main/resources/json/centreData.json";
            String content = readFile(jsonPath, StandardCharsets.UTF_8);

            jsonObject = new JSONObject(content);


        } catch (Exception e) {
            e.printStackTrace();
        }

        parseVisitorsPerYear();
        parseVisitorsProfile();
        parseVisitorsAge();
    }

    private void parseVisitorsPerYear(){
        JSONArray jsonArray = jsonObject.getJSONArray("visitorsPerYear");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject visitorPerYear = jsonArray.getJSONObject(i);
            String year = visitorPerYear.getString("year");
            Double visitors = visitorPerYear.getDouble("visitors");
            visitorsPerYear.put(year, visitors);
        }
    }

    private void parseVisitorsProfile(){
        JSONArray jsonArray = jsonObject.getJSONArray("visitorsProfile");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject visitorsProfiles = jsonArray.getJSONObject(i);
            String year = visitorsProfiles.getString("label");
            Integer visitors = visitorsProfiles.getInt("percentage");
            this.visitorsProfile.put(year, visitors);
        }
    }

    private void parseVisitorsAge(){
        JSONArray jsonArray = jsonObject.getJSONArray("visitorsAge");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject visitorsAge = jsonArray.getJSONObject(i);
            String year = visitorsAge.getString("label");
            Integer visitors = visitorsAge.getInt("percentage");
            this.visitorsAge.put(year, visitors);
        }
    }

    private String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public Map<String, Double> getVisitorsPerYear() {
        return visitorsPerYear;
    }

    public Map<String, Integer> getVisitorsProfile() {
        return visitorsProfile;
    }

    public Map<String, Integer> getVisitorsAge() {
        return visitorsAge;
    }
}



