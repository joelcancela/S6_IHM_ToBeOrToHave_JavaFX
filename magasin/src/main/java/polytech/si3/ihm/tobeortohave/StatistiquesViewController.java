package polytech.si3.ihm.tobeortohave;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import polytech.si3.ihm.tobeortohave.model.Enseigne;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Magasin;
import polytech.si3.ihm.tobeortohave.model.Produit;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class StatistiquesViewController implements Initializable{

	@FXML
	private PieChart pieChart;

	@FXML
	private LineChart lineChart;

	private JSONReader jsonReader;

	public void initialize(URL url, ResourceBundle rb) {
		jsonReader = new JSONReader();
		jsonReader.parse();
		List<Magasin> magasinsTmp = jsonReader.getStores();
		List<Magasin> magasins = Enseigne.findMagasinByBrand(magasinsTmp,"ToBeOrToHave");
		Magasin magasin = magasins.get(0);
		List<Produit> produits = magasin.getStock();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (int i = 0; i < produits.size(); i++) {
			pieChartData.add(i,new PieChart.Data(produits.get(i).getName(),produits.get(i).getSalesNumber()));
		}

		String[] mois = new DateFormatSymbols().getMonths();
		List<Double> caList = magasin.getCA();
		XYChart.Series series = new XYChart.Series();
		for (int i = 0; i < caList.size(); i++) {
			series.getData().add(new XYChart.Data(mois[i], caList.get(i)));
		}

		lineChart.getData().add(series);
		lineChart.setVisible(true);
		lineChart.setTitle("Chiffre d'affaire");
		pieChart.setData(pieChartData);
		pieChart.setVisible(true);
		pieChart.setTitle("Pourcentage de vente des produits");
	}


}
