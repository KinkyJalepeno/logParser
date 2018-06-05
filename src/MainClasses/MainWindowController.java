package MainClasses;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private String filePath;

    @FXML
    private Label statusLabel;
    @FXML
    private Label recordsLabel;

    @FXML private Label code0;
    @FXML private Label code1;
    @FXML private Label code2;
    @FXML private Label code3;
    @FXML private Label code4;
    @FXML private Label code5;
    @FXML private Label code6;
    @FXML private Label code7;
    @FXML private Label code8;
    @FXML private Label code9;
    @FXML private Label code10;
    @FXML private Label code11;
    @FXML private Label code12;
    @FXML private Label code13;
    @FXML private Label code14;
    @FXML private Label code15;

    @FXML
    private TextField absolutePathLabel;

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
    private void loadFile() throws IOException, SQLException {

        DatabaseOperation parseFile = new DatabaseOperation(filePath);
        parseFile.executeParse(statusLabel);

        int count = parseFile.getRecordCount();
        recordsLabel.setText(String.valueOf(count));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            DatabaseOperation cleanDatabase = new DatabaseOperation();
            cleanDatabase.executeFlush();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void errorCountsToLabels(){

        Label[] labels = {code0, code1, code2, code3, code4, code5, code6, code7, code8, code9, code10, code11
        , code12, code13, code14, code15};

        //TODO from here I need to think about storing labels in an array
    }
}