package polytech.si3.ihm.tobeortohave;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;

import java.util.Observable;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class MagasinViewController {

    @FXML
    public ListView listRegion;

    @FXML
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList("Auvergne-Rhône-Alpes",
                                                                         "Bourgogne-Franche-Comté",
                                                                         "Bretagne",
                                                                         "Centre-Val de Loire",
                                                                         "Corse",
                                                                         "Grand Est",
                                                                         "Hauts-de-France",
                                                                         "Île-de-France",
                                                                         "Normandie",
                                                                         "Nouvelle-Aquitaine",
                                                                         "Occitanie",
                                                                         "Pays de la Loire",
                                                                         "Provence-Alpes-Côte d'Azur");
        this.listRegion.setItems(items);
    }
}

