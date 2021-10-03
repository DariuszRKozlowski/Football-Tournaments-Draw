package application;

import dao.ConflictsDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DrawEuropeanChampionship extends Draw<TeamEuropeanChampionship>{

    private static final String tournamentLogo = "src\\main\\resources\\img\\UEFA Euro 2020\\LOGO.png";
    private static final ConflictsDAO conflictDAO = new ConflictsDAO();

    @Override
    public List<Team> sortTeamsOut(List<TeamEuropeanChampionship> listOfTeams) {
        List<TeamEuropeanChampionship> sortedTeams = new ArrayList<>();
        for (TeamEuropeanChampionship team : listOfTeams) {
            if (team.isHostCountry()) {
                sortedTeams.add(team);
            }
        }
        for(int i = 0 ; i < listOfTeams.size() - 1 ; i++) {
            for(int j = 0 ; j < listOfTeams.size() - 1 ; j++) {
                if(listOfTeams.get(j).getUefaCoefficient() < listOfTeams.get(j+1).getUefaCoefficient()) {
                    TeamEuropeanChampionship storage = listOfTeams.get(j);
                    listOfTeams.set(j, listOfTeams.get(j+1));
                    listOfTeams.set(j+1, storage);
                }
            }
        }
        for (TeamEuropeanChampionship team : listOfTeams) {
            if(!sortedTeams.contains(team)) sortedTeams.add(team);
        }
        return new ArrayList<>(sortedTeams);
    }

    @Override
    public Team[][] preparePots(List<TeamEuropeanChampionship> sortedTeams) {
        Team[][] pots = new TeamEuropeanChampionship[4][6];
        int numOfPots = pots.length;
        int teamsPerPot = pots[0].length;
        int iterator = 0;
        for (int i = 0 ; i < numOfPots ; i++) {
            for (int j = 0 ; j < teamsPerPot ; j++) {
                pots[i][j] = sortedTeams.get(iterator);
                iterator++;
            }
        }
        return pots;
    }

    @Override
    public void draw(TeamEuropeanChampionship[][] pots) throws SQLException, IOException {
        this.mixBalls(pots);
        TeamEuropeanChampionship[][] groups = firstPotDraw(pots[0]);
        TeamEuropeanChampionship[][] result = null;
        for (int i = 1 ; i < pots.length ; i++) {
            result = otherPotsDraw(groups, pots[i], i);
        }
        if(result != null) this.show(result);
    }

    private void mixBalls(TeamEuropeanChampionship[][] pots) {
        int potIndex = pots.length;
        int teamIndex = pots[0].length;
        Random randomIndex = new Random();
        int firstIndex, secondIndex;
        TeamEuropeanChampionship firstTeam;
        TeamEuropeanChampionship secondTeam;
        for (int i = 0 ; i < potIndex ; i++) {
            for(int j = 0 ; j < teamIndex * 25; j++) {
                firstIndex = randomIndex.nextInt(teamIndex);
                firstTeam = pots[i][firstIndex];
                secondIndex = randomIndex.nextInt(teamIndex);
                secondTeam = pots[i][secondIndex];
                if(!pots[i][firstIndex].equals(pots[i][secondIndex]) && (!pots[i][firstIndex].isHostCountry() && !pots[i][secondIndex].isHostCountry())) {
                    pots[i][firstIndex] = secondTeam;
                    pots[i][secondIndex] = firstTeam;
                }
            }
        }
    }

    private boolean isEnemyIn(TeamEuropeanChampionship team, TeamEuropeanChampionship[] group) throws SQLException, IOException {
        List<String> listOfEnemies = conflictDAO.getEnemies(team.getName());
        if (!listOfEnemies.isEmpty()) {
            for (TeamEuropeanChampionship rival : group) {
                if(rival != null && !rival.equals(team)) {
                    if (listOfEnemies.contains(rival.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private TeamEuropeanChampionship[][] firstPotDraw(TeamEuropeanChampionship[] firstPot) {
        TeamEuropeanChampionship[][] groups = new TeamEuropeanChampionship[6][4];
        for(int i = 0 ; i < groups.length ; i++) {
            groups[i][0] = firstPot[i];
        }
        return groups;
    }

    private TeamEuropeanChampionship[][] otherPotsDraw(TeamEuropeanChampionship[][] groups, TeamEuropeanChampionship[] pot, int potIndex) throws SQLException, IOException {
        Random random = new Random();
        List<TeamEuropeanChampionship> clubsList = new ArrayList<>(Arrays.asList(pot));
        List<Boolean> conditionsStatus = new ArrayList<>();
        boolean isEnemyIn;
        for(int i = 0 ; i < groups.length ; i++) {
            groups[i][potIndex] = clubsList.get(i);
            conditionsStatus.add(true);
        }
        for(int j = 0 ; j < groups.length ; j++) {
            isEnemyIn = isEnemyIn(groups[j][potIndex], groups[j]);
            conditionsStatus.set(j, isEnemyIn);
        }
        while(conditionsStatus.contains(true)) {
            List<Integer> groupWithTrue = new ArrayList<>();
            for(int i = 0 ; i < groups.length ; i++) {
                if(conditionsStatus.get(i)) groupWithTrue.add(i);
            }
            for (Integer trueIndex : groupWithTrue) {
                int randomIndex = random.nextInt(groups.length);
                TeamEuropeanChampionship storage = groups[trueIndex][potIndex];
                groups[trueIndex][potIndex] = groups[randomIndex][potIndex];
                groups[randomIndex][potIndex] = storage;
            }
            for (int j = 0 ; j < groups.length ; j++) {
                isEnemyIn = isEnemyIn(groups[j][potIndex], groups[j]);
                conditionsStatus.set(j, isEnemyIn);
            }
        }
        return groups;
    }

    private void show(TeamEuropeanChampionship[][] groups) {
        char group = 'A';
        for (TeamEuropeanChampionship[] teamEuropeanChampionships : groups) {
            System.out.println("Group " + group);
            for (int j = 0; j < groups[0].length; j++) {
                System.out.println(teamEuropeanChampionships[j].getName());
            }
            System.out.println();
            group++;
        }
    }
}
