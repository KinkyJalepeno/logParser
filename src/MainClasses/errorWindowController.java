package MainClasses;

import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class errorWindowController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            DatabaseOperation operation = new DatabaseOperation();
            operation.queryErrorCode();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
