package polytech.si3.ihm.tobeortohave.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jehan on 08/03/2017.
 */
public class CommercialCenter {
    private String name;
    private String description;
    private String mapPath;
    private List<Shop> shopList;
    private List<Shop> highlightedshopList;
    private List<String> events;

    public CommercialCenter(String name, String description, String mapPath) {
        shopList = new ArrayList<Shop>();
        highlightedshopList = new ArrayList<Shop>();
        this.name = name;
        this.description = description;
        this.mapPath = mapPath;
    }
    public void addEvents(String event){
        events.add(event);
    }

    public void addHighlightedShop(Shop shop){
        highlightedshopList.add(shop);
    }

    public void addShop(Shop shop){
        shopList.add(shop);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMapPath() {
        return mapPath;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public List<Shop> getHighlightedshopList() {
        return highlightedshopList;
    }

    public List<String> getEvents() {
        return events;
    }
}
