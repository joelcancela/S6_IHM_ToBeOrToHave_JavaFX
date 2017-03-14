package polytech.si3.ihm.tobeortohave.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jehan on 08/03/2017.
 */
public class Shop {
    private String logoPath;
    private List<String> highlightedProductsPath;
    private String smallDescription;
    private String description;
    private String name;
    private List<String> productsType;
    private List<Category> category;
    private Point positionMap;

    public Shop(String logoPath, String smallDescription, String description, String name, List<String> productsType) {
        highlightedProductsPath = new ArrayList<String>();
        positionMap = new Point();
        this.logoPath = logoPath;
        this.smallDescription = smallDescription;
        this.description = description;
        this.name = name;
        this.productsType = productsType;
    }

    public Shop(String logoPath, String smallDescription, String description, String name) {
        positionMap = new Point();
        productsType = new ArrayList<String>();
        highlightedProductsPath = new ArrayList<String>();
        this.logoPath = logoPath;
        this.smallDescription = smallDescription;
        this.description = description;
        this.name = name;
    }

    public void addHighlightedProductPath(String highlightedProductPath) {
        highlightedProductsPath.add(highlightedProductPath);
    }

    public void addProductType(String productType) {
        productsType.add(productType);
    }

    public void setPositionMap(int x, int y){
        positionMap.setLocation(x, y);
    }

    public Point getPositionMap(){
        return positionMap;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public List<String> getHighlightedProductsPath() {
        return highlightedProductsPath;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<String> getProductsType() {
        return productsType;
    }
}
