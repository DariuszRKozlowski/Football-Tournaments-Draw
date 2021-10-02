package application;

public class TeamConferenceLeague extends Team {

    private final String country;
    private final int uefaCoefficient;

    public TeamConferenceLeague(String name, String country, int uefaCoefficient) {
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
