package presentation;

import presentation.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WindowHome extends JFrame implements ActionListener {

    private final JButton bWorldCup, bEuropeanChampionship, bChampionsLeague, bEuropaLeague, bConferenceLeague;

    public WindowHome() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Football tournaments draw simulator");
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);

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

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == bWorldCup) {
            this.dispose();
            try {
                WindowWorldCup x = new WindowWorldCup();
                x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                x.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(source == bEuropeanChampionship) {
            System.out.println("Euro!");
            JOptionPane.showMessageDialog(null, "Narka");
            this.dispose();
        }
        else if(source == bChampionsLeague) {
            System.out.println("Champions League!");
        }
        else if(source == bEuropaLeague) {
            System.out.println("Europa League!");
        }
        else if(source == bConferenceLeague) {
            System.out.println("Conference League!");
        }
    }
}
