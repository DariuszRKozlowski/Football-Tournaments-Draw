package presentation;

import application.DrawEuropaLeague;
import application.TeamEuropaLeague;
import application.TeamWorldCup;
import dao.TeamEuropaLeagueDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OptionsEuropaLeague {

    private static final String tournamentLogo = "src\\main\\resources\\img\\UEFA Europa League\\LOGO.png";
    private static final String name = "UEFA Europa League";
    private final DrawEuropaLeague europaLeagueDraw = new DrawEuropaLeague();
    private final TeamEuropaLeagueDAO europaLeagueDAO = new TeamEuropaLeagueDAO();
    private final String drawProceduresPath = "src\\main\\resources\\draw-procedures\\EuropaLeagueProcedures.txt";

    public static String getTournamentLogo() {
        return tournamentLogo;
    }

    public static String getName() {
        return name;
    }

    public TeamEuropaLeague[][] preparePots() {
        TeamEuropaLeague[][] result = null;
        try {
            List<TeamEuropaLeague> listOfTeams = europaLeagueDraw.sortTeamsOut(europaLeagueDAO.getAll());
            result = europaLeagueDraw.preparePots(listOfTeams);
        } catch (SQLException | IOException exception) {
            System.out.println(exception);
        };
        return result;
    }

    public TeamEuropaLeague[][] drawGroups() {
        TeamEuropaLeague[][] result = null;
        try {
            result = europaLeagueDraw.draw(preparePots());
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public String getDrawProcedures() throws FileNotFoundException {
        return europaLeagueDAO.getProcedures(drawProceduresPath);
    }
}
