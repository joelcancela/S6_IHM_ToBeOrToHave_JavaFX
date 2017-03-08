package polytech.si3.ihm.tobeortohave;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import jdk.nashorn.internal.parser.JSONParser;
import net.miginfocom.layout.Grid;
import org.json.JSONObject;
import polytech.si3.ihm.tobeortohave.model.JSONReader;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ProduitsViewController {
    public GridPane productGrid;
    public GridPane bestSellerGrid;
    private JSONReader jsonReader;


    @FXML
    public void initialize() {
        jsonReader = new JSONReader();
        jsonReader.parse();

    }

    public void pictureClick(MouseEvent mouseEvent) {
        System.out.println("Click click");
        for (Node node : this.productGrid.getChildren()) {
            if (node instanceof ImageView) {
                System.out.println(node + " : " + ((ImageView) node).getX() + ";" + ((ImageView) node).getY());
                if( node.getBoundsInParent().contains(mouseEvent.getSceneX(),  mouseEvent.getSceneY())) {
                    System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex( node));
                }
            }

        }

        for (Node node : this.bestSellerGrid.getChildren()) {
            if (node instanceof ImageView) {
                System.out.println(node);
                if( node.getBoundsInParent().contains(mouseEvent.getSceneX(),  mouseEvent.getSceneY())) {
                    System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex( node));
                }
            }

        }
    }
}
