package polytech.si3.ihm.tobeortohave.administration;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import polytech.si3.ihm.tobeortohave.model.Product;

import java.io.File;
import java.util.DoubleSummaryStatistics;

/**
 * Created by Galih on 14/03/2017.
 */
public class ProductAdminListViewTemplateController {

    @FXML
    public ImageView productView;
    @FXML
    public Label productName;
    @FXML
    public Label starred;
    @FXML
    public Label discount;
    @FXML
    public Label discountRate;
    @FXML
    public Label price;
    @FXML
    public ListView keywordsListView;
    @FXML
    public TextArea descriptionField;

    public void initProduct(Product prod) {
        this.productName.setText(prod.getName());
        File file = new File("somewhere");
        if (prod.isOverwrite()) {
            file = new File(prod.getPicture());
        } else {
            file = new File("common/src/main/resources/images/products/" + prod.getPicture());
        }
        Image image = new javafx.scene.image.Image(file.toURI().toString());
        this.productView.setImage(image);
        this.productName.setText(prod.getName());

        if (prod.isStarred()) {
            this.starred.setText("Oui");
        } else {
            this.starred.setText("Non");
        }

        if (prod.isDiscounted()) {
            this.discount.setText("Oui");
        } else {
            this.discount.setText("Non");
        }
        this.discountRate.setText(Double.toString(prod.getDiscountRate()));
        this.price.setText(Double.toString(prod.getPrice()));
        this.descriptionField.setText(prod.getDescription());
        this.keywordsListView.setItems(FXCollections.observableArrayList(prod.getKeywords()));
    }
}
