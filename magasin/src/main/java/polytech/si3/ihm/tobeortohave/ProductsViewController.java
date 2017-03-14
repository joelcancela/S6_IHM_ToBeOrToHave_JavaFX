package polytech.si3.ihm.tobeortohave;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;

import java.io.IOException;

public class ProductsViewController {
	public GridPane productGrid;
	private JSONReader jsonReader;
	public GridPane bestSellerGrid;
	@FXML
	public ListView listViewPromotion;
	@FXML
	public ListView listViewAllProducts;

	private ObservableList<Product> allProducts;
	private ObservableList<Product> discountedProducts;

	@FXML
	public void initialize() {
		jsonReader = new JSONReader();
		jsonReader.parse();

		discountedProducts = FXCollections.observableArrayList(jsonReader.getDiscountedProductsForAStore(8));
		allProducts = FXCollections.observableArrayList(jsonReader.getStoresById(8).getStock());

		listViewPromotion.setItems(discountedProducts);
		listViewAllProducts.setItems(allProducts);

		addDetailsListenerOnListView(listViewAllProducts);
		addDetailsListenerOnListView(listViewPromotion);




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

	private void addDetailsListenerOnListView (ListView listView) {
		listView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Product>() {
					@Override
					public void changed(ObservableValue<?extends Product> observable, Product formerClickedProduct, Product clickedProduct) {
						System.out.println("Click on " + clickedProduct.getName());
						String fxmlFile = "/fxml/productDetails.fxml";
						FXMLLoader loader = new FXMLLoader();
						try {
							Scene scene = listView.getScene();
							BorderPane firstPane = (BorderPane) scene.getRoot();
							Tab currentTab = ((TabPane)firstPane.getChildren().get(0)).getTabs().get(1);
							Node saveContent = currentTab.getContent();
							Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
							((ProductsDetailsController)loader.getController()).initialize(clickedProduct,currentTab, saveContent);
							currentTab.setContent(rootNode);

						} catch (IOException e) {
							e.printStackTrace();
						}
						listView.getSelectionModel().clearSelection();
					}
				}
		);




		listView.setCellFactory(
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
