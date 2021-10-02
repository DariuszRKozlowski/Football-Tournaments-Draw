package application;

public class TeamEuropeanChampionship extends Team {

    private final int uefaCoefficient;
    private final boolean isHostCountry;

    public TeamEuropeanChampionship(String name, int uefaCoefficient, boolean isHostCountry) {
        super(name);
        this.uefaCoefficient = uefaCoefficient;
        this.isHostCountry = isHostCountry;
    }

    public int getUefaCoefficient() {
        return uefaCoefficient;
    }

    public boolean isHostCountry() {
        return isHostCountry;
    }
}
