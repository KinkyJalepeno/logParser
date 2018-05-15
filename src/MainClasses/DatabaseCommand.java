package MainClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCommand {

    private Connection conn;
    private Statement stmt;
    private String url;



    public DatabaseCommand() throws SQLException {

        url = "jdbc:sqlite:C://sqlite/errorDump.db";
        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();

    }

    public void flushDatabase(){

        String sqlCommand = "DELETE FROM codes;";
        executeCommand(sqlCommand);
    }

    private void executeCommand(String sqlCommand) {

        try {
            stmt.executeQuery(sqlCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
