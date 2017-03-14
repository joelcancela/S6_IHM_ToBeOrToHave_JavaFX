package polytech.si3.ihm.tobeortohave;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    @FXML
    private ImageView closePicture;

    private Node contentSaved;
    private Tab currentTab;


    public void initialize(Product product, Tab currentTab, Node previousContent){
        contentSaved=previousContent;
        this.currentTab=currentTab;

        File file = new File("common/src/main/resources/images/products/"+product.getPicture());
        Image image = new Image(file.toURI().toString());
        productPicture.setImage(image);

        productTitle.setText(product.getName());

        if(product.isDiscounted()){
            oldPrice.setText(String.format("%.2f€",product.getPrice()));
            double discount = product.getPrice() - (product.getPrice()*product.getDiscountRate()/100);
            discountedPrice.setText(String.format("%.2f€",discount));
        }else{
            oldPrice.setVisible(false);
            discountedPrice.setText(String.format("%.2f€",product.getPrice()));
        }

        productDescription.setEditable(false);
        productDescription.setText(product.getDescription());
        closePicture.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                currentTab.setContent(contentSaved);
            }
        });
    }
}
