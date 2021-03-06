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
import java.util.stream.Collectors;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class JSONReader {

    JSONObject jsonObject;

    private List<String> keywords;
    private List<Field> fields;
    private List<Brand> brands;
    private List<Product> products;
    private List<Store> stores;


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
        JSONArray jsonArray = jsonObject.getJSONArray("stores");
        stores = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int id = jsonObject.getInt("id");
            int brandIndex = jsonObject.getInt("brand");
            Brand currentBrand = brands.get(brandIndex);
            String description = jsonObject.getString("description");
            String address = jsonObject.getString("address");
            double latitude = jsonObject.getDouble("latitude");
            double longitude = jsonObject.getDouble("longitude");
            List<Product> productList = new ArrayList<>();
            JSONArray stock = jsonObject.getJSONArray("stock");
            for (int j = 0; j < stock.length(); j++) {
                productList.add(products.get(stock.getInt(j)));
            }
            String phone = jsonObject.getString("phone");
            String webAddress = jsonObject.getString("webAddress");
            List<Double> CA = new ArrayList<>();
            JSONArray CAArray = jsonObject.getJSONArray("CA");
            for (int j = 0; j < CAArray.length(); j++) {
                CA.add(CAArray.getDouble(j));
            }

            stores.add(new Store(currentBrand, description, address, latitude, longitude, productList, phone, webAddress, CA, id));

        }

        //System.out.println("ALL MAGASINS");
        //System.out.println(stores);
    }

    private void parseProducts() {
        JSONArray jsonArray = jsonObject.getJSONArray("products");
        products = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            int id = jsonObject.getInt("id");
            List<String> keywordsList = new ArrayList<>();
            JSONArray keywordsArray = jsonObject.getJSONArray("keywords");
            for (int j = 0; j < keywordsArray.length(); j++) {
                keywordsList.add(keywords.get(keywordsArray.getInt(j)));
            }
            boolean starred = jsonObject.getBoolean("starred");
            boolean discounted = jsonObject.getBoolean("discounted");
            double discountRate = jsonObject.getDouble("discountRate");
            double price = jsonObject.getDouble("price");
            String picturePath = jsonObject.getString("picture");
            int salesNumber = jsonObject.getInt("salesNumber");
            String description = jsonObject.getString("description");

            products.add(new Product(id, name, keywordsList, starred, discounted, discountRate, price, picturePath, salesNumber,description));
        }

        //System.out.println("ALL PRODUCTS");
        //System.out.println(products);

    }

    private void parseBrands() {
        JSONArray jsonArray = jsonObject.getJSONArray("brands");
        brands = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            String logo = jsonObject.getString("logo");
            List<Field> fieldList = new ArrayList<>();
            JSONArray fieldsArray = jsonArray.getJSONObject(i).getJSONArray("fields");
            for (int j = 0; j < fieldsArray.length(); j++) {
                fieldList.add(fields.get(fieldsArray.getInt(j)));
            }
            String description = jsonObject.getString("description");
            String phone = jsonObject.getString("phone");
            String webAddress = jsonObject.getString("webAddress");
            brands.add(new Brand(name, logo, fieldList, description, phone, webAddress));
        }


        //System.out.println("ALL BRANDS");
        //System.out.println(brands);
    }

    private void parseKeywords() {
        JSONArray jsonArray = jsonObject.getJSONArray("keywords");
        keywords = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            keywords.add(jsonObject.getString("name"));
        }

        //System.out.println("ALL KEYWORDS");
        //System.out.println(keywords);

    }

    private void parseFields() {
        JSONArray jsonArray = jsonObject.getJSONArray("fields");
        fields = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            List<String> keywords = new ArrayList<>();
            JSONObject currentField = jsonArray.getJSONObject(i);
            String name = currentField.getString("name");
            JSONArray innerArray = currentField.getJSONArray("keywords");
            for (int j = 0; j < innerArray.length(); j++) {
                keywords.add(this.keywords.get(innerArray.getInt(j)));
            }
            fields.add(new Field(name, keywords));
        }
        //System.out.println("ALL FIELDS");
        //System.out.println(fields);
    }


    private String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Field> getBrandCategory(int id){ return brands.get(id).getFieldList();}

    public List<Product> getRealProducts() {
        return products.stream().filter(p -> p.getId() < 14).collect(Collectors.toList());
    }

    public List<Product> getDiscountedProducts() {
        return getRealProducts().stream().filter(p -> p.isDiscounted()).collect(Collectors.toList());
    }

    public List<Product> getDiscountedProductsForAStore(int i) {
        return getStoresById(8).getStock().stream().filter(p -> p.isDiscounted()).collect(Collectors.toList());
    }

    public List<Product> getStarredProducts() {
        return getRealProducts().stream().filter(p -> p.isStarred()).collect(Collectors.toList());
    }

    public List<Store> getStores() {
        return stores;
    }

    public Store getStoresById (int id) {
        for (Store store : stores) {
            if (store.getId() == id)
                return store;
        }
        return null;
    }

    public List<Store> getNiceStores() {
        List<Store> niceStores = new ArrayList<>();
        for(Store store : stores){
            if(store.getAddress().equals("NICE"))
                niceStores.add(store);
        }
        return niceStores;
    }
}
