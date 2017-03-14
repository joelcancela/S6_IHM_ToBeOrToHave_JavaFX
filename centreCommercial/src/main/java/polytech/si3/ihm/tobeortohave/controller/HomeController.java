package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import polytech.si3.ihm.tobeortohave.model.CommercialCenter;
import polytech.si3.ihm.tobeortohave.model.Shop;
import polytech.si3.ihm.tobeortohave.model.Store;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marc on 08/03/2017.
 */
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @FXML
    public Pane eventPane;

    @FXML
    public Pane highlightPane;

    @FXML
    public GridPane gridPaneHome;

    @FXML
    private void initialize() {
    }

    private CommercialCenter commercialCenter;

    public void initModel(CommercialCenter commercialCenter) {
        this.commercialCenter = commercialCenter;
    }

    public void initGridPane(List<Store> highlightedShops) {
        int size = highlightedShops.size();
        for (int i = 0; i <= highlightedShops.size() / 3; i++) {
            for (int j = 0; j < 3 && size > 0; j++, size--) {
                log.info("Pass. i = " + i + " j = " + j);
                String fxmlFile = "/fxml/home_shop.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
                    ((HighlightedShopController) loader.getController()).initHighlightedShop(highlightedShops.get(i * 3 + j));
                    gridPaneHome.add(rootNode, j, i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void initEventPane(){
        String scroll = "/fxml/scroll.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(scroll));
            ((EventScrollingController) loader.getController()).init(commercialCenter.getEvents());
            eventPane.getChildren().add(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initProductPane(){
        String scroll = "/fxml/scroll_product_highlight.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(scroll));
            ((ProductScrollingController) loader.getController()).init(commercialCenter.getProducts());
            highlightPane.getChildren().add(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
