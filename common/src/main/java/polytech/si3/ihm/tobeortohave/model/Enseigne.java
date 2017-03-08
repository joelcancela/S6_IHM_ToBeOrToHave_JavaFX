package polytech.si3.ihm.tobeortohave.model;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Enseigne {
    private String name;
    private List<Field> fieldList;
    private String description;
    private String phone;
    private String webAddress;


    public Enseigne(String name, List<Field> fields, String description, String phone, String webAddress) {
        this.name = name;
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
}
