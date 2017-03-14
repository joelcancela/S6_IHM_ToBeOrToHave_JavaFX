package polytech.si3.ihm.tobeortohave.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MARC-PC on 07/03/2017.
 */
public class ProductScrollingController {
    private List<Image> productsImage;
    private List<RadioButton> radioButtons;
    private int indexImg;

    @FXML
    public Button rightButton;

    @FXML
    public Button leftButton;

    @FXML
    public RadioButton radio1;

    @FXML
    public RadioButton radio2;

    @FXML
    public RadioButton radio3;

    @FXML
    public ImageView productImage;

    @FXML
    private void initialize(){

    }

    private void right(){
        if(indexImg == productsImage.size() - 1){
            indexImg = 0;
        }
        else{
            indexImg++;
        }
        productImage.setImage(productsImage.get(indexImg));
        setRadioButtons(indexImg);
    }

    private void left(){
        if(indexImg == 0){
            indexImg = productsImage.size() - 1;
        }
        else{
            indexImg--;
        }
        setRadioButtons(indexImg);
    }

    private void setRadioButtons(int selected){
        indexImg = selected;
        radioButtons.get(indexImg).setSelected(true);
        productImage.setImage(productsImage.get(indexImg));
    }

    public void init(List<String> products) {
        productsImage = new ArrayList<>();
        radioButtons = new ArrayList<>();
        radioButtons.add(radio1);
        radioButtons.add(radio2);
        radioButtons.add(radio3);
        for(String product : products){
            System.out.println(product);
            productsImage.add(new Image(product));
        }
        rightButton.setOnAction((ActionEvent event) -> right());
        leftButton.setOnAction((ActionEvent event) -> left());
        radio1.setOnAction((ActionEvent event) -> setRadioButtons(0));
        radio2.setOnAction((ActionEvent event) -> setRadioButtons(1));
        radio3.setOnAction((ActionEvent event) -> setRadioButtons(2));
        productImage.setImage(productsImage.get(0));
        radioButtons.get(0).setSelected(true);
        indexImg = 0;
    }
}
