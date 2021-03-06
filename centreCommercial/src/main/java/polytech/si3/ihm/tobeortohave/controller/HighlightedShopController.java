package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import polytech.si3.ihm.tobeortohave.model.Store;

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

    public void initHighlightedShop(Store store){
        brandImage.setImage(store.getLogo());
        shopName.setText(store.getName());
        shopDescription.setText(store.getDescription());
    }
}
