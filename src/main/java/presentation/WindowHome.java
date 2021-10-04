package presentation;

import presentation.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WindowHome extends JFrame implements ActionListener {

    private final JButton bWorldCup, bEuropeanChampionship, bChampionsLeague, bEuropaLeague, bConferenceLeague, bExit, bAuthor;

    public WindowHome() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Football tournaments draw simulator");
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);

        JLabel mainText = new JLabel("Choose the right tournament!");
        mainText.setBounds(600, 100, 800, 200);
        mainText.setFont(new Font("Arial", Font.BOLD, 48));
        add(mainText);

        Icon worldCupIcon = new ImageIcon(OptionsWorldCup.getTournamentLogo());
        bWorldCup = new JButton(worldCupIcon);
        bWorldCup.setBounds(120, 350, 250, 240);
        add(bWorldCup);
        bWorldCup.addActionListener(this);

        JLabel wcLabel = new JLabel(OptionsWorldCup.getName());
        wcLabel.setBounds(143, 570, 250, 100);
        wcLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(wcLabel);

        Icon europeanChampionshipIcon = new ImageIcon(OptionsEuropeanChampionship.getTournamentLogo());
        bEuropeanChampionship = new JButton(europeanChampionshipIcon);
        bEuropeanChampionship.setBounds(470, 350, 250, 240);
        add(bEuropeanChampionship);
        bEuropeanChampionship.addActionListener(this);

        JLabel ecLabel = new JLabel(OptionsEuropeanChampionship.getName());
        ecLabel.setBounds(505, 570, 250, 100);
        ecLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(ecLabel);

        Icon championsLeagueIcon = new ImageIcon(OptionsChampionsLeague.getTournamentLogo());
        bChampionsLeague = new JButton(championsLeagueIcon);
        bChampionsLeague.setBounds(820, 350, 250, 240);
        add(bChampionsLeague);
        bChampionsLeague.addActionListener(this);

        JLabel chlLabel = new JLabel(OptionsChampionsLeague.getName());
        chlLabel.setBounds(830, 570, 250, 100);
        chlLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(chlLabel);

        Icon europaLeagueIcon = new ImageIcon(OptionsEuropaLeague.getTournamentLogo());
        bEuropaLeague = new JButton(europaLeagueIcon);
        bEuropaLeague.setBounds(1170, 350, 250, 240);
        add(bEuropaLeague);
        bEuropaLeague.addActionListener(this);

        JLabel elLabel = new JLabel(OptionsEuropaLeague.getName());
        elLabel.setBounds(1200, 570, 250, 100);
        elLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(elLabel);

        Icon conferenceLeagueIcon = new ImageIcon(OptionsConferenceLeague.getTournamentLogo());
        bConferenceLeague = new JButton(conferenceLeagueIcon);
        bConferenceLeague.setBounds(1520, 350, 250, 240);
        add(bConferenceLeague);
        bConferenceLeague.addActionListener(this);

        JLabel colLabel = new JLabel(OptionsConferenceLeague.getName());
        colLabel.setBounds(1530, 570, 250, 100);
        colLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(colLabel);

        bExit = new JButton("Exit");
        bExit.setBounds(1675, 750, 100, 100);
        bExit.setFont(new Font("Arial", Font.BOLD, 20));
        bExit.setForeground(Color.WHITE);
        bExit.setBackground(Color.BLACK);
        add(bExit);
        bExit.addActionListener(this);

        bAuthor = new JButton("Author");
        bAuthor.setBounds(1550, 750, 100, 100);
        bAuthor.setFont(new Font("Arial", Font.BOLD, 20));
        bAuthor.setForeground(Color.WHITE);
        bAuthor.setBackground(Color.BLACK);
        add(bAuthor);
        bAuthor.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == bWorldCup) {
            this.dispose();
            try {
                WindowWorldCupEmpty emptyWorldCup = new WindowWorldCupEmpty();
                emptyWorldCup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                emptyWorldCup.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(source == bEuropeanChampionship) {
            this.dispose();
            try {
                WindowEuropeanChampionshipEmpty emptyEuropeanChampionship = new WindowEuropeanChampionshipEmpty();
                emptyEuropeanChampionship.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                emptyEuropeanChampionship.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(source == bChampionsLeague) {
            this.dispose();
            try {
                WindowChampionsLeagueEmpty emptyWindowChampionsLeague = new WindowChampionsLeagueEmpty();
                emptyWindowChampionsLeague.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                emptyWindowChampionsLeague.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(source == bEuropaLeague) {
            this.dispose();
            try {
                WindowEuropaLeagueEmpty emptyEuropaLeague = new WindowEuropaLeagueEmpty();
                emptyEuropaLeague.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                emptyEuropaLeague.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(source == bConferenceLeague) {
            this.dispose();
            try {
                WindowConferenceLeagueEmpty emptyConferenceLeague = new WindowConferenceLeagueEmpty();
                emptyConferenceLeague.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                emptyConferenceLeague.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(source == bAuthor) {
            JOptionPane.showMessageDialog(null, "Author: Dariusz Kozlowski");
        }
        else if(source == bExit) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Stay with us...", JOptionPane.YES_NO_OPTION);
            if(option == 0) {
                JOptionPane.showMessageDialog(null, "Ok, goodbye!");
                this.dispose();
            }

        }
    }
}
