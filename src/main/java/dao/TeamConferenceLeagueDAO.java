package dao;

import application.TeamConferenceLeague;
import application.TeamEuropaLeague;
import data.DatabaseConnector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            String path = result.getString(5);
            listOfClubs.add(new TeamConferenceLeague(name, country, uefaCoefficient, path));
        }
        connection.close();
        return listOfClubs;
    }

    public String getProcedures(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        String result = "";
        while(scanner.hasNextLine()) {
            result += scanner.nextLine() + "\n";
        }
        return result;
    }

}
