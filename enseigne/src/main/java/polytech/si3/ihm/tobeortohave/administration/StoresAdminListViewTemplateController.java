package polytech.si3.ihm.tobeortohave.administration;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import polytech.si3.ihm.tobeortohave.model.Product;
import polytech.si3.ihm.tobeortohave.model.Store;

import java.io.File;
import java.util.stream.Collectors;

/**
 * Created by Galih on 14/03/2017.
 */
public class StoresAdminListViewTemplateController {

    @FXML
    public Label storeCity;
    @FXML
    public Label storeLatitude;
    @FXML
    public Label storeLongitude;
    @FXML
    public Label storeWebsite;
    @FXML
    public Label idStore;
    @FXML
    public ListView productsList;


    public void initStore(Store store) {
        this.storeCity.setText(store.getAddress());
        this.storeLatitude.setText(Double.toString(store.getLatitude()));
        this.storeLongitude.setText(Double.toString(store.getLongitude()));
        this.storeWebsite.setText(store.getWebAddress());
        this.productsList.setItems(FXCollections.observableArrayList(store.getStock().stream().map(s -> s.getName()).collect(Collectors.toList())));
    }
}
