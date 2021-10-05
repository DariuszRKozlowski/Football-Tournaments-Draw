package dao;

import application.TeamEuropeanChampionship;
import application.TeamWorldCup;
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

public class TeamEuropeanChampionshipDAO {

    private final static String SELECT_ALL = "SELECT * FROM EuropeanChampionshipTeams;";

    public List<TeamEuropeanChampionship> getAll() throws IOException, SQLException {
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SELECT_ALL);
        List<TeamEuropeanChampionship> listOfTeams = new ArrayList<>();
        while(result.next()) {
            String country = result.getString(2);
            int uefaCoefficient = result.getInt(3);
            boolean isHostCountry = isHostCountry(result.getByte(4));
            String path = result.getString(5);
            listOfTeams.add(new TeamEuropeanChampionship(country, uefaCoefficient, isHostCountry, path));
        }
        connection.close();
        return listOfTeams;
    }

    private boolean isHostCountry(byte value) {
        return value == 1;
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
