package polytech.si3.ihm.tobeortohave.model;

import javafx.scene.image.Image;

import java.util.List;
import java.util.Random;

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

    private boolean isHighlighted;
    private Category category;
    private String name;
    private Image logo;

    public Store(Brand brand, String description, String address, Double latitude, Double longitude, List<Product> stock, String phoneNumber, String webAddress, List<Double> CA, int id) {
        this.brand = brand;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stock = stock;
        this.isHighlighted = new Random().nextBoolean();
        this.phoneNumber = phoneNumber;
        this.webAddress = webAddress;
        this.CA = CA;
        this.id = id;
        if (brand.getLogo().isEmpty())
            logo = new Image("images/logoShop.png");
        else
            logo = new Image(brand.getLogo());
        this.name = brand.getName();
    }

    /**
     * Custom Store used by the Commercial Center
     */
    public Store(String description, String phoneNumber, String webAddress, boolean isHighlighted, Category category, String name, Image logo) {
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.webAddress = webAddress;
        this.isHighlighted = isHighlighted;
        this.category = category;
        this.name = name;
        this.logo = logo;
        this.address = "NICE";
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

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public Image getLogo() {
        return logo;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
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
