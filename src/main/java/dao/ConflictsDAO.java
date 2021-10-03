package dao;

import data.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConflictsDAO {

    private final static String SELECT_ALL = "SELECT * FROM Conflicts";
    private final static String FILTER = " WHERE country = '";
    private final static String ENDING = "';";

    public List<String> getEnemies(String country) throws IOException, SQLException {
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        String query = SELECT_ALL + FILTER + country + ENDING;
        ResultSet result = statement.executeQuery(query);
        List<String> listOfEnemies = new ArrayList<>();
        while(result.next()) {
            listOfEnemies.add(result.getString(3));
        }
        connection.close();
        return listOfEnemies;
    }

}
