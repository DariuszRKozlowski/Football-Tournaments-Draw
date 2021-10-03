package dao;

import application.Country;
import data.DatabaseConnector;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    private static final String SELECT_ALL = "SELECT * FROM Countries";
    private static final String SELECT_TOP8 = "SELECT TOP 8 * FROM Countries ORDER BY uefa_rating DESC;";
    private static final String FILTER = " WHERE id = ";
    private static final String ENDING = ";";

    public List<Country> getAll() throws IOException, SQLException {
        String query = SELECT_ALL + ENDING;
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        List<Country> listOfCountries = new ArrayList<>();
        while(result.next()) {
            String name = result.getString(2);
            int rating = result.getInt(3);
            listOfCountries.add(new Country(name, rating));
        }
        connection.close();
        return listOfCountries;
    }

    public String getById(int id) throws IOException, SQLException {
        String query = SELECT_ALL + FILTER + id + ENDING;
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        String countryName = null;
        while(result.next()) {
            countryName = result.getString(2);
        }
        connection.close();
        return countryName;
    }

    public List<String> getTopEight() throws IOException, SQLException {
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SELECT_TOP8);
        List<String> countriesNames = new ArrayList<>();
        while(result.next()) {
            countriesNames.add(result.getString(2));
        }
        connection.close();
        return countriesNames;
    }
}
