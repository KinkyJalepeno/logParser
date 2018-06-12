package MainClasses;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private String filePath;
    private String labelValue;

    @FXML
    private Label statusLabel;
    @FXML
    private Label recordsLabel;

    @FXML
    private Label code0;
    @FXML
    private Label code1;
    @FXML
    private Label code2;
    @FXML
    private Label code3;
    @FXML
    private Label code4;
    @FXML
    private Label code5;
    @FXML
    private Label code6;
    @FXML
    private Label code7;
    @FXML
    private Label code8;
    @FXML
    private Label code9;
    @FXML
    private Label code10;
    @FXML
    private Label code11;
    @FXML
    private Label code12;
    @FXML
    private Label code13;
    @FXML
    private Label code14;
    @FXML
    private Label code15;

    @FXML
    private TextField absolutePathLabel;
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            DatabaseOperation cleanDatabase = new DatabaseOperation();
            cleanDatabase.executeFlush();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void selectFile() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Log Files", "*.log"));

        fileChooser.setTitle("Open SMS CDR");
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {

            this.filePath = (file.getAbsolutePath());
            absolutePathLabel.setText(file.getAbsolutePath());
        }

    }

    @FXML
    private void queryError0() throws SQLException {

        labelValue = code0.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError1() throws SQLException {

        labelValue = code1.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError2() throws SQLException {

        labelValue = code2.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError3() throws SQLException {

        labelValue = code3.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError4() throws SQLException {

        labelValue = code4.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError5() throws SQLException {

        labelValue = code5.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError6() throws SQLException {

        labelValue = code6.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError7() throws SQLException {

        labelValue = code7.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError8() throws SQLException {

        labelValue = code8.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError9() throws SQLException {

        labelValue = code9.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError10() throws SQLException {

        labelValue = code10.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError11() throws SQLException {

        labelValue = code11.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError12() throws SQLException {

        labelValue = code12.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError13() throws SQLException {

        labelValue = code13.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError14() throws SQLException {

        labelValue = code14.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void queryError15() throws SQLException {

        labelValue = code15.getText();
        System.out.println("error = " + labelValue);

        if(labelValue != null){
            sendQuery(labelValue);
        }
        return;
    }

    @FXML
    private void loadFile() throws IOException, SQLException {

        DatabaseOperation operation = new DatabaseOperation(filePath);

        operation.executeParse(statusLabel);

        int count = operation.getRecordCount();
        recordsLabel.setText(String.valueOf(count));

        flushLabels();

    }

    private void flushLabels() throws SQLException {

        Label[] labels = {code0, code1, code2, code3, code4, code5, code6, code7, code8, code9, code10, code11
                , code12, code13, code14, code15};

        for (int i = 0; i < labels.length; i++) {

            labels[i].setText("");
        }

        textArea.clear();

        DatabaseOperation operation = new DatabaseOperation();
        operation.getErrors(labels);
    }

    private void sendQuery(String labelValue) throws SQLException {

        textArea.clear();

        String error[] = labelValue.split("[\\s]");
        String errorCode = error[0];

        DatabaseOperation operation = new DatabaseOperation();
        operation.queryErrorCode(textArea, errorCode);
    }


}