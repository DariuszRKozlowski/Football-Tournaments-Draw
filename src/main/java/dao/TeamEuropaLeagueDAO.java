package dao;

import application.TeamEuropaLeague;
import data.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamEuropaLeagueDAO {

    private final static String SELECT_ALL = "SELECT * FROM EuropaLeagueTeams;";
    private final static CountryDAO countryDAO = new CountryDAO();

    public List<TeamEuropaLeague> getAll() throws IOException, SQLException {
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SELECT_ALL);
        List<TeamEuropaLeague> listOfClubs = new ArrayList<>();
        while(result.next()) {
            String name = result.getString(2);
            String country = countryDAO.getById(result.getInt(3));
            int uefaCoefficient = result.getInt(4);
            String path = result.getString(5);
            listOfClubs.add(new TeamEuropaLeague(name, country, uefaCoefficient, path));
        }
        connection.close();
        return listOfClubs;
    }

}
