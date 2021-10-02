package application;

public class TeamChampionsLeague extends Team {

    private final String country;
    private final int uefaCoefficient;
    private final boolean isCountryChampion;
    private final boolean isPreviousUefaCompetitionChampion;

    public TeamChampionsLeague(String name, String country, int uefaCoefficient, boolean isCountryChampion, boolean isPreviousUefaCompetitionChampion) {
        super(name);
        this.country = country;
        this.uefaCoefficient = uefaCoefficient;
        this.isCountryChampion = isCountryChampion;
        this.isPreviousUefaCompetitionChampion = isPreviousUefaCompetitionChampion;
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


}
