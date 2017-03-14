package polytech.si3.ihm.tobeortohave.model;

/**
 * Created by Marc on 08/03/2017.
 */
public enum Category {
    ALL("Tous les magasins"),
    SPORT("Sport"),
    LITERATURE("Livres"),
    IT("High-tech"),
    JEWEL("Bijoux"),
    CRAFT("Bricolage"),
    CLOTHES("Vêtements");

    private String display;

    Category(String display) {
        this.display = display;
    }

    public static Category getCategory(String category){
        for(Category category1 : Category.values()){
            if(category1.getDisplay().equals(category)) return category1;
        }
        return null;
    }

    public String getDisplay() {
        return display;
    }
}
