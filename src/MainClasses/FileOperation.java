package MainClasses;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class FileOperation {

    private FileReader txtIn;
    private BufferedReader readIn;

    private String line = "fake value";
    private String card;
    private String port;
    private String errorCode;
    private DatabaseCommand command;

    private int count;


    public FileOperation(String filePath) throws FileNotFoundException, SQLException {

        txtIn = new FileReader(filePath);
        readIn = new BufferedReader(txtIn);
        command = new DatabaseCommand();

    }

    public void readFile(Label recordsLabel) throws IOException {

        while (line != null) {
            count++;
            line = readIn.readLine();
            extractErrorCode(line);
        }
        txtIn.close();
        readIn.close();

        Platform.runLater(()->recordsLabel.setText(String.valueOf(count)));
    }

    private void extractErrorCode(String line) {


        if (line != null) {

            String errorArray[] = line.split("[|]");

            card = (errorArray[1]);
            port = (errorArray[2]);
            errorCode = (errorArray[5]);


            if (errorCode.contains("confirmation")) {
                return;
            } else {
                //System.out.println("Card: " + card + " Port: " + port + " Send Status = " + errorCode);
                command.writeToDatabase(card, port, errorCode);
            }
        }
        command.writeToDatabase(null,null,null);
    }
}
