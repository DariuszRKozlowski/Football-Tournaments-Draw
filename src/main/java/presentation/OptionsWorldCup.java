package presentation;

import application.Draw;
import application.DrawWorldCup;
import application.Team;
import application.TeamWorldCup;
import dao.TeamWorldCupDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OptionsWorldCup {

    private static final String tournamentLogo = "src\\main\\resources\\img\\FIFA World Cup 2018\\LOGO.png";
    private final DrawWorldCup worldCupDraw = new DrawWorldCup();
    private final TeamWorldCupDAO worldCupDAO = new TeamWorldCupDAO();
    private final String drawProceduresPath = "src\\main\\resources\\draw-procedures\\WorldCupProcedures.txt";

    public static String getTournamentLogo() {
        return tournamentLogo;
    }

    public static String getName() {
        return "FIFA World Cup 2018";
    }

    public TeamWorldCup[][] preparePots() {
        TeamWorldCup[][] result = null;
        try {
            List<TeamWorldCup> listOfTeams = worldCupDraw.sortTeamsOut(worldCupDAO.getAll());
            result = worldCupDraw.preparePots(listOfTeams);
        } catch (SQLException | IOException exception) {
            System.out.println(exception);
        };
        return result;
    }

    public TeamWorldCup[][] drawGroups() {
        TeamWorldCup[][] result = null;
        try {
            result = worldCupDraw.draw(preparePots());
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public String getDrawProcedures() throws FileNotFoundException {
        return worldCupDAO.getProcedures(drawProceduresPath);
    }



}
