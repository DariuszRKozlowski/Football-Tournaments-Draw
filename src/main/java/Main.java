import application.*;
import dao.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
//        ImageIcon dab = new ImageIcon("src\\main\\resources\\img\\FIFA World Cup 2018\\Uruguay.png");
//        JOptionPane.showMessageDialog(null, "xD", "display image", JOptionPane.INFORMATION_MESSAGE, dab);
        TeamConferenceLeagueDAO dao = new TeamConferenceLeagueDAO();
        TeamEuropaLeagueDAO dao1 = new TeamEuropaLeagueDAO();
        Draw draw = new DrawConferenceLeague();
        List listaDruzyn = draw.sortTeamsOut(dao.getAll());
        Team[][] koszyki = draw.preparePots(listaDruzyn);
        draw.draw(koszyki);

        Draw draw1 = new DrawEuropaLeague();
        List listaDruzyn1 = draw1.sortTeamsOut(dao1.getAll());
        Team[][] koszyki1 = draw1.preparePots(listaDruzyn1);
        draw1.draw(koszyki1);

    }

}
