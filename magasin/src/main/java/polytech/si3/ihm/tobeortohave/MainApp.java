package polytech.si3.ihm.tobeortohave;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    private Stage primaryStage;

    // FLAGS
    private static boolean bsTheme = false;
    private static boolean darkTheme = false;
    public static boolean isAdmin = false;

    public static void main(String[] args) throws Exception {

        // read args
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("dark")) {
                darkTheme = true;
            }
            if (args[i].equals("bs")) {
                bsTheme = true;
            }
            if (args[i].equals("admin")) {
                isAdmin = true;
            }
        }

        launch(args);
    }

    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;

        String fxmlFile = "/fxml/common.fxml";

        FXMLLoader loader = new FXMLLoader();

        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        // select theme
        if (MainApp.darkTheme) {
            loadStyle(rootNode, "dark-metro.css");
        }
        else if (MainApp.bsTheme) {
            loadStyle(rootNode, "bs.css");
        }
        else {
            loadStyle(rootNode, "common.css");
        }

        Scene scene = new Scene(rootNode);

        this.primaryStage.setTitle("ToBeOrToHave");
        this.primaryStage.setResizable(false);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void loadStyle(Parent node, String filename) {
        node.getStylesheets().clear();
        node.getStylesheets().add(getClass().getResource("/styles/" + filename).toExternalForm());
    }
}
