package polytech.si3.ihm.tobeortohave;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainWindowController {

	@FXML
	public Tab tab0;
	@FXML
	public Tab tab1;
	@FXML
	public Tab tab2;


	@FXML
	public void initialize() {
		initializeTab("homeTabView", this.tab0);
		//initializeTab("homeTabExtensionView", this.tab0); //Extension listView autoScroll
		initializeTab("storesView", this.tab1);
		initializeTab("productsView", this.tab2);
	}

	private void initializeTab(String fxmlName, Tab tab) {
		try {
			String fxmlFile = "/fxml/" + fxmlName + ".fxml";
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
