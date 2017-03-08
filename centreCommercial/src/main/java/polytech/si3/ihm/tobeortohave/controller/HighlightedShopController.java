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
public class HighlightedShopController {

    @FXML
    public ImageView brandImage;

    @FXML
    public Label shopName;

    @FXML
    public Label shopDescription;

    @FXML
    public Button moreButton;

    public void initHighlightedShop(Shop shop){
        brandImage.setImage(new Image(shop.getLogoPath()));
        shopName.setText(shop.getName());
        shopDescription.setText(shop.getSmallDescription());
    }
}
