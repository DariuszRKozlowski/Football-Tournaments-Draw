package application;

public class TeamConferenceLeague extends Team {

    private final String country;
    private final int uefaCoefficient;
    private final String logoPath;

    public TeamConferenceLeague(String name, String country, int uefaCoefficient, String logoPath) {
        super(name);
        this.country = country;
        this.uefaCoefficient = uefaCoefficient;
        this.logoPath = logoPath;
    }

    public String getCountry() {
        return country;
    }

    public int getUefaCoefficient() {
        return uefaCoefficient;
    }

    public String getLogoPath() {
        return logoPath;
    }

}
