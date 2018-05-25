package MainClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class parseFileThread implements Runnable {


    private String line;
    private FileReader reader;
    private BufferedReader txtIn;
    private DatabaseCommand command;
    private int count;

    private Connection conn;
    private Statement stmt;
    private String url;
    private PreparedStatement ps;


    public parseFileThread(String filePath) throws FileNotFoundException, SQLException {

        reader = new FileReader(filePath);
        txtIn = new BufferedReader(reader);

        url = "jdbc:sqlite:C://sqlite/errorDump.db";
        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();
        ps = conn.prepareStatement("insert into codes (card, port, errorCode) values (?,?,?)");

    }

    @Override
    public void run() {

        try {
            readAndParseFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void readAndParseFile() throws IOException, SQLException {

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
        executeAndClose();
    }

    private void executeAndClose() throws SQLException, IOException {

        ps.executeBatch();
        conn.commit();

        ps.close();
        reader.close();
        txtIn.close();
        conn.close();

        System.out.println("Job done !!!");

    }
}
