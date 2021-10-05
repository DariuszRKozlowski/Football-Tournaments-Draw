package dao;

import application.TeamWorldCup;
import data.DatabaseConnector;

import javax.imageio.ImageIO;
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

public class TeamWorldCupDAO {

    private final static String SELECT_ALL = "SELECT * FROM WorldCupTeams;";
    private final static FederationsDAO federationsDAO = new FederationsDAO();

    public List<TeamWorldCup> getAll() throws IOException, SQLException {
        Connection connection = DatabaseConnector.connectToDatabase();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SELECT_ALL);
        List<TeamWorldCup> listOfTeams = new ArrayList<>();
        while(result.next()) {
            String country = result.getString(2);
            String federation = federationsDAO.getById(result.getInt(3));
            int fifaRank = result.getInt(4);
            boolean isHostCountry = isHostCountry(result.getByte(5));
            String path = result.getString(6);
            listOfTeams.add(new TeamWorldCup(country, federation, fifaRank, isHostCountry, path));
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
