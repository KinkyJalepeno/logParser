package MainClasses;

import java.sql.*;

public class DatabaseCommand {

    private Connection conn;
    private Statement stmt;
    private String url;
    private PreparedStatement ps;



    public DatabaseCommand() throws SQLException {

        url = "jdbc:sqlite:C://sqlite/errorDump.db";
        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();
        ps = conn.prepareStatement("insert into codes (card, port, errorCode) values (?,?,?)");

    }

    public void flushDatabase() {

        String sqlCommand = "DELETE FROM codes;";
        try {
            stmt.executeQuery(sqlCommand);
        } catch (SQLException e) {

        }
    }

    public void writeToDatabase(String card, String port, String errorCode) throws SQLException {

        if(errorCode.contains("confirmation")){
            return;
        }else {

            ps.setInt(1, Integer.parseInt(card));
            ps.setInt(2, Integer.parseInt(port));
            ps.setString(3, (errorCode));
            ps.addBatch();
        }
        ps.executeBatch();
    }

}
