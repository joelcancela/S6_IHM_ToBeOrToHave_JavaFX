package polytech.si3.ihm.tobeortohave;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Product;
import polytech.si3.ihm.tobeortohave.model.Store;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.List;
import java.util.ResourceBundle;

public class StatisticsViewController implements Initializable{

	@FXML
	private PieChart pieChart;

	@FXML
	private LineChart lineChart;
	@FXML
	private Label caption;

	private JSONReader jsonReader;

	public void initialize(URL url, ResourceBundle rb) {
		int total = 0;
		jsonReader = new JSONReader();
		jsonReader.parse();
		Store store = jsonReader.getStoresById(8);
		List<Product> products = store.getStock();
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (int i = 0; i < products.size(); i++) {
			pieChartData.add(i,new PieChart.Data(products.get(i).getName(), products.get(i).getSalesNumber()));
			total = total + products.get(i).getSalesNumber();
		}

		pieChart.setData(pieChartData);
		pieChart.setVisible(true);
		pieChart.setTitle("Pourcentage de vente des produits");

		caption.setText("Pourcentage:");
		caption.setStyle("-fx-font: 24 arial;");
		caption.setTranslateX(4.0);
		caption.setTranslateY(40.0);
		for (final PieChart.Data data : pieChart.getData()) {
			int finalTotal = total;
			data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					caption.setText("Pourcentage: " + Integer.toString((int) (data.getPieValue() / finalTotal * 100)) + " %");
				}
			});
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
	}


}
