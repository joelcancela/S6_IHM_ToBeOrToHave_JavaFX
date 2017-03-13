package polytech.si3.ihm.tobeortohave.controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import polytech.si3.ihm.tobeortohave.model.CommercialCenter;
import polytech.si3.ihm.tobeortohave.parser.CommercialCenterParser;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Jehan on 12/03/2017.
 */
public class InfosSupController implements Initializable, MapComponentInitializedListener {


    @FXML
    public GoogleMapView googleMap;

    @FXML
    public LineChart annualVisitors;

    @FXML
    public NumberAxis yAxisAnnualVisitor;

    private GoogleMap map;

    @FXML
    public BarChart age;

    @FXML
    public PieChart profil;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        googleMap.addMapInializedListener(this);
        initializeStats();
    }

    private CommercialCenter commercialCenter;

    public void initModel(CommercialCenter commercialCenter) {
        this.commercialCenter = commercialCenter;
    }

    private void initializeStats(){
        CommercialCenterParser parser = new CommercialCenterParser();
        Map<String, Double> visitorsPerYear = parser.getVisitorsPerYear();
        Map<String, Integer> visitorsAge = parser.getVisitorsAge();
        Map<String, Integer> visitorsProfile = parser.getVisitorsProfile();

        // Init visitors per year
        XYChart.Series series = new XYChart.Series<>();
        for(Map.Entry<String, Double> visitorYear : visitorsPerYear.entrySet()){
            series.getData().add(new XYChart.Data<>(visitorYear.getKey(), visitorYear.getValue()));
        }

        annualVisitors.getData().add(series);
        annualVisitors.setLegendVisible(false);

        yAxisAnnualVisitor.setLabel("Visiteurs (En millions)");
        /*yAxisAnnualVisitor.setAutoRanging(false);
        yAxisAnnualVisitor.setLowerBound(visitorsPerYear.get("2010") - 1);
        yAxisAnnualVisitor.setUpperBound(visitorsPerYear.get("2016") + 1);*/

        // Init age of visitors
        series = new XYChart.Series<>();
        for(Map.Entry<String, Integer> visitorAge : visitorsAge.entrySet()){
            series.getData().add(new XYChart.Data<>(visitorAge.getKey(), visitorAge.getValue()));
        }
        age.getData().add(series);
        age.setLegendVisible(false);
        age.getYAxis().setLabel("Pourcentage des visiteurs");
        age.getXAxis().setLabel("Age");

        // Init visitors profiles
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(Map.Entry<String, Integer> visitorProfile : visitorsProfile.entrySet()){
            pieChartData.add(new PieChart.Data(visitorProfile.getKey(), visitorProfile.getValue()));
        }
        profil.setData(pieChartData);
        profil.setLegendVisible(false);

        // Set values
        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty(), " %"
                        )
                )
        );

    }

    @Override
    public void mapInitialized() {
        LatLong commercialCenterLocation = new LatLong(43.2916976, 5.4766483);


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
                .zoom(18)
                .styleString("[{featureType: \"poi\",stylers: [{ visibility: \"off\" }]}]");

        map = googleMap.createMap(mapOptions);

        //Add markers to the map
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(commercialCenterLocation);


        Marker commercialCenterMarker = new Marker(markerOptions1);


        map.addMarker(commercialCenterMarker);



        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("<h2>Cap Sophia</h2>"
                + "Telephone: 03 84 34 56 78<br>"
                + "Web: www.centrecommercial.fr");

        InfoWindow InfoWindow = new InfoWindow(infoWindowOptions);
        InfoWindow.open(map, commercialCenterMarker);
    }


}
