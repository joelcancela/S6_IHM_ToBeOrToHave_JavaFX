package polytech.si3.ihm.tobeortohave.model;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Store {

    private Brand brand;
    private String description;
    private String address;
    private Double latitude;
    private Double longitude;
    private List<Product> stock;
    private String phoneNumber;
    private String webAddress;
    private List<Double> CA;
    private int id;

    public Store(Brand brand, String description, String address, Double latitude, Double longitude, List<Product> stock, String phoneNumber, String webAddress, List<Double> CA, int id) {
        this.brand = brand;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stock = stock;
        this.phoneNumber = phoneNumber;
        this.webAddress = webAddress;
        this.CA = CA;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "enseigne=" + brand +
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

    public Brand getBrand() {
        return brand;
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

    public List<Product> getStock() {
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

    public int getId() {
        return id;
    }
}
