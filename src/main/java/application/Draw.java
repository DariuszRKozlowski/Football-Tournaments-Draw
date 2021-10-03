package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class Draw<T extends Team> {

    public abstract List<Team> sortTeamsOut(List<T> teamsList);

    public abstract Team[][] preparePots(List<T> teamsList);

    public abstract void draw(T[][] pots) throws SQLException, IOException;
}
