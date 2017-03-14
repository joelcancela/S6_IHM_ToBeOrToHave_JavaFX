package polytech.si3.ihm.tobeortohave.administration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Galih on 14/03/2017.
 */
public class AddProductAdminListViewTemplateController {

    private JSONReader jsonReader;

    @FXML
    public ImageView productView;
    @FXML
    public TextField productName;
    @FXML
    public CheckBox isDiscount;
    @FXML
    public CheckBox isStarred;
    @FXML
    public ComboBox comboBoxCat;
    @FXML
    public TextArea descriptionField;
    @FXML
    public TextField discountRate;
    @FXML
    public TextField price;

    public ObservableList<Product> oA;
    public Stage st;
    public String picPath = "";

    public void init(ObservableList oa, Stage st) {
        jsonReader = new JSONReader();
        jsonReader.parse();
        comboBoxCat.setItems(FXCollections.observableArrayList(jsonReader.getKeywords()));
        oA = oa;
        this.st = st;
    }

    public void validAction(){
        ArrayList strings = new ArrayList();
        strings.add(comboBoxCat.getSelectionModel().getSelectedItem());
        System.out.println("Path : " + picPath);
        double priceD;
        double rate;

        try {
            priceD = Double.parseDouble(price.getText());
        } catch (Exception e) {
            priceD = 0.0;
        }

        try {
            rate = Double.parseDouble(discountRate.getText());
        } catch (Exception e) {
            rate = 0.0;
        }
        oA.add(new Product(0, productName.getText(), strings, isStarred.isSelected(), isDiscount.isSelected(), rate, priceD, picPath, 0, descriptionField.getText(), true));
        st.close();
    }

    public void choosePicture() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir le visuel produit");
        File f = fileChooser.showOpenDialog(new Stage());
        picPath = f.getAbsolutePath();
    }

    public void cancelAction(){
        this.st.close();
    }
    public void initProduct(Product prod) {
        this.productName.setText(prod.getName());
        File file = new File("common/src/main/resources/images/products/" + prod.getPicture());
        Image image = new Image(file.toURI().toString());
        this.productView.setImage(image);
        this.productName.setText(prod.getName());
    }
}
