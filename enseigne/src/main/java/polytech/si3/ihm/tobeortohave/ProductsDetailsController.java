package polytech.si3.ihm.tobeortohave;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import polytech.si3.ihm.tobeortohave.model.Product;

import javax.xml.soap.Text;
import java.io.File;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ProductsDetailsController {
    @FXML
    private ImageView productPicture;

    @FXML
    private Label productTitle;

    @FXML
    private Label oldPrice;

    @FXML
    private Label discountedPrice;

    @FXML
    private TextArea productDescription;


    public void initialize(Product product){
        File file = new File("common/src/main/resources/images/products/"+product.getPicture());
        Image image = new Image(file.toURI().toString());
        productPicture.setImage(image);

        productTitle.setText(product.getName());

        if(product.isDiscounted()){
            oldPrice.setText(product.getPrice()+"€");
            double discount = product.getPrice() - (product.getPrice()*product.getDiscountRate()/100);
            String discountedPriceValue = String.format("%.2f",discount)+"€";
            discountedPrice.setText(discountedPriceValue);
        }else{
            oldPrice.setVisible(false);
            discountedPrice.setText(String.format("%.2f€",product.getPrice()));
        }
    }

}
