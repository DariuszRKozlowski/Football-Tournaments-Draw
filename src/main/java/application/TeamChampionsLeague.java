package application;

public class TeamChampionsLeague extends Team {

    private final String country;
    private final int uefaCoefficient;
    private final boolean isCountryChampion;
    private final boolean isPreviousUefaCompetitionChampion;
    private final String logoPath;

    public TeamChampionsLeague(String name, String country, int uefaCoefficient, boolean isCountryChampion, boolean isPreviousUefaCompetitionChampion, String logoPath) {
        super(name);
        this.country = country;
        this.uefaCoefficient = uefaCoefficient;
        this.isCountryChampion = isCountryChampion;
        this.isPreviousUefaCompetitionChampion = isPreviousUefaCompetitionChampion;
        this.logoPath = logoPath;
    }

    public String getCountry() {
        return country;
    }

    public int getUefaCoefficient() {
        return uefaCoefficient;
    }

    public boolean isCountryChampion() {
        return isCountryChampion;
    }

    public boolean isPreviousUefaCompetitionChampion() {
        return isPreviousUefaCompetitionChampion;
    }

    public String getLogoPath() {
        return logoPath;
    }
}
