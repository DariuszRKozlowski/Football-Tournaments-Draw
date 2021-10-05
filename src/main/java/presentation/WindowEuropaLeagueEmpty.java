package presentation;

import application.TeamChampionsLeague;
import application.TeamEuropaLeague;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WindowEuropaLeagueEmpty extends JFrame implements ActionListener {

    private final JButton bStart, bCancel;

    public WindowEuropaLeagueEmpty() throws IOException {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("UEFA Europa League 2021/22");
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);

        int size = 100;
        OptionsEuropaLeague optionsEuropaLeague = new OptionsEuropaLeague();
        TeamEuropaLeague[][] pots = optionsEuropaLeague.preparePots();
        for(int i = 0 ; i < pots.length ; i++) {
            int startX = 50;
            int startY = 50;
            int gapX = 230;
            int gapY = 100;
            for(int j = 0 ; j < pots[0].length; j++) {
                BufferedImage clubLogo = ImageIO.read(new File(pots[i][j].getLogoPath()));
                JLabel picLabel = new JLabel(new ImageIcon(clubLogo));
                JLabel name = new JLabel(pots[i][j].getName());
                JLabel country = new JLabel("(" + pots[i][j].getCountry() + ")");
                picLabel.setBounds((j*gapX)+startX, (i*gapY)+startY, size, size);
                add(picLabel);
                name.setBounds((j*gapX)+startX + 100, (i*gapY)+startY - 15, size + 15, size);
                add(name);
                country.setBounds((j*gapX)+startX + 100, (i*gapY)+startY, size + 38, size);
                add(country);
            }
        }

        bStart = new JButton("Start");
        bStart.setBounds(975,470, 250,220);
        bStart.setFont(new Font("Arial", Font.PLAIN, 36));
        add(bStart);
        bStart.addActionListener(this);

        bCancel = new JButton("Cancel");
        bCancel.setBounds(975, 705, 250, 220);
        bCancel.setFont(new Font("Arial", Font.PLAIN, 36));
        add(bCancel);
        bCancel.addActionListener(this);

        JLabel proceduresHeader = new JLabel("Europa League Draw procedures");
        proceduresHeader.setBounds(1250, 435, 650, 100);
        proceduresHeader.setFont(new Font("Arial", Font.BOLD, 32));
        proceduresHeader.setForeground(Color.BLACK);
        add(proceduresHeader);

        JTextArea procedures = new JTextArea(optionsEuropaLeague.getDrawProcedures());
        procedures.setBounds(1250, 510, 650, 450);
        procedures.setBackground(Color.GRAY);
        procedures.setForeground(Color.BLACK);
        procedures.setEditable(false);
        add(procedures);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == bCancel) {
            this.dispose();
            WindowHome windowHome = new WindowHome();
            windowHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowHome.setVisible(true);
        }
        else if(source == bStart) {
            this.dispose();
            WindowEuropaLeagueFinished windowEuropaLeagueFinished = null;
            try {
                windowEuropaLeagueFinished = new WindowEuropaLeagueFinished();
                windowEuropaLeagueFinished.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                windowEuropaLeagueFinished.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawRect(35, 70, 1850, 420);
        graphics.drawString("Pot 1", 920, 90);
        graphics.drawLine(35, 180, 1885,180 );
        graphics.drawString("Pot 2", 920, 200);
        graphics.drawLine(35, 280, 1885,280 );
        graphics.drawString("Pot 3", 920, 300);
        graphics.drawLine(35, 380, 1885,380 );
        graphics.drawString("Pot 4", 920, 400);
        graphics.drawRect(35, 500, 220, 235);
        graphics.drawString("Group A", 130,520);
        graphics.drawRect(270, 500, 220, 235);
        graphics.drawString("Group B",365, 520);
        graphics.drawRect(505, 500, 220, 235);
        graphics.drawString("Group C", 600, 520);
        graphics.drawRect(740, 500, 220, 235);
        graphics.drawString("Group D", 835, 530);
        graphics.drawRect(35, 735, 220, 235);
        graphics.drawString("Group E", 130, 755);
        graphics.drawRect(270, 735, 220, 235);
        graphics.drawString("Group F", 365, 755);
        graphics.drawRect(505, 735, 220, 235);
        graphics.drawString("Group G", 600, 755);
        graphics.drawRect(740, 735, 220, 235);
        graphics.drawString("Group H", 835, 755);
    }
}
