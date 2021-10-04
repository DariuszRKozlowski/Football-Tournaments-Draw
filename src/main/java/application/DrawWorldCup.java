package application;

import dao.ConflictsDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DrawWorldCup extends Draw<TeamWorldCup>{


    private static final ConflictsDAO conflictDAO = new ConflictsDAO();

    @Override
    public List<TeamWorldCup> sortTeamsOut(List<TeamWorldCup> listOfTeams) {
        List<TeamWorldCup> sortedTeams = new ArrayList<>();
        for (TeamWorldCup team : listOfTeams) {
            if (team.isHostCountry()) {
                sortedTeams.add(team);
            }
        }
        for(int i = 0 ; i < listOfTeams.size() - 1 ; i++) {
            for(int j = 0 ; j < listOfTeams.size() - 1 ; j++) {
                if(listOfTeams.get(j).getFifaRating() > listOfTeams.get(j+1).getFifaRating()) {
                    TeamWorldCup storage = listOfTeams.get(j);
                    listOfTeams.set(j, listOfTeams.get(j+1));
                    listOfTeams.set(j+1, storage);
                }
            }
        }
        for (TeamWorldCup team : listOfTeams) {
            if(!sortedTeams.contains(team)) sortedTeams.add(team);
        }
        return new ArrayList<>(sortedTeams);
    }

    @Override
    public TeamWorldCup[][] preparePots(List<TeamWorldCup> sortedTeams) {
        TeamWorldCup[][] pots = new TeamWorldCup[4][8];
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
    public TeamWorldCup[][] draw(TeamWorldCup[][] pots) throws SQLException, IOException {
        this.mixBalls(pots);
        TeamWorldCup[][] groups = firstPotDraw(pots[0]);
        TeamWorldCup[][] result = null;
        for (int i = 1 ; i < pots.length ; i++) {
            result = otherPotsDraw(groups, pots[i], i);
        }
        return result;
    }

    private void mixBalls(TeamWorldCup[][] pots) {
        int potIndex = pots.length;
        int teamIndex = pots[0].length;
        Random randomIndex = new Random();
        int firstIndex, secondIndex;
        TeamWorldCup firstTeam;
        TeamWorldCup secondTeam;
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

    private boolean isEnemyIn(TeamWorldCup team, TeamWorldCup[] group) throws SQLException, IOException {
        List<String> listOfEnemies = conflictDAO.getEnemies(team.getName());
        if (!listOfEnemies.isEmpty()) {
            for (TeamWorldCup rival : group) {
                if(rival != null && !rival.equals(team)) {
                    if (listOfEnemies.contains(rival.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isFederationConflict(TeamWorldCup team, TeamWorldCup[] group) {
        List<String> federations = new ArrayList<>();
        for (TeamWorldCup rival : group) {
            if(rival!= null && !rival.getName().equals(team.getName())) {
                federations.add(rival.getFederation());
            }
        }
        if(!team.getFederation().equals("UEFA") && federations.contains(team.getFederation())) {
            return true;
        } else if (team.getFederation().equals("UEFA")) {
            long uefaCounter = federations.stream().filter(n -> n.equals("UEFA")).count();
            return uefaCounter >= 2;
        } else {
            return false;
        }
    }

    private TeamWorldCup[][] firstPotDraw(TeamWorldCup[] firstPot) {
        TeamWorldCup[][] groups = new TeamWorldCup[8][4];
        for(int i = 0 ; i < groups.length ; i++) {
            groups[i][0] = firstPot[i];
        }
        return groups;
    }

    private TeamWorldCup[][] otherPotsDraw(TeamWorldCup[][] groups, TeamWorldCup[] pot, int potIndex) throws SQLException, IOException {
        Random random = new Random();
        List<TeamWorldCup> clubsList = new ArrayList<>(Arrays.asList(pot));
        List<Boolean> conditionsStatus = new ArrayList<>();
        boolean isEnemyIn;
        boolean isFederationConflict;
        for(int i = 0 ; i < groups.length ; i++) {
            groups[i][potIndex] = clubsList.get(i);
            conditionsStatus.add(true);
        }
        for(int j = 0 ; j < groups.length ; j++) {
            isEnemyIn = isEnemyIn(groups[j][potIndex], groups[j]);
            isFederationConflict = isFederationConflict(groups[j][potIndex], groups[j]);
            conditionsStatus.set(j, isEnemyIn || isFederationConflict);
        }
        while(conditionsStatus.contains(true)) {
            List<Integer> groupWithTrue = new ArrayList<>();
            for(int i = 0 ; i < groups.length ; i++) {
                if(conditionsStatus.get(i)) groupWithTrue.add(i);
            }
            for (Integer trueIndex : groupWithTrue) {
                int randomIndex = random.nextInt(groups.length);
                TeamWorldCup storage = groups[trueIndex][potIndex];
                groups[trueIndex][potIndex] = groups[randomIndex][potIndex];
                groups[randomIndex][potIndex] = storage;
            }
            for (int j = 0 ; j < groups.length ; j++) {
                isEnemyIn = isEnemyIn(groups[j][potIndex], groups[j]);
                isFederationConflict = isFederationConflict(groups[j][potIndex], groups[j]);
                conditionsStatus.set(j, isEnemyIn || isFederationConflict);
            }
        }

        return groups;
    }

}
