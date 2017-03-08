package polytech.si3.ihm.tobeortohave;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import polytech.si3.ihm.tobeortohave.model.Enseigne;
import polytech.si3.ihm.tobeortohave.model.JSONReader;
import polytech.si3.ihm.tobeortohave.model.Magasin;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MapViewController implements Initializable, MapComponentInitializedListener {

	@FXML
	private VBox vbox;

	@FXML
	private GoogleMapView mapView;

	private GoogleMap map;

	private JSONReader jsonReader;

	public void initialize(URL url, ResourceBundle rb) {
		jsonReader = new JSONReader();
		jsonReader.parse();
		mapView.addMapInializedListener(this);
	}


	public void mapInitialized() {
		LatLong myShopLocation = new LatLong(43.2916976, 5.4766483);


		//Set the initial properties of the map.
		MapOptions mapOptions = new MapOptions();

		mapOptions.center(new LatLong(43.2916159, 5.4768394))
				.mapType(MapTypeIdEnum.ROADMAP)
				.overviewMapControl(false)
				.panControl(false)
				.mapTypeControl(false)
				.rotateControl(false)
				.scaleControl(false)
				.streetViewControl(false)
				.zoomControl(false)
				.zoom(19)
				.styleString("[{featureType: \"poi\",stylers: [{ visibility: \"off\" }]}]");

		map = mapView.createMap(mapOptions);


		List<Magasin> magasinsTmp = jsonReader.getStores();
		List<Magasin> magasins = Enseigne.findMagasinByBrand(magasinsTmp,"ToBeOrToHave");
		vbox.setSpacing(10.0);
		for (Magasin magasin: magasins) {
			Button button = new Button(magasin.getAddress());
			button.setStyle("-fx-font-size: 20px;");
			button.addEventHandler(MouseEvent.MOUSE_CLICKED,
					new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							map.clearMarkers();
							LatLong latLong = new LatLong(magasin.getLatitude(),magasin.getLongitude());
							//Add markers to the map
							MarkerOptions markerOptions1 = new MarkerOptions();
							markerOptions1.position(latLong);


							Marker myShopMarker = new Marker(markerOptions1);


							map.addMarker(myShopMarker);



							InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
							infoWindowOptions.content("<h2>ToBeOrToHave</h2>"
									+ "Telephone: " + magasin.getPhoneNumber() + "<br>"
									+ "Web: " + magasin.getWebAddress());

							InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
							fredWilkeInfoWindow.open(map, myShopMarker);

							map.setCenter(latLong);
						}
					});
			vbox.getChildren().add(button);
		}

		//Add markers to the map
		MarkerOptions markerOptions1 = new MarkerOptions();
		markerOptions1.position(myShopLocation);


		Marker myShopMarker = new Marker(markerOptions1);


		map.addMarker(myShopMarker);



		InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
		infoWindowOptions.content("<h2>ToBeOrToHave</h2>"
				+ "Telephone: 0442345678<br>"
				+ "Web: www.ToBeOrToHave.fr");

		InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
		fredWilkeInfoWindow.open(map, myShopMarker);


	}
}
