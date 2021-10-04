package presentation;

import application.DrawEuropeanChampionship;
import application.TeamEuropeanChampionship;
import dao.TeamEuropeanChampionshipDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OptionsEuropeanChampionship {

    private static final String tournamentLogo = "src\\main\\resources\\img\\UEFA Euro 2020\\LOGO.png";
    private static final String name = "UEFA EURO 2016";

    public static String getTournamentLogo() {
        return tournamentLogo;
    }

    public static String getName() {
        return name;
    }
}
