package polytech.si3.ihm.tobeortohave;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import polytech.si3.ihm.tobeortohave.model.JSONReader;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    private Stage primaryStage;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;

        String fxmlFile = "/fxml/common.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("/styles/styles.css");

        this.primaryStage.setTitle("ToBeOrToHave - Enseigne");
        this.primaryStage.setResizable(false);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        JSONReader jsonReader = new JSONReader();
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }
}
