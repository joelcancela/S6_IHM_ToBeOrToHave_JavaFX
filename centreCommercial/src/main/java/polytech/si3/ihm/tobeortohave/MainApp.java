package polytech.si3.ihm.tobeortohave;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import polytech.si3.ihm.tobeortohave.controller.CommonController;
import polytech.si3.ihm.tobeortohave.model.*;
import polytech.si3.ihm.tobeortohave.parser.CommercialCenterParser;

import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting Hello JavaFX and Maven demonstration application");

        String fxmlFile = "/fxml/common.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        CommercialCenter commercialCenter = createModel();
        ((CommonController)loader.getController()).initModel(commercialCenter);
        ((CommonController)loader.getController()).initTab();

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

        stage.setTitle("Centre commercial");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private CommercialCenter createModel(){
        JSONReader jsonReader = new JSONReader();
        CommercialCenterParser commercialCenterParser = new CommercialCenterParser();
        jsonReader.parse();
        CommercialCenter commercialCenter = new CommercialCenter("Cap Sophia");
        commercialCenter.setShopList(jsonReader.getNiceStores());
        commercialCenter.setEvents(commercialCenterParser.getPathEvent());
        commercialCenter.setProducts(commercialCenterParser.getPathProducts());

        return commercialCenter;
    }

}
