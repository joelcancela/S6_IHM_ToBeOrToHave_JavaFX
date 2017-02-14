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
    public ListView listVille;
    @FXML
    public ListView listStores;

    @FXML
    public void initialize() {
        ObservableList<String> regions = FXCollections.observableArrayList("Auvergne-Rhône-Alpes",
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
        this.listRegion.setItems(regions);

        ObservableList<String> cities = FXCollections.observableArrayList("Ville 1", "Ville 2", "Ville 3", "Ville 4", "Ville 5", "Ville 6", "Ville 7", "Ville 8", "Ville 9","Ville 10");
        this.listVille.setItems(cities);

        ObservableList<String> stores = FXCollections.observableArrayList("Magasin 1", "Magasin 2", "Magasin 3", "Magasin 4", "Magasin 5", "Magasin 6", "Magasin 7", "Magasin 8", "Magasin 9", "Magasin 10");
        this.listStores.setItems(stores);
    }
}

