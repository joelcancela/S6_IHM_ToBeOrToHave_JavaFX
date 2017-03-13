package polytech.si3.ihm.tobeortohave;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;

import java.io.File;
import java.util.List;

/**
 * {@code InnerHomeWindowController} is [desc]
 * <p>
 * [descSuite]
 *
 * @author Nassim BOUNOUAS
 * @author Joël CANCELA VAZ
 */
public class InnerHomeWindowController {
	@FXML
	private GridPane homeproducts;

	private JSONReader jsonReader;


	@FXML
	public void initialize() {
		jsonReader = new JSONReader();
		jsonReader.parse();
		initializeProducts();
	}

	private void initializeProducts() {
		List<Product> productList = jsonReader.getProducts();
		int x=0;
		int y=0;
		for (Product product : productList) {
			Node produitNode = createProductNode(product);
			homeproducts.add(produitNode,x++,y);
			if(x==6){
				x=0;
				y=y+1;
			}
		}
	}

	private Node createProductNode(Product p){
		VBox vBox = new VBox();

		//Picture
		File file = new File("common/src/main/resources/images/products/"+p.getPicture());
		Image image = new Image(file.toURI().toString());
		ImageView imageView = new ImageView(image);
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(115.0);
		vBox.getChildren().add(imageView);

		//Text
		Label label = new Label(p.getName());
		label.setFont(Font.font("System", FontWeight.NORMAL, 16));
		vBox.getChildren().add(label);

		return vBox;
	}

}
