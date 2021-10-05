package presentation;

import application.DrawConferenceLeague;
import application.TeamConferenceLeague;
import application.TeamEuropaLeague;
import dao.TeamConferenceLeagueDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OptionsConferenceLeague {

    private static final String tournamentLogo = "src\\main\\resources\\img\\UEFA Conference League\\LOGO.png";
    private static final String name = "UEFA Conference League";
    private final DrawConferenceLeague conferenceLeagueDraw = new DrawConferenceLeague();
    private final TeamConferenceLeagueDAO conferenceLeagueDAO = new TeamConferenceLeagueDAO();
    private final String drawProceduresPath = "src\\main\\resources\\draw-procedures\\ConferenceLeagueProcedures.txt";

    public static String getTournamentLogo() {
        return tournamentLogo;
    }

    public static String getName() {
        return name;
    }

    public TeamConferenceLeague[][] preparePots() {
        TeamConferenceLeague[][] result = null;
        try {
            List<TeamConferenceLeague> listOfTeams = conferenceLeagueDraw.sortTeamsOut(conferenceLeagueDAO.getAll());
            result = conferenceLeagueDraw.preparePots(listOfTeams);
        } catch (SQLException | IOException exception) {
            System.out.println(exception);
        };
        return result;
    }

    public TeamConferenceLeague[][] drawGroups() {
        TeamConferenceLeague[][] result = null;
        try {
            result = conferenceLeagueDraw.draw(preparePots());
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public String getDrawProcedures() throws FileNotFoundException {
        return conferenceLeagueDAO.getProcedures(drawProceduresPath);
    }
}
