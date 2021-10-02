package dao;

import data.DatabaseConnector;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class FederationsDAO {

    private final static String SELECT_ALL = "SELECT federation_name FROM Federations";
    private final static String FILTER = " WHERE id = ";
    private final static String ENDING = ";";

    public String getById(int id) throws IOException, SQLException {
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        String query = SELECT_ALL + FILTER + id + ENDING;
        ResultSet result = statement.executeQuery(query);
        String federation = null;
        while(result.next()) {
            federation = result.getString(1);
        }
        connection.close();
        return federation;
    }
}
