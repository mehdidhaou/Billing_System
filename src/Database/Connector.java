package Database;

import java.sql.*;

public class Connector {

    private Connection start = null;
    private Statement statement = null;
    private ResultSet result = null;
    private int update = 0;

    private void connect() {
        try {
            start = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/billingsystem", "root", "root");
        } catch (SQLException ex) {
            System.err.println("Failed to connect to database");
            ex.printStackTrace();
        }
    }

    public ResultSet read(String query) throws SQLException {
        try {
            connect();
            statement = start.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }

    public int create(String query) throws SQLException {
        try {
            connect();
            statement = start.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            update = statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
        return update;
    }

    public void end() throws SQLException {
        start.close();
        statement.close();
    }

}




