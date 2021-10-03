package application;

public class TeamEuropeanChampionship extends Team {

    private final int uefaCoefficient;
    private final boolean isHostCountry;
    private final String logoPath;

    public TeamEuropeanChampionship(String name, int uefaCoefficient, boolean isHostCountry, String logoPath) {
        super(name);
        this.uefaCoefficient = uefaCoefficient;
        this.isHostCountry = isHostCountry;
        this.logoPath = logoPath;
    }

    public int getUefaCoefficient() {
        return uefaCoefficient;
    }

    public boolean isHostCountry() {
        return isHostCountry;
    }

    public String getLogoPath() {
        return logoPath;
    }
}
