package polytech.si3.ihm.tobeortohave;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StatistiquesViewController implements Initializable{

	@FXML
	private PieChart pieChart;

	@FXML
	private AnchorPane pane;

	public void initialize(URL url, ResourceBundle rb) {
		ObservableList<PieChart.Data> pieChartData =
				FXCollections.observableArrayList(
						new PieChart.Data("Grapefruit", 13),
						new PieChart.Data("Oranges", 25),
						new PieChart.Data("Plums", 10),
						new PieChart.Data("Pears", 22),
						new PieChart.Data("Apples", 30));

		pieChart.setData(pieChartData);
		pieChart.setVisible(true);
	}


}
