package polytech.si3.ihm.tobeortohave;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * {@code HomeTabViewController} is [desc]
 * <p>
 * [descSuite]
 *
 * @author Nassim BOUNOUAS
 * @author Joël CANCELA VAZ
 */
public class HomeTabExtensionViewController {
	@FXML
	private ListView productsListView;

	private JSONReader jsonReader;

	@FXML
	public void initialize() {
		jsonReader = new JSONReader();
		jsonReader.parse();
		initializeProducts();
	}

	private void initializeProducts() {
		List<Product> productList = jsonReader.getRealProducts();
        ObservableList<Product> productObservableList = FXCollections.observableArrayList(productList);
        productsListView.setItems(productObservableList);
        productsListView.setCellFactory(
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
                                        String fxmlFile = "/fxml/productListViewTemplate.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((ProductListViewTemplateController) loader.getController()).initProduct(item);
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
	}

}
