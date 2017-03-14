package polytech.si3.ihm.tobeortohave.administration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 * Created by Nassim Bounouas
 */
public class LoginAdminViewController {

    @FXML
    public Button loginButton;

    @FXML
    public Button cancelButton;

    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;

    public void connectionAction() {
        System.out.println("Connect");
    }

    public void cancelAction() {
        System.out.println("Cancel");
    }
}
