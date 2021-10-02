package dao;

import application.TeamConferenceLeague;
import application.TeamEuropaLeague;
import data.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamConferenceLeagueDAO {

    private final static String SELECT_ALL = "SELECT * FROM ConferenceLeagueTeams;";
    private final static CountryDAO countryDAO = new CountryDAO();

    public List<TeamConferenceLeague> getAll() throws IOException, SQLException {
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SELECT_ALL);
        List<TeamConferenceLeague> listOfClubs = new ArrayList<>();
        while(result.next()) {
            String name = result.getString(2);
            String country = countryDAO.getById(result.getInt(3));
            int uefaCoefficient = result.getInt(4);
            listOfClubs.add(new TeamConferenceLeague(name, country, uefaCoefficient));
        }
        connection.close();
        return listOfClubs;
    }

}
