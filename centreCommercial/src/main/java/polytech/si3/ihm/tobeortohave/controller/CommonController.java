package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import polytech.si3.ihm.tobeortohave.model.Category;
import polytech.si3.ihm.tobeortohave.model.CommercialCenter;

import java.io.IOException;

public class CommonController {
    @FXML
    public Tab tab1;

    @FXML
    public Tab tab0;

    @FXML
    public Tab tab2;

    @FXML
    public void initialize() {

    }

    private CommercialCenter commercialCenter;

    public void initModel(CommercialCenter commercialCenter) {
        this.commercialCenter = commercialCenter;
    }

    public void initTab(){
        initTab1();
        initTab0();
        initTab2();
    }

    public void initTab1() {
        String shopCategory = "/fxml/shop_category.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent category = loader.load(getClass().getResourceAsStream(shopCategory));
            ((CategoryController) loader.getController()).initCommonController(this);
            tab1.setContent(category);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterView(Category category) {
        String shoplist = "/fxml/shop_list.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent node = loader.load(getClass().getResourceAsStream(shoplist));
            ((ShopListController) loader.getController()).initCommonController(this);
            ((ShopListController) loader.getController()).initList(category);
            tab1.setContent(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initTab0(){
        String home = "/fxml/home2.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent category = loader.load(getClass().getResourceAsStream(home));
            ((HomeController)loader.getController()).initModel(commercialCenter);
            ((HomeController)loader.getController()).initGridPane(commercialCenter.getHighlightedshopList());
            tab0.setContent(category);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initTab2(){
        String infosSup = "/fxml/infosSup.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent category = loader.load(getClass().getResourceAsStream(infosSup));
            ((InfosSupController)loader.getController()).initModel(commercialCenter);
            tab2.setContent(category);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}