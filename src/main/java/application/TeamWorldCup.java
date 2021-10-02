package application;

public class TeamWorldCup extends Team{

    private final int fifaRating;
    private final boolean isHostCountry;
    private final String federation;

    public TeamWorldCup(String name, String federation, int fifaRating, boolean isHostCountry) {
       super(name);
       this.federation = federation;
       this.fifaRating = fifaRating;
       this.isHostCountry = isHostCountry;
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
}
