package polytech.si3.ihm.tobeortohave;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;
import polytech.si3.ihm.tobeortohave.model.Store;

import java.net.URL;
import java.text.DateFormatSymbols;
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
		Store store = jsonReader.getStoresById(8);
		List<Product> products = store.getStock();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (int i = 0; i < products.size(); i++) {
			pieChartData.add(i,new PieChart.Data(products.get(i).getName(), products.get(i).getSalesNumber()));
		}

		String[] mois = new DateFormatSymbols().getMonths();
		List<Double> caList = store.getCA();
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
