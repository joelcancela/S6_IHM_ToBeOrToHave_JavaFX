package polytech.si3.ihm.tobeortohave;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import net.miginfocom.layout.Grid;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ProduitsViewController {
    public GridPane productGrid;

    @FXML
    public void initialize() {

    }

    public void pictureClick(MouseEvent mouseEvent) {
        for (Node node : this.productGrid.getChildren()) {
            if (node instanceof ImageView) {
                if( node.getBoundsInParent().contains(mouseEvent.getSceneX(),  mouseEvent.getSceneY())) {
                    System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex( node));
                }
            }
        }
    }
}
