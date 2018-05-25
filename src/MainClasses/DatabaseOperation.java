package MainClasses;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DatabaseOperation {


    private String line;
    private FileReader reader;
    private BufferedReader txtIn;
    private int count;

    private Connection conn;
    private Statement stmt;
    private String url;
    private PreparedStatement ps;


    public DatabaseOperation(String filePath) throws FileNotFoundException, SQLException {

        reader = new FileReader(filePath);
        txtIn = new BufferedReader(reader);

        url = "jdbc:sqlite:C://sqlite/errorDump.db";
        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();
        ps = conn.prepareStatement("insert into codes (card, port, errorCode) values (?,?,?)");

    }

    public DatabaseOperation() throws SQLException {

        url = "jdbc:sqlite:C://sqlite/errorDump.db";
        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();

    }


    public void executeFlush() {

        String sqlCommand = "DELETE FROM codes;";
        try {
            stmt.executeQuery(sqlCommand);
        } catch (SQLException e) {

        }
    }

    void executeParse(Label statusLabel) throws IOException, SQLException {

        String tmp = txtIn.readLine();
        conn.setAutoCommit(false);

        while (tmp != null) {
            line = tmp;

            count++;

            String errorArray[] = line.split("[|]");

            String card = (errorArray[1]);
            String port = (errorArray[2]);
            String errorCode = (errorArray[5]);

            ps.setInt(1, Integer.parseInt(card));
            ps.setInt(2, Integer.parseInt(port));
            ps.setString(3, (errorCode));
            ps.addBatch();

            tmp = txtIn.readLine();
        }
        Platform.runLater(()-> statusLabel.setText("Completed.."));

        executeBatchAndClose();
    }

    void executeBatchAndClose() throws SQLException, IOException {

        ps.executeBatch();
        conn.commit();

        ps.close();
        reader.close();
        txtIn.close();
        conn.close();

        System.out.println("Job done !!!");
        //TODO from here I need to think about storing labels in an array

    }

    public int getRecordCount(){

        return count;
    }
}
