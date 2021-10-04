package application;

import dao.ConflictsDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DrawConferenceLeague extends Draw<TeamConferenceLeague> {

    private static final ConflictsDAO conflictDAO = new ConflictsDAO();

    @Override
    public List<TeamConferenceLeague> sortTeamsOut(List<TeamConferenceLeague> listOfClubs) {
        for(int i = 0 ; i < listOfClubs.size() - 1 ; i++) {
            for(int j = 0 ; j < listOfClubs.size() - 1 ; j++) {
                if(listOfClubs.get(j).getUefaCoefficient() < listOfClubs.get(j+1).getUefaCoefficient()) {
                    TeamConferenceLeague storage = listOfClubs.get(j);
                    listOfClubs.set(j, listOfClubs.get(j+1));
                    listOfClubs.set(j+1, storage);
                }
            }
        }
        return new ArrayList<>(listOfClubs);
    }

    @Override
    public TeamConferenceLeague[][] preparePots(List<TeamConferenceLeague> sortedTeams) {
        TeamConferenceLeague[][] pots = new TeamConferenceLeague[4][8];
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
    public TeamConferenceLeague[][] draw(TeamConferenceLeague[][] pots) throws SQLException, IOException {
        this.mixBalls(pots);
        TeamConferenceLeague[][] groups = firstPotDraw(pots[0]);
        TeamConferenceLeague[][] result = null;
        for (int i = 1 ; i < pots.length ; i++) {
            result = otherPotsDraw(groups, pots[i], i);
        }
        return result;
    }

    private void mixBalls(TeamConferenceLeague[][] pots) {
        int potIndex = pots.length;
        int teamIndex = pots[0].length;
        Random randomIndex = new Random();
        int firstIndex, secondIndex;
        TeamConferenceLeague firstTeam;
        TeamConferenceLeague secondTeam;
        for (int i = 0 ; i < potIndex ; i++) {
            for(int j = 0 ; j < teamIndex * 25; j++) {
                firstIndex = randomIndex.nextInt(teamIndex);
                firstTeam = pots[i][firstIndex];
                secondIndex = randomIndex.nextInt(teamIndex);
                secondTeam = pots[i][secondIndex];
                if(!pots[i][firstIndex].equals(pots[i][secondIndex])) {
                    pots[i][firstIndex] = secondTeam;
                    pots[i][secondIndex] = firstTeam;
                }
            }
        }
    }

    private boolean isEnemyIn(TeamConferenceLeague team, TeamConferenceLeague[] group) throws SQLException, IOException {
        List<String> listOfEnemies = conflictDAO.getEnemies(team.getCountry());
        if (!listOfEnemies.isEmpty()) {
            for (TeamConferenceLeague rival : group) {
                if(rival != null && !rival.equals(team)) {
                    if (listOfEnemies.contains(rival.getCountry())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isFromSameCountry(TeamConferenceLeague team, TeamConferenceLeague[] group) {
        for (TeamConferenceLeague rival: group) {
            if(rival != null && !rival.equals(team) && rival.getCountry().equals(team.getCountry())) return true;
        }
        return false;
    }

    private TeamConferenceLeague[][] firstPotDraw(TeamConferenceLeague[] firstPot) {
        TeamConferenceLeague[][] groups = new TeamConferenceLeague[8][4];
        for(int i = 0 ; i < groups.length ; i++) {
            groups[i][0] = firstPot[i];
        }
        return groups;
    }

    private TeamConferenceLeague[][] otherPotsDraw(TeamConferenceLeague[][] groups, TeamConferenceLeague[] pot, int potIndex) throws SQLException, IOException {
        Random random = new Random();
        List<TeamConferenceLeague> clubsList = new ArrayList<>(Arrays.asList(pot));
        List<Boolean> conditionsStatus = new ArrayList<>();
        boolean isEnemyIn;
        boolean isFromSameCountry;
        for(int i = 0 ; i < groups.length ; i++) {
            groups[i][potIndex] = clubsList.get(i);
            conditionsStatus.add(true);
        }
        for(int j = 0 ; j < groups.length ; j++) {
            isEnemyIn = isEnemyIn(groups[j][potIndex], groups[j]);
            isFromSameCountry = isFromSameCountry(groups[j][potIndex], groups[j]);
            conditionsStatus.set(j, isEnemyIn || isFromSameCountry);
        }
        while(conditionsStatus.contains(true)) {
            List<Integer> groupWithTrue = new ArrayList<>();
            for(int i = 0 ; i < groups.length ; i++) {
                if(conditionsStatus.get(i)) groupWithTrue.add(i);
            }
            for (Integer trueIndex : groupWithTrue) {
                int randomIndex = random.nextInt(groups.length);
                TeamConferenceLeague storage = groups[trueIndex][potIndex];
                groups[trueIndex][potIndex] = groups[randomIndex][potIndex];
                groups[randomIndex][potIndex] = storage;
            }
            for (int j = 0 ; j < groups.length ; j++) {
                isEnemyIn = isEnemyIn(groups[j][potIndex], groups[j]);
                isFromSameCountry = isFromSameCountry(groups[j][potIndex], groups[j]);
                conditionsStatus.set(j, isEnemyIn || isFromSameCountry);
            }
        }

        return groups;
    }

}
