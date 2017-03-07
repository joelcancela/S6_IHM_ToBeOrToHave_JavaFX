package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @FXML
    private Tab tab0;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    public void initialize(){
        displayHome();
    }

    private void displayHome(){
        String home = "/fxml/home.fxml";
        String infos = "/fxml/infosSup.fxml";
        FXMLLoader homeLoader = new FXMLLoader();
        FXMLLoader infosLoader = new FXMLLoader();
        try {
            //Stage stage = (Stage) tab0;
            Parent homeNode = homeLoader.load(getClass().getResourceAsStream(home));
            tab0.setContent(homeNode);
            Parent infosNode = infosLoader.load(getClass().getResourceAsStream(infos));
            tab3.setContent(infosNode);
            //Scene scene = new Scene(homeNode);
            //stage.setScene(scene)
            //((DepartmentController) loader.getController()).initDepartement(department);
            //stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
