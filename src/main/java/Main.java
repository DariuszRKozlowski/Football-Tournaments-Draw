import presentation.WindowHome;
import presentation.WindowWorldCup;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        WindowHome window = new WindowHome();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

}
