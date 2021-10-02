package application;

public class Country {

    private final String name;
    private final int uefaRating;

    public Country(String name, int uefaRating) {
        this.name = name;
        this.uefaRating = uefaRating;
    }

    public String getName() {
        return name;
    }

    public int getUefaRating() {
        return uefaRating;
    }
}
