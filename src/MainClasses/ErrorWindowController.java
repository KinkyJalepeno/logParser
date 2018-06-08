package MainClasses;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ErrorWindowController implements Initializable {
    @FXML
    private TextArea textArea;
    private String errorCode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            queryErrorCode();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void queryErrorCode() throws SQLException {

        DatabaseOperation operation = new DatabaseOperation();
        operation.queryErrorCode(textArea, errorCode);

    }
}
