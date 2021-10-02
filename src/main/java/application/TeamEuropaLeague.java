package application;

public class TeamEuropaLeague extends Team{

    private final String country;
    private final int uefaCoefficient;

    public TeamEuropaLeague(String name, String country, int uefaCoefficient) {
        super(name);
        this.country = country;
        this.uefaCoefficient = uefaCoefficient;
    }

    public String getCountry() {
        return country;
    }

    public int getUefaCoefficient() {
        return uefaCoefficient;
    }
}
