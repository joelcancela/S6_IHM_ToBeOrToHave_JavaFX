package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import polytech.si3.ihm.tobeortohave.model.CommercialCenter;

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
    }
}
