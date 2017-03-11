package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import polytech.si3.ihm.tobeortohave.model.Category;

import java.util.Arrays;
import java.util.List;


public class CategoryController {

    private CommonController commonController;

    @FXML
    public ImageView all;

    @FXML
    public ImageView sport;

    @FXML
    public ImageView literature;

    @FXML
    public ImageView it;

    @FXML
    public ImageView jewel;

    @FXML
    public ImageView craft;

    @FXML
    public ImageView clothes;

    @FXML
    public void initialize() {
        List<ImageView> categories = Arrays.asList(all, sport, literature, it, jewel, craft, clothes);
        for(ImageView imageView : categories){
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                commonController.filterView(Category.valueOf(imageView.getId().toUpperCase()));
                event.consume();
            });
        }

    }

    public void initCommonController(CommonController commonController) {
        this.commonController = commonController;
    }

}
