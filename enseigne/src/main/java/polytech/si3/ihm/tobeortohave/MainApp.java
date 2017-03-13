package polytech.si3.ihm.tobeortohave;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import polytech.si3.ihm.tobeortohave.model.JSONReader;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        String fxmlFile = "/fxml/common.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("ToBeOrToHave - Enseigne");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        JSONReader jsonReader = new JSONReader();
        jsonReader.parse();
    }
}
