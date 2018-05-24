package MainClasses;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class parseFileThread implements Runnable {

    private String filePath;
    private Label recordsLabel;
    private Label statusLabel;


    public parseFileThread(String filePath, Label recordsLabel, Label statusLabel) {

        this.filePath = filePath;
        this.recordsLabel = recordsLabel;
        this.statusLabel = statusLabel;
    }

    @Override
    public void run() {

        FileOperation loader = null;
        try {
            loader = new FileOperation(filePath);
            loader.readFile(recordsLabel);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Platform.runLater(()->statusLabel.setText("Completed...."));
    }
}
