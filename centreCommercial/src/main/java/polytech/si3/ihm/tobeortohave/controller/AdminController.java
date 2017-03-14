package polytech.si3.ihm.tobeortohave.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import polytech.si3.ihm.tobeortohave.model.Category;
import polytech.si3.ihm.tobeortohave.model.CommercialCenter;
import polytech.si3.ihm.tobeortohave.model.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jehan on 14/03/2017.
 */
public class AdminController {
    @FXML
    public ChoiceBox deleteChoice;
    @FXML
    public Button confirmDelete;
    @FXML
    public TextField textStoreName;
    @FXML
    public Button chooseLogo;
    @FXML
    public ChoiceBox chooseType;
    @FXML
    public CheckBox highlighted;
    @FXML
    public TextField email;
    @FXML
    public TextField number;
    @FXML
    public Button confirmCreate;

    private CommercialCenter commercialCenter;

    @FXML
    public void initialize() {

    }

    public void initModel(CommercialCenter commercialCenter) {
        this.commercialCenter = commercialCenter;
    }


    public void initContent() {
        List<String> storeNames = new ArrayList<>();
        for(Store store : commercialCenter.getStoreList()){
            storeNames.add(store.getBrand().getName());
        }
        deleteChoice.setItems(FXCollections.observableArrayList(storeNames));
        deleteChoice.getSelectionModel().selectFirst();

        List<String> categoryNames = new ArrayList<>();
        for(Category category: Category.values()){
            if(category == Category.ALL) continue;
            categoryNames.add(category.getDisplay());
        }
        chooseType.setItems(FXCollections.observableArrayList(categoryNames));
        chooseType.getSelectionModel().selectFirst();
    }
}
