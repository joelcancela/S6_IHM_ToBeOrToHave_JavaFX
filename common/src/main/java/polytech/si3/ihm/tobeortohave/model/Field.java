package polytech.si3.ihm.tobeortohave.model;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Field {
    private final String name;
    private List<String> keywords;

    public Field(String name, List<String> keywords) {
        this.name = name;
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", keywords=" + keywords +
                '}';
    }
}
