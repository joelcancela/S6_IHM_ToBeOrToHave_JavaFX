package polytech.si3.ihm.tobeortohave.model;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Magasin {

    private Enseigne enseigne;
    private String description;
    private String address;
    private Double latitude;
    private Double longitude;
    private List<Produit> stock;
    private String phoneNumber;
    private String webAddress;
    private List<Double> CA;

    public Magasin(Enseigne enseigne, String description, String address, Double latitude, Double longitude, List<Produit> stock, String phoneNumber, String webAddress, List<Double> CA) {
        this.enseigne = enseigne;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stock = stock;
        this.phoneNumber = phoneNumber;
        this.webAddress = webAddress;
        this.CA = CA;
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "enseigne=" + enseigne +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", stock=" + stock +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", webAddress='" + webAddress + '\'' +
                ", CA=" + CA +
                '}';
    }

    public Enseigne getEnseigne() {
        return enseigne;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<Produit> getStock() {
        return stock;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public List<Double> getCA() {
        return CA;
    }
}
