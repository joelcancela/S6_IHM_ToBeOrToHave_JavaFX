package polytech.si3.ihm.tobeortohave;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;

import java.io.IOException;
import java.util.List;

import static javafx.util.Duration.seconds;

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
    private int currentIndex = 0;

    @FXML
    public void initialize() {
        jsonReader = new JSONReader();
        jsonReader.parse();
        initializeProducts();
        initScrollAnimationTask();
    }

    private void initScrollAnimationTask() {
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(seconds(3), event -> scrollAnimation()));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
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

        productsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String fxmlFile = "/fxml/productDetails.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    Scene scene = productsListView.getScene();
                    BorderPane firstPane = (BorderPane) scene.getRoot();
                    Tab currentTab = ((TabPane)firstPane.getChildren().get(0)).getTabs().get(0);
                    Node saveContent = currentTab.getContent();
                    Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
                    ((ProductsDetailsController)loader.getController()).initialize((Product)productsListView.getSelectionModel().getSelectedItem(),currentTab, saveContent);
                    currentTab.setContent(rootNode);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    private void scrollAnimation() {
        if(currentIndex%6==0){
            productsListView.scrollTo(currentIndex);
        }
        productsListView.getSelectionModel().select(currentIndex);
        currentIndex++;
        if (currentIndex == productsListView.getItems().size()) {
            currentIndex = 0;
        }
    }

}
