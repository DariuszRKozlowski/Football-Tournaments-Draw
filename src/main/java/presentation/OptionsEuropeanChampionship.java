package presentation;

import application.DrawEuropeanChampionship;
import application.TeamEuropeanChampionship;
import application.TeamWorldCup;
import dao.TeamEuropeanChampionshipDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OptionsEuropeanChampionship {

    private static final String tournamentLogo = "src\\main\\resources\\img\\UEFA Euro 2020\\LOGO.png";
    private static final String name = "UEFA EURO 2016";
    private final DrawEuropeanChampionship europeanChampionshipDraw = new DrawEuropeanChampionship();
    private final TeamEuropeanChampionshipDAO europeanChampionshipDAO = new TeamEuropeanChampionshipDAO();

    public static String getTournamentLogo() {
        return tournamentLogo;
    }

    public static String getName() {
        return name;
    }

    public TeamEuropeanChampionship[][] preparePots() {
        TeamEuropeanChampionship[][] result = null;
        try {
            List<TeamEuropeanChampionship> listOfTeams = europeanChampionshipDraw.sortTeamsOut(europeanChampionshipDAO.getAll());
            result = europeanChampionshipDraw.preparePots(listOfTeams);
        } catch (SQLException | IOException exception) {
            System.out.println(exception);
        };
        return result;
    }

    public TeamEuropeanChampionship[][] drawGroups() {
        TeamEuropeanChampionship[][] result = null;
        try {
            result = europeanChampionshipDraw.draw(preparePots());
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
