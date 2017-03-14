package polytech.si3.ihm.tobeortohave.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jehan on 08/03/2017.
 */
public class CommercialCenter {
    private String name;
    private List<Store> shopList;
    private List<String> events;

    public CommercialCenter(String name) {
        shopList = new ArrayList<>();
        events = new ArrayList<>();
        this.name = name;
    }
    public void addEvents(String event){
        events.add(event);
    }
    
    public void addShop(Store shop){
        shopList.add(shop);
    }

    public String getName() {
        return name;
    }

    public List<Store> getShopList() {
        return shopList;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setShopList(List<Store> shopList) {
        this.shopList = shopList;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public List<Store> getHighlightedshopList() {
        List<Store> stores = new ArrayList<>();
        for(Store store : shopList){
            if(store.isHighlighted())
                stores.add(store);
        }
        return stores;
    }
}
