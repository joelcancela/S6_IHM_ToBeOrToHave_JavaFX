package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import polytech.si3.ihm.tobeortohave.model.Shop;

/**
 * Created by MARC-PC on 07/03/2017.
 */
public class ShopController {

    @FXML
    public ImageView brandImageBig;

    @FXML
    public Label shopNameBig;

    @FXML
    public Label descriptionBig;

    @FXML
    public Button moreButtonBig;

    public void initShopController(Shop shop){
        brandImageBig.setImage(new Image(shop.getLogoPath()));
        shopNameBig.setText(shop.getName());
        descriptionBig.setText(shop.getDescription());
    }
}
