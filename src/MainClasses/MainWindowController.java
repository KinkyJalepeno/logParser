package MainClasses;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainWindowController {

    private String filePath;
    private String url = "jdbc:sqlite:C://sqlite/errorDump.db";

    @FXML
    private Label statusLabel;
    @FXML
    private Label recordsLabel;

//    @FXML private Label code1;
//    @FXML private Label code2;
//    @FXML private Label code3;
//    @FXML private Label code4;
//    @FXML private Label code5;
//    @FXML private Label code6;
//    @FXML private Label code7;
//    @FXML private Label code8;
//    @FXML private Label code9;
//    @FXML private Label code10;
//    @FXML private Label code11;
//    @FXML private Label code12;
//    @FXML private Label code13;
//    @FXML private Label code14;
//    @FXML private Label code15;
//    @FXML private Label code16;
//
//    @FXML private Label count1;
//    @FXML private Label count2;
//    @FXML private Label count3;
//    @FXML private Label count4;
//    @FXML private Label count5;
//    @FXML private Label count6;
//    @FXML private Label count7;
//    @FXML private Label count8;
//    @FXML private Label count9;
//    @FXML private Label count10;
//    @FXML private Label count11;
//    @FXML private Label count12;
//    @FXML private Label count13;
//    @FXML private Label count14;
//    @FXML private Label count15;
//    @FXML private Label count16;

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
    private void loadFile() {

        statusLabel.setText("Reading CDR....");

        (new Thread(new parseFile(filePath, url, recordsLabel, statusLabel))).start();

    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        try {
//            DatabaseCommand command = new DatabaseCommand(url);
//            command.flushDatabase();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
