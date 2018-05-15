package MainClasses;

import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class FileLoader {

    private FileReader txtIn;
    private BufferedReader readIn;
    private String line = "fake value";


    public FileLoader(String filePath) throws FileNotFoundException {

        txtIn = new FileReader(filePath);
        readIn = new BufferedReader(txtIn);

    }

    public void readFile(Label recordsLabel) throws IOException, SQLException {

        int recordCount = 0;
        while (line != null) {
            line = readIn.readLine();

            recordCount++;
            recordsLabel.setText(String.valueOf(recordCount - 1));

            extractErrorCode(line);
        }
        txtIn.close();
        readIn.close();
    }

    private void extractErrorCode(String line) {

        if (line != null) {
            String errorArray[] = line.split("[|]");
            String errorCode = (errorArray[5]);
            if (errorCode.contains("confirmation")) {
                return;
            }else {
                System.out.println("errorCode = " + errorCode);
            }
        }
    }
}
