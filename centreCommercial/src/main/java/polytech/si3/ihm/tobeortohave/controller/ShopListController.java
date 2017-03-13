package polytech.si3.ihm.tobeortohave.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import polytech.si3.ihm.tobeortohave.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marc on 08/03/2017.
 */
public class ShopListController {

    @FXML
    public Label label;

    private CommonController commonController;

    @FXML
    public Button returnButton;

    @FXML
    public ListView<Shop> listViewShopList;

    @FXML
    public void initialize(){
        returnButton.setOnAction(e -> commonController.reset());
    }

    private JSONReader jsonReader = new JSONReader();


    public void initCommonController(CommonController commonController){
        this.commonController = commonController;
    }

    public void initList(Category category){
        jsonReader.parse();
        List<Store> stores = jsonReader.getStores();
        List<Shop> magasinsToDisplay = new ArrayList<>();
        Shop shop;
        for(Store m : stores){
            if(category.equals(Category.ALL) && m.getAddress().equals("NICE")){
                shop = new Shop(m.getBrand().getLogo(), m.getDescription(), m.getDescription(),0, m.getBrand().getName());
                magasinsToDisplay.add(shop);
                continue;
            }
            if(categoryMatch(m, category)&& m.getAddress().equals("NICE")){
                shop = new Shop(m.getBrand().getLogo(), m.getDescription(), m.getDescription(),0, m.getBrand().getName());
                magasinsToDisplay.add(shop);
            }
        }
        label.setText(category.getDisplay());
        this.listViewShopList.setItems(FXCollections.observableArrayList(magasinsToDisplay));
        this.listViewShopList.setCellFactory(
                new Callback<ListView<Shop>, ListCell<Shop>>() {
                    @Override
                    public ListCell<Shop> call(ListView<Shop> listView) {
                        // Cette cellule personalisée pourrait (devrait) être placée dans une classe à part
                        return new ListCell<Shop>() {
                            @Override
                            protected void updateItem(Shop item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item != null) {
                                    // Load fxml file for this internship
                                    try {
                                        String fxmlFile = "/fxml/shop.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((ShopController) loader.getController()).initShopController(item);
                                        // Display content of the fxml file
                                        this.setGraphic(listElement);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                    }
                });
    }

    public boolean categoryMatch(Store m, Category category){
        List<String> field = new ArrayList<>();
        for(Field f : m.getBrand().getFieldList()){
            field.add(f.getName());
        }
        return field.contains(category.getDisplay());
    }
}
