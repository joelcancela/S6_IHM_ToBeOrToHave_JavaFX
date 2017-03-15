package polytech.si3.ihm.tobeortohave;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class AdminViewController implements Initializable {

    // data
    @FXML
    private TextField input_about_us_title;
    @FXML
    private TextField input_about_us;
    @FXML
    private TextField input_strength_title;
    @FXML
    private TextField input_strength;

    private ResourceBundle rb;
	public void initialize(URL url, ResourceBundle rb) {

        input_about_us_title.setText(rb.getString("key.about_us_title"));
        input_about_us.setText(rb.getString("key.about_us_text"));

        input_strength_title.setText(rb.getString("key.strength_title"));
        input_strength.setText(rb.getString("key.strength_text"));

        this.rb = rb;
	}

    public void onAboutUsTitleChanged(Event e) {
	    saveToDB("key.about_us_title", input_about_us_title.getText());
    }

    public void onAboutUsChanged(Event e) {
        saveToDB("key.about_us_text", input_about_us.getText());
    }

    public void onStrengthTitleChanged(Event e) {
        saveToDB("key.strength_title", input_strength_title.getText());
    }

    public void onStrengthChanged(Event e) {
        saveToDB("key.strength_text", input_strength.getText());
    }

    private void saveToDB(String key, String value) {
        try {
            Properties props = new Properties();
            FileInputStream f = new FileInputStream("./magasin/src/main/resources/i18n/Bundle_" + rb.getLocale() + ".properties" );

            props.load(f);
            f.close();
            props.setProperty(key, value);

            OutputStream out = new FileOutputStream( "./magasin/src/main/resources/i18n/Bundle_" + rb.getLocale() + ".properties" );
            props.store(out, "");
            out.close();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
