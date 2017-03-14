package polytech.si3.ihm.tobeortohave.controller;

import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import polytech.si3.ihm.tobeortohave.model.Category;
import polytech.si3.ihm.tobeortohave.model.CommercialCenter;
import polytech.si3.ihm.tobeortohave.model.Store;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    @FXML
    public Label confirmDeleteLabel;
    @FXML
    public Label fileUploaded;
    @FXML
    public Label confirmCreateLabel;
    @FXML
    public TextArea descriptionText;
    @FXML
    public Button changeInApp;

    private CommercialCenter commercialCenter;
    private Image logoChoosen;
    private CommonController commonController;

    @FXML
    public void initialize() {
        chooseLogo.setOnAction(e -> btnLoadLogo());
        confirmDelete.setOnAction(e -> btnDeleteStore());
        confirmCreate.setOnAction(e -> btnAddStore());
        changeInApp.setOnAction(e -> btnChangeInApp());
    }

    public void initModel(CommercialCenter commercialCenter) {
        this.commercialCenter = commercialCenter;
    }


    public void initContent() {
        List<String> storeNames = new ArrayList<>();
        for(Store store : commercialCenter.getStoreList()){
            storeNames.add(store.getName());
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

    private void btnAddStore() {
        String type = (String) chooseType.getValue();
        String name = textStoreName.getText();
        String description = descriptionText.getText();
        String mail = email.getText();
        String phoneNumber = number.getText();
        boolean isHighlighted = highlighted.isSelected();
        if(type.isEmpty() || name.isEmpty() || description.isEmpty() || mail.isEmpty() || phoneNumber.isEmpty() || logoChoosen == null){
            confirmCreateLabel.setTextFill(Color.web("#cd1919"));
            confirmCreateLabel.setText("Un des champs n'a pas été rempli");
            confirmCreateLabel.setVisible(true);
        }
        else{
            Category category = Category.getCategory(type);
            commercialCenter.getStoreList().add(new Store(description, phoneNumber, mail, isHighlighted, category, name, logoChoosen));
            confirmCreateLabel.setText("Le magasin a bien été créé dans l'application");
            confirmCreateLabel.setTextFill(Color.web("#04ab0a"));
            confirmCreateLabel.setVisible(true);
            changeInApp.setVisible(true);
        }
    }

    private void btnDeleteStore() {
        String storeName = (String) deleteChoice.getValue();
        Store storeToDelete = null;
        for(Store store : commercialCenter.getStoreList()){
            if(store.getName().equals(storeName)){
                storeToDelete = store;
            }
        }
        if(storeToDelete != null){
            commercialCenter.getStoreList().remove(storeToDelete);
            confirmDeleteLabel.setVisible(true);
            confirmDeleteLabel.setText("Le magasin a bien été supprimé de l'application");
            confirmDeleteLabel.setTextFill(Color.web("#04ab0a"));
            changeInApp.setVisible(true);
        }
        else{
            confirmDeleteLabel.setText("Le magasin n'as pas put être supprimé\nIl a peut-être déjà été supprimé");
            confirmDeleteLabel.setTextFill(Color.web("#cd1919"));
        }
    }

    private void btnChangeInApp() {
        commonController.initTab();
    }

    public void btnLoadLogo() {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        if(file != null){
            fileUploaded.setText(file.getName());
            fileUploaded.setVisible(true);
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                logoChoosen = image;
            } catch (IOException ex) {
                System.out.println("He chose nothing :(");
            }
        }
    }

    public void initCommonController(CommonController commonController) {
        this.commonController = commonController;
    }
};
