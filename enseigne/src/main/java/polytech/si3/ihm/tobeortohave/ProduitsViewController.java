package polytech.si3.ihm.tobeortohave;

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
import jdk.nashorn.internal.parser.JSONParser;
import net.miginfocom.layout.Grid;
import org.json.JSONObject;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Magasin;
import polytech.si3.ihm.tobeortohave.model.Produit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ProduitsViewController {
    public GridPane productGrid;
    private JSONReader jsonReader;
    public GridPane bestSellerGrid;
    public ListView listViewPromotion;

    private ObservableList<Produit> starredProducts;
    private ObservableList<Produit> discountedProducts;

    @FXML
    public void initialize() {
        jsonReader = new JSONReader();
        jsonReader.parse();

        discountedProducts = FXCollections.observableArrayList(jsonReader.getDiscountedProducts());
        starredProducts = FXCollections.observableArrayList(jsonReader.getStarredProducts());

        listViewPromotion.setItems(discountedProducts);
        listViewPromotion.setCellFactory(
                new Callback<ListView<Produit>, ListCell<Produit>>() {
                    @Override
                    public ListCell<Produit> call(ListView<Produit> param) {
                        return new ListCell<Produit>() {
                            @Override
                            protected void updateItem(Produit item, boolean empty) {
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
