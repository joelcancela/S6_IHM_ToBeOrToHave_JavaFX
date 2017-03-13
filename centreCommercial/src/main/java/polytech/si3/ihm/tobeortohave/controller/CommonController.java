package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import polytech.si3.ihm.tobeortohave.model.Category;

import java.io.IOException;

public class CommonController {
    @FXML
    public Tab tab1;

    @FXML
    public void initialize(){
        initTab1();
    }

    public void initTab1(){
        String home = "/fxml/shop_category.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent category = loader.load(getClass().getResourceAsStream(home));
            ((CategoryController)loader.getController()).initCommonController(this);
            tab1.setContent(category);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterView(Category category){
        String shoplist = "/fxml/shop_list.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent node = loader.load(getClass().getResourceAsStream(shoplist));
            ((ShopListController)loader.getController()).initCommonController(this);
            ((ShopListController)loader.getController()).initList(category);
            tab1.setContent(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}