package polytech.si3.ihm.tobeortohave;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainWindowController {
    private static final Logger log = LoggerFactory.getLogger(MainWindowController.class);

    @FXML
    public Tab tab0;
    @FXML
    public Tab tab1;
    @FXML
    public Tab tab2;


    @FXML
    public void initialize() {
        initializeTab("homeWindow", this.tab0);
        initializeTab("magasinView", this.tab1);
        initializeTab("produitsView", this.tab2);
    }

    private void initializeTab(String fxmlName, Tab tab) {
        try {
            String fxmlFile = "/fxml/" + fxmlName + ".fxml";
            FXMLLoader loader2 = new FXMLLoader();
            Node node = loader2.load(getClass().getResourceAsStream(fxmlFile));
            AnchorPane.setTopAnchor(node,0.0);
            AnchorPane.setLeftAnchor(node,0.0);
            AnchorPane.setBottomAnchor(node,0.0);
            AnchorPane.setRightAnchor(node,0.0);
            tab.setContent(node);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public void storeTabSelected(Event event) {
        System.out.println("Store selected");
    }

    public void homeTabSelected(Event event) {
        System.out.println("Home selected");
    }

    public void productTabSelected(Event event) {
        System.out.println("Product selected");
    }
}
