package polytech.si3.ihm.tobeortohave.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import polytech.si3.ihm.tobeortohave.model.Category;

import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Created by Marc on 08/03/2017.
 */
public class ShopListController {

    @FXML
    public Label label;

    private CommonController commonController;

    @FXML
    public Button returnButton;

    @FXML
    public ListView listViewShopList;

    @FXML
    public void initialize(){
        returnButton.setOnAction(e -> commonController.reset());
    }


    public void initCommonController(CommonController commonController){
        this.commonController = commonController;
    }

    public void initLabel(Category category){
        label.setText(category.getDisplay());
    }

}
