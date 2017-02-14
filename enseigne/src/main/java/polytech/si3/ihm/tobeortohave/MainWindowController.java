package polytech.si3.ihm.tobeortohave;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainWindowController {
    private static final Logger log = LoggerFactory.getLogger(MainWindowController.class);

    @FXML
    private TabPane tabPaneMain;

    @FXML
    private TabPane tabPaneMagasins;

    @FXML
    private TabPane tabPaneProduits;

    @FXML
    public void initialize() {

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
