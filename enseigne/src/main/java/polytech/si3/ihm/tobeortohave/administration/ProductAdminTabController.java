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

import java.io.IOException;

/**
 * Created by Nassim on 14/03/2017.
 */
public class ProductAdminTabController {

    private JSONReader jsonReader;

    @FXML
    public ListView listViewProducts;

    @FXML
    public Button addProductButton;

    @FXML
    public Button removeProductButton;

    private ObservableList<Product> products;

    @FXML
    public void initialize() {
        jsonReader = new JSONReader();
        jsonReader.parse();
        products = FXCollections.observableArrayList(jsonReader.getRealProducts());

        listViewProducts.setItems(products);

        listViewProducts.setCellFactory(
                new Callback<ListView<Product>, ListCell<Product>>() {
                    @Override
                    public ListCell<Product> call(ListView<Product> param) {
                        return new ListCell<Product>() {
                            @Override
                            protected void updateItem(Product item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item != null) {
                                    // Load fxml file for this internship
                                    try {
                                        String fxmlFile = "/fxml/admin/productAdminListViewTemplate.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((ProductAdminListViewTemplateController) loader.getController()).initProduct(item);
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

        listViewProducts.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Product>() {
                    @Override
                    public void changed(ObservableValue<?extends Product> observable, Product formerClickedProduct, Product clickedProduct) {
                    }
                }
        );
    }

    public void addProductAction(){
        System.out.println("Ajout d'un produit");
        //Product p = new Product();
        //products.add(p);
    }

    public void removeProductAction(){
        products.remove(listViewProducts.getSelectionModel().getSelectedItem());
    }
}
