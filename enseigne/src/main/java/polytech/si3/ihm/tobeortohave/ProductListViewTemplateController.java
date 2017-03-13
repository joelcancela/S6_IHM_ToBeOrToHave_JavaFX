package polytech.si3.ihm.tobeortohave;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import polytech.si3.ihm.tobeortohave.model.Product;

import java.io.File;

/**
 * Created by Galih on 12/03/2017.
 */
public class ProductListViewTemplateController {

    @FXML
    public ImageView productView;
    @FXML
    public Label productName;

    public void initProduct(Product prod) {
        this.productName.setText(prod.getName());
        File file = new File("common/src/main/resources/images/products/"+prod.getPicture());
        Image image = new javafx.scene.image.Image(file.toURI().toString());
        this.productView.setImage(image);
    }
}