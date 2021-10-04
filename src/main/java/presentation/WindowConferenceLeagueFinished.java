package presentation;

import application.TeamChampionsLeague;
import application.TeamConferenceLeague;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WindowConferenceLeagueFinished extends JFrame implements ActionListener {

    private final JButton bClear, bCancel;

    public WindowConferenceLeagueFinished() throws IOException {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("UEFA Conference League 2021/22");
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);

        int size = 100;
        OptionsConferenceLeague optionsConferenceLeague = new OptionsConferenceLeague();
        TeamConferenceLeague[][] pots = optionsConferenceLeague.preparePots();
        for(int i = 0 ; i < pots.length ; i++) {
            int startX = 50;
            int startY = 50;
            int gapX = 150;
            int gapY = 100;
            for(int j = 0 ; j < pots[0].length; j++) {
                BufferedImage clubLogo = ImageIO.read(new File(pots[i][j].getLogoPath()));
                JLabel picLabel = new JLabel(new ImageIcon(clubLogo));
                picLabel.setBounds((j*gapX)+startX, (i*gapY)+startY, size, size);
                add(picLabel);
            }
        }

        bClear = new JButton("Clear");
        bClear.setBounds(975,470, 250,220);
        bClear.setFont(new Font("Arial", Font.PLAIN, 36));
        add(bClear);
        bClear.addActionListener(this);

        bCancel = new JButton("Cancel");
        bCancel.setBounds(975, 705, 250, 220);
        bCancel.setFont(new Font("Arial", Font.PLAIN, 36));
        add(bCancel);
        bCancel.addActionListener(this);


        TeamConferenceLeague[][] groups = optionsConferenceLeague.drawGroups();
        for(int i = 0 ; i < groups.length ; i++) {
            int startX = 37;
            int startYUp = 502;
            int startYDown = 737;
            int gapX = 104;
            int gapY = 102;
            for(int j = 0 ; j < groups[0].length; j++) {
                BufferedImage clubLogo = ImageIO.read(new File(groups[i][j].getLogoPath()));
                JLabel picLabel = new JLabel(new ImageIcon(clubLogo));
                int x = (235 * (i%4)) + (startX + (j * gapX));
                int y = (235 * (i%4)) + (startX + ((j%2) * gapX));
                if(i < 4) {
                    if(j < 2) {
                        picLabel.setBounds(x, startYUp, size, size);
                    }
                    else {
                        picLabel.setBounds(y, startYUp + gapY, size, size);
                    }
                }
                else {
                    if(j < 2) {
                        picLabel.setBounds(x, startYDown, size, size);
                    }
                    else {
                        picLabel.setBounds(y, startYDown + gapY, size, size);
                    }
                }
                add(picLabel);
            }
        }

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
        else if(source == bClear) {
            this.dispose();
            WindowConferenceLeagueEmpty windowConferenceLeagueEmpty = null;
            try {
                windowConferenceLeagueEmpty = new WindowConferenceLeagueEmpty();
                windowConferenceLeagueEmpty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                windowConferenceLeagueEmpty.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawRect(35, 70, 1200, 420);
        graphics.drawString("Pot 1", 620, 90);
        graphics.drawLine(35, 180, 1235,180 );
        graphics.drawString("Pot 2", 620, 200);
        graphics.drawLine(35, 280, 1235,280 );
        graphics.drawString("Pot 3", 620, 300);
        graphics.drawLine(35, 380, 1235,380 );
        graphics.drawString("Pot 4", 620, 400);
        graphics.drawRect(35, 500, 220, 235);
        graphics.drawString("Group A", 130,530);
        graphics.drawRect(270, 500, 220, 235);
        graphics.drawString("Group B",365, 530);
        graphics.drawRect(505, 500, 220, 235);
        graphics.drawString("Group C", 600, 530);
        graphics.drawRect(740, 500, 220, 235);
        graphics.drawString("Group D", 835, 530);
        graphics.drawRect(35, 735, 220, 235);
        graphics.drawString("Group E", 130, 765);
        graphics.drawRect(270, 735, 220, 235);
        graphics.drawString("Group F", 365, 765);
        graphics.drawRect(505, 735, 220, 235);
        graphics.drawString("Group G", 600, 765);
        graphics.drawRect(740, 735, 220, 235);
        graphics.drawString("Group H", 835, 765);
    }
}
