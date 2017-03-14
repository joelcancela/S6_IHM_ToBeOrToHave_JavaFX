package polytech.si3.ihm.tobeortohave.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jehan on 08/03/2017.
 */
public class CommercialCenter {
    private String name;
    private List<Store> storeList;
    private List<String> events;
    private List<String> products;

    public CommercialCenter(String name) {
        storeList = new ArrayList<>();
        events = new ArrayList<>();
        products = new ArrayList<>();
        this.name = name;
    }
    public void addEvents(String event){
        events.add(event);
    }
    
    public void addShop(Store shop){
        storeList.add(shop);
    }

    public String getName() {
        return name;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public List<Store> getHighlightedshopList() {
        List<Store> stores = new ArrayList<>();
        for(Store store : storeList){
            if(store.isHighlighted())
                stores.add(store);
        }
        return stores;
    }

    public List<String> getProducts(){
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
