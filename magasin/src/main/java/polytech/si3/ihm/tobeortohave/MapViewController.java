package polytech.si3.ihm.tobeortohave;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
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
		List<Magasin> magasinsTboth = Enseigne.findMagasinByBrand(jsonReader.getStores(), "ToBeOrToHave");
		Magasin magasinDefault = magasinsTboth.get(0);
		LatLong defaultShopLocation = new LatLong(magasinDefault.getLatitude(), magasinDefault.getLongitude());


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


		vbox.setSpacing(10.0);
		for (int i = 0; i < magasinsTboth.size(); i++) {
			Magasin magasin = magasinsTboth.get(i);
			Button button = new Button(magasin.getAddress());
			button.setStyle("-fx-font-size: 20px;");
			button.addEventHandler(MouseEvent.MOUSE_CLICKED,
					e -> {
						map.clearMarkers();
						LatLong latLong = new LatLong(magasin.getLatitude(), magasin.getLongitude());
						//Add markers to the map
						MarkerOptions markerOptions = new MarkerOptions();
						markerOptions.position(latLong);

						Marker myShopMarker = new Marker(markerOptions);

						map.addMarker(myShopMarker);

						InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
						infoWindowOptions.content("<h2>ToBeOrToHave "+magasin.getAddress().toUpperCase()+"</h2>"
								+ "Telephone: " + magasin.getPhoneNumber() + "<br>"
								+ "Web: " + magasin.getWebAddress());

						InfoWindow InfoWindow = new InfoWindow(infoWindowOptions);
						InfoWindow.open(map, myShopMarker);

						map.setCenter(latLong);
					});
			if (i == 0) {
				button.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED, 1, 2, 3, 4, MouseButton.PRIMARY, 5, true, true, true, true, true, true, true, true, true, true, null));
			}
			vbox.getChildren().add(button);
		}


	}
}
