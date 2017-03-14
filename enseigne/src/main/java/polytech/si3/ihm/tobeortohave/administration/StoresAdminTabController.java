package polytech.si3.ihm.tobeortohave.administration;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;
import polytech.si3.ihm.tobeortohave.model.Store;

import java.io.IOException;

/**
 * Created by Galih on 14/03/2017.
 */
public class StoresAdminTabController {
    private JSONReader jsonReader;

    @FXML
    public ListView listViewStores;

    @FXML
    public Button addStoreButton;

    @FXML
    public Button removeStoreButton;

    private ObservableList<Store> stores;

    @FXML
    public void initialize() {
        jsonReader = new JSONReader();
        jsonReader.parse();
        for (Store s : jsonReader.getRealStores()) {
            System.out.println(s.getAddress());
        }
        stores = FXCollections.observableArrayList(jsonReader.getRealStores());

        listViewStores.setItems(stores);

        listViewStores.setCellFactory(
                new Callback<ListView<Store>, ListCell<Store>>() {
                    @Override
                    public ListCell<Store> call(ListView<Store> param) {
                        return new ListCell<Store>() {
                            @Override
                            protected void updateItem(Store item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item != null) {
                                    // Load fxml file for this internship
                                    try {
                                        String fxmlFile = "/fxml/admin/storesAdminListViewTemplate.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((StoresAdminListViewTemplateController) loader.getController()).initStore(item);
                                        // Display content of the fxml file
                                        this.setGraphic(listElement);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                    }
                }
        );

        listViewStores.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Store>() {
                    @Override
                    public void changed(ObservableValue<?extends Store> observable, Store formerClickedStore, Store clickedStore) {
                        System.out.println("Click on " + clickedStore.getAddress());
                    }
                }
        );
    }

    public void addStoreAction(){
        System.out.println("Ajout d'un produit");
        //Product p = new Product();
        //stores.add(p);
    }

    public void removeStoreAction(){
        System.out.println("Remove d'un produit");
        stores.remove(listViewStores.getSelectionModel().getSelectedItem());
    }
}
