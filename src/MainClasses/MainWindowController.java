package MainClasses;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;

public class MainWindowController {

    @FXML
    private TextField absolutePathLabel;

    @FXML
    private void selectFile(){

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Log Files", "*.log"));

        fileChooser.setTitle("Open SMS CDR");
        File file = fileChooser.showOpenDialog(null);

        if(file != null){
            System.out.println("Selected File: " + file.getAbsolutePath());
            absolutePathLabel.setText(file.getAbsolutePath());
        }

    }

}
