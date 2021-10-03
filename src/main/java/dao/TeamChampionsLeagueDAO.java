package dao;

import application.TeamChampionsLeague;
import data.DatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamChampionsLeagueDAO {

    private final static String SELECT_ALL = "SELECT * FROM ChampionsLeagueTeams;";
    private final static CountryDAO countryDAO = new CountryDAO();

    public List<TeamChampionsLeague> getAll() throws IOException, SQLException {
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SELECT_ALL);
        List<TeamChampionsLeague> listOfClubs = new ArrayList<>();
        while(result.next()) {
            String name = result.getString(2);
            String country = countryDAO.getById(result.getInt(3));
            int uefaCoefficient = result.getInt(4);
            boolean isCountryChampion = isCountryChampion(result.getByte(5));
            boolean isPreviousUefaWinner = isPreviousWinner(result.getByte(6));
            String path = result.getString(7);
            listOfClubs.add(new TeamChampionsLeague(name, country, uefaCoefficient, isCountryChampion, isPreviousUefaWinner, path));
        }
        connection.close();
        return listOfClubs;
    }

    private boolean isCountryChampion(byte value) {
        return value == 1;
    }

    private boolean isPreviousWinner(byte value) {
        return value == 1;
    }

}
