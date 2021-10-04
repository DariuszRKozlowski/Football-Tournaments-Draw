package presentation;

import application.DrawChampionsLeague;
import application.TeamChampionsLeague;
import application.TeamWorldCup;
import dao.TeamChampionsLeagueDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OptionsChampionsLeague {

    private static final String tournamentLogo = "src\\main\\resources\\img\\UEFA Champions League\\LOGO.png";
    private static final String name = "UEFA Champions League";
    private final DrawChampionsLeague drawChampionsLeague = new DrawChampionsLeague();
    private final TeamChampionsLeagueDAO championsLeagueDAO = new TeamChampionsLeagueDAO();

    public static String getTournamentLogo() {
        return tournamentLogo;
    }

    public static String getName() {
        return name;
    }

    public TeamChampionsLeague[][] preparePots() {
        TeamChampionsLeague[][] result = null;
        try {
            List<TeamChampionsLeague> listOfTeams = drawChampionsLeague.sortTeamsOut(championsLeagueDAO.getAll());
            result = drawChampionsLeague.preparePots(listOfTeams);
        } catch (SQLException | IOException exception) {
            System.out.println(exception);
        };
        return result;
    }

    public TeamChampionsLeague[][] drawGroups() {
        TeamChampionsLeague[][] result = null;
        try {
            result = drawChampionsLeague.draw(preparePots());
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }

}
