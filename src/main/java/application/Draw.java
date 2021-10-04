package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public abstract class Draw<T extends Team> {

    public abstract List<T> sortTeamsOut(List<T> teamsList) throws SQLException, IOException;

    public abstract T[][] preparePots(List<T> teamsList);

    public abstract T[][] draw(T[][] pots) throws SQLException, IOException;
}
