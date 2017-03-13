package polytech.si3.ihm.tobeortohave;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;

import java.io.IOException;
import java.util.Set;


/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ProductsTabController {
    public GridPane productGrid;
    private JSONReader jsonReader;
    public GridPane bestSellerGrid;
    public ListView listViewPromotion;
    public ListView listViewStarred;

    private ObservableList<Product> starredProducts;
    private ObservableList<Product> discountedProducts;

    @FXML
    public void initialize() {
        jsonReader = new JSONReader();
        jsonReader.parse();

        discountedProducts = FXCollections.observableArrayList(jsonReader.getDiscountedProducts());
        starredProducts = FXCollections.observableArrayList(jsonReader.getStarredProducts());

        listViewPromotion.setItems(discountedProducts);

        listViewPromotion.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Product>() {
                    @Override
                    public void changed(ObservableValue<?extends Product> observable, Product formerClickedProduct, Product clickedProduct) {
                        System.out.println("Click on " + clickedProduct.getName());
                    }
                }
        );

        listViewStarred.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Product>() {
                    @Override
                    public void changed(ObservableValue<?extends Product> observable, Product formerClickedProduct, Product clickedProduct) {
                        System.out.println("Click on " + clickedProduct.getName());
                    }
                }
        );

        listViewPromotion.setCellFactory(
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

        listViewStarred.setItems(starredProducts);
        listViewStarred.setCellFactory(
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

    public void pictureClick(MouseEvent mouseEvent) {
        System.out.println("Click click");
        for (Node node : this.productGrid.getChildren()) {
            if (node instanceof ImageView) {
                System.out.println(node + " : " + ((ImageView) node).getX() + ";" + ((ImageView) node).getY());
                if( node.getBoundsInParent().contains(mouseEvent.getSceneX(),  mouseEvent.getSceneY())) {
                    System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex( node));
                }
            }

        }

        for (Node node : this.bestSellerGrid.getChildren()) {
            if (node instanceof ImageView) {
                System.out.println(node);
                if( node.getBoundsInParent().contains(mouseEvent.getSceneX(),  mouseEvent.getSceneY())) {
                    System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex( node));
                }
            }

        }
    }
}
