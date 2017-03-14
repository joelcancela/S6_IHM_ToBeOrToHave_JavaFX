package polytech.si3.ihm.tobeortohave.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ShopListController {

    @FXML
    public Label label;

    private CommonController commonController;

    private Category category = Category.ALL;

    @FXML
    public Button refreshButton;

    @FXML
    public Button returnButton;

    @FXML
    public ListView<Store> listViewShopList;

    @FXML
    public void initialize(){
        returnButton.setOnAction(e -> commonController.initTab1());
        refreshButton.setOnAction(e -> initList(category));
    }

    private JSONReader jsonReader = new JSONReader();


    public void initCommonController(CommonController commonController){
        this.commonController = commonController;
    }

    private CommercialCenter commercialCenter;

    public void initModel(CommercialCenter commercialCenter){
        this.commercialCenter = commercialCenter;
    }

    public void initList(Category category){
        this.category = category;
        List<Store> stores = commercialCenter.getShopList();
        List<Store> magasinsToDisplay = new ArrayList<>();
        for(Store m : stores){
            if(category.equals(Category.ALL) && m.getAddress().equals("NICE")){
                magasinsToDisplay.add(m);
                continue;
            }
            if(categoryMatch(m, category)&& m.getAddress().equals("NICE")){
                magasinsToDisplay.add(m);
            }
        }
        ObservableList<Store> observableList = FXCollections.observableArrayList(magasinsToDisplay);
        label.setText(category.getDisplay());
        this.listViewShopList.setItems(observableList);
        this.listViewShopList.setCellFactory(
                new Callback<ListView<Store>, ListCell<Store>>() {
                    @Override
                    public ListCell<Store> call(ListView<Store> listView) {
                        // Cette cellule personalisée pourrait (devrait) être placée dans une classe à part
                        return new ListCell<Store>() {
                            @Override
                            protected void updateItem(Store item, boolean empty) {
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
