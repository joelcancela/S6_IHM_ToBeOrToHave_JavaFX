package polytech.si3.ihm.tobeortohave.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.List;

/**
 * Created by MARC-PC on 07/03/2017.
 */
public class EventScrollingController {

    @FXML
    public ImageView eventImage;

    @FXML
    public Button leftButtonEvent;

    @FXML
    public Button rightButtonEvent;

    @FXML
    public ToggleGroup group;

    @FXML
    public HBox radioButtonHBoxEvent;

    @FXML
    private void initialize(){

    }

    public void initEvents(List<String> eventsPaths){}
}
