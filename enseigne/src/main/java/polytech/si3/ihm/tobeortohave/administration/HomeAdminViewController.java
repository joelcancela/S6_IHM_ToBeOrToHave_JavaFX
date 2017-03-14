package polytech.si3.ihm.tobeortohave.administration;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Galih on 14/03/2017.
 */
public class HomeAdminViewController {

    @FXML
    public Tab tab0;
    @FXML
    public Tab tab1;
    @FXML
    public Tab tab2;

    @FXML
    public void initialize() {
        initializeTab("productsAdminView", this.tab0);
        initializeTab("keywordsAdminView", this.tab1);
        initializeTab("storesAdminView", this.tab2);
    }

    private void initializeTab(String fxmlName, Tab tab) {
        try {
            String fxmlFile = "/fxml/admin/" + fxmlName + ".fxml";
            FXMLLoader loader2 = new FXMLLoader();
            Node node = loader2.load(getClass().getResourceAsStream(fxmlFile));
            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
            tab.setContent(node);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
