package application;

public abstract class Team {

    private final String name;

    protected Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
