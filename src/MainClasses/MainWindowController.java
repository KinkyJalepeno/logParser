package MainClasses;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private void selectFile(){

        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open SMS CDR");
        fileChooser.showOpenDialog(stage);

    }


}
