package polytech.si3.ihm.tobeortohave.model;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Product {
    private String name;
    private List<String> keywords;
    private boolean starred;
    private boolean discounted;
    private double discountRate;
    private double price;
    private String picture;
    private int salesNumber;
    private int id;

    public Product(int id, String name, List<String> keywords, boolean starred, boolean discounted, double discountRate, double price, String picture, int salesNumber) {
        this.id = id;
        this.name = name;
        this.keywords = keywords;
        this.starred = starred;
        this.discounted = discounted;
        this.discountRate = discountRate;
        this.price = price;
        this.picture = picture;
        this.salesNumber = salesNumber;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "name='" + name + '\'' +
                ", keywords=" + keywords +
                ", starred=" + starred +
                ", discounted=" + discounted +
                ", discountRate=" + discountRate +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", salesNumber=" + salesNumber +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public boolean isStarred() {
        return starred;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public int getId() {
        return id;
    }
}
