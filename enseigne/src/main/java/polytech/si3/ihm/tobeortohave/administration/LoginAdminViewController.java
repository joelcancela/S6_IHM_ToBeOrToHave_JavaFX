package polytech.si3.ihm.tobeortohave.administration;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


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

    @FXML
    public Label wrongCredentialsLabel;

    private String username;
    private String password;

    private Stage mainStage;

    public void setStage(Stage stg) {
        this.mainStage = stg;
        this.loginButton.getStyleClass().clear();
        this.loginButton.getStyleClass().add("green-button");
        this.cancelButton.getStyleClass().clear();
        this.cancelButton.getStyleClass().add("red-button");
    }

    private boolean checkTextField(TextField txtF) {
        boolean notEmpty = false;
        if (txtF.getText() == null | txtF.getText().trim().isEmpty()) {
            setTextFieldValidity(txtF, false);
        } else {
            setTextFieldValidity(txtF, true);
            notEmpty = true;
        }
        return notEmpty;
    }

    private void setTextFieldValidity(TextField txtF, boolean isValid) {
        if (isValid == false) {
            txtF.getStyleClass().add("error");
        } else {
            txtF.getStyleClass().remove("error");
        }
    }

    public void redirectionToAdmin(){
        String fxmlFile = "/fxml/admin/homeAdmin.fxml";
        FXMLLoader loader = new FXMLLoader();
        try {

            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            Scene scene = new Scene(rootNode);
            scene.getStylesheets().add("/styles/styles.css");

            mainStage.setScene(scene);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void connectionAction() {
        System.out.println("Connect");

        boolean formCompleted = checkTextField(usernameField) & checkTextField(passwordField);
        if (formCompleted) {
            username = usernameField.getText();
            password = passwordField.getText();

            if (username.equals("admin") & password.equals("admin")){
                wrongCredentialsLabel.setVisible(false);
                redirectionToAdmin();
            } else {
                wrongCredentialsLabel.setVisible(true);
            }
        }
    }

    public void cancelAction() {
        System.out.println("Cancel");
        mainStage.close();
    }
}
