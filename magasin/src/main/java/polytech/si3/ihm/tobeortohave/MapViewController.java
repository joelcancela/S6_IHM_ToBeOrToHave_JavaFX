package polytech.si3.ihm.tobeortohave;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import jdk.nashorn.internal.parser.JSONParser;
import polytech.si3.ihm.tobeortohave.model.JSONReader;

import java.net.URL;
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

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		map.setCenter(new LatLong(40.2916159, 15.4768394));
	}
}
