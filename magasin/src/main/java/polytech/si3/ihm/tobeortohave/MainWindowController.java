package polytech.si3.ihm.tobeortohave;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindowController {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(MainWindowController.class);

    // i18n
    private Locale i18n = new Locale("fr", "FR");

    @FXML
    public Tab tab0;
    @FXML
    public Tab tab1;
    @FXML
    public Tab tab2;
    @FXML
    public Tab tab3;

    @FXML
    public ToggleButton localeBtn;

    @FXML
    public void initialize() {

        localeBtn.setText(new Locale("en", "EN").getDisplayLanguage());

        if (MainApp.isAdmin) {

            loadTab("admin_home",      this.tab0); // load at slot 0 admin interface
            tab1.setDisable(true);
            tab2.setDisable(true);
            tab3.setDisable(true);

            return;
        }

        loadTab("accueil",      this.tab0);
        loadTab("produits",     this.tab1);
        loadTab("carte",        this.tab2);
        loadTab("statistiques", this.tab3);
    }

    private void loadTab(String fxmlFileName, Tab tab) {

        try {
            // FXML Path
            String fxmlFile = "/fxml/" + fxmlFileName + ".fxml";

            FXMLLoader fxmlLoader = new FXMLLoader();

            // i18n
            fxmlLoader.setResources(ResourceBundle.getBundle("i18n.Bundle", i18n));

            // FXML
            Node node = fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));

            // Fix position
            AnchorPane.setTopAnchor(node,0.0);
            AnchorPane.setLeftAnchor(node,0.0);
            AnchorPane.setBottomAnchor(node,0.0);
            AnchorPane.setRightAnchor(node,0.0);

            // Update contents
            tab.setContent(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Change locale on click
    public void onI18nClick(Event event) {

        System.out.print("Changing locale...");

        if (i18n.equals(new Locale("fr", "FR"))) {

            i18n = new Locale("en", "EN");

            this.tab0.setText("Home");
            this.tab1.setText("Products");
            this.tab2.setText("Find us");
            this.tab3.setText("Statistics");
        } else {

            i18n = new Locale("fr", "FR");

            this.tab0.setText("Accueil");
            this.tab1.setText("Produits");
            this.tab2.setText("Nous trouver");
            this.tab3.setText("Statistiques");
        }

        if (MainApp.isAdmin) {
            loadTab("admin_home",      this.tab0);
            return;
        }

        // notify views
        loadTab("accueil",      this.tab0);
        loadTab("produits",     this.tab1);
        loadTab("carte",        this.tab2);
        loadTab("statistiques", this.tab3);
    }
}
