package MainClasses;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;

public class parseFile implements Runnable {

    private String url;
    private String filePath;
    private Label recordsLabel;
    private Label statusLabel;


    public parseFile(String filePath, String url, Label recordsLabel, Label statusLabel) {

        this.url = url;
        this.filePath = filePath;
        this.recordsLabel = recordsLabel;
        this.statusLabel = statusLabel;
    }

    @Override
    public void run() {

        FileLoader loader = null;
        try {
            loader = new FileLoader(filePath);
            loader.readFile(recordsLabel);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                statusLabel.setText("Completed...");

            }
        });
    }
}
