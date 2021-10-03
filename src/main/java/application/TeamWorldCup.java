package application;

public class TeamWorldCup extends Team{

    private final int fifaRating;
    private final boolean isHostCountry;
    private final String federation;
    private final String logoPath;

    public TeamWorldCup(String name, String federation, int fifaRating, boolean isHostCountry, String logoPath) {
       super(name);
       this.federation = federation;
       this.fifaRating = fifaRating;
       this.isHostCountry = isHostCountry;
       this.logoPath = logoPath;
    }

    public int getFifaRating() {
        return fifaRating;
    }

    public boolean isHostCountry() {
        return isHostCountry;
    }

    public String getFederation() {
        return federation;
    }

    public String getLogoPath() {
        return logoPath;
    }
}
