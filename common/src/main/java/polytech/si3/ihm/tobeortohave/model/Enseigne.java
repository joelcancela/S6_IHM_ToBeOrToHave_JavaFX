package polytech.si3.ihm.tobeortohave.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Enseigne {
    private String name;
    private String logo;
    private List<Field> fieldList;
    private String description;
    private String phone;
    private String webAddress;


    public Enseigne(String name,String logo, List<Field> fields, String description, String phone, String webAddress) {
        this.name = name;
        this.logo = logo;
        this.fieldList = fields;
        this.description = description;
        this.phone = phone;
        this.webAddress = webAddress;
    }

    @Override
    public String toString() {
        return "Enseigne{" +
                "name='" + name + '\'' +
                ", fieldList=" + fieldList +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", webAddress='" + webAddress + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getLogo(){return logo;}

    public List<Field> getFieldList() {
        return fieldList;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public static List<Magasin> findMagasinByBrand(List<Magasin> magasins, final String brandName){
        return magasins.stream().filter(m -> m.getEnseigne().getName().equals(brandName)).collect(Collectors.toList());
    }
}
