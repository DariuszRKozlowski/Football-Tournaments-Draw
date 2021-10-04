package application;

import dao.ConflictsDAO;
import dao.CountryDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DrawChampionsLeague extends Draw<TeamChampionsLeague>{

    private static final ConflictsDAO conflictDAO = new ConflictsDAO();
    private static final CountryDAO countryDAO = new CountryDAO();

    @Override
    public List<TeamChampionsLeague> sortTeamsOut(List<TeamChampionsLeague> listOfClubs) throws SQLException, IOException {
        List<String> bestLeagues = countryDAO.getTopEight();
        List<TeamChampionsLeague> sortedTeams = new ArrayList<>();
        for (TeamChampionsLeague club: listOfClubs) {
            if(club.isPreviousUefaCompetitionChampion()) {
                sortedTeams.add(club);
                if(club.isCountryChampion() && bestLeagues.contains(club.getCountry())) {
                    bestLeagues.remove(club.getCountry());
                }
            }
        }
        for (TeamChampionsLeague club: listOfClubs) {
            if(!sortedTeams.contains(club) && club.isCountryChampion() && bestLeagues.contains(club.getCountry())) {
                int index = bestLeagues.indexOf(club.getCountry());
                if(index < 6) {
                    sortedTeams.add(club);
                }
            }
        }
        for(int a = 2 ; a < sortedTeams.size() - 1 ; a++) {
            for (int b = 2 ; b < sortedTeams.size() -1 ; b++) {
                if(sortedTeams.get(b).getUefaCoefficient() < sortedTeams.get(b+1).getUefaCoefficient()) {
                    TeamChampionsLeague storage = sortedTeams.get(b);
                    sortedTeams.set(b, sortedTeams.get(b+1));
                    sortedTeams.set(b + 1, storage);
                }
            }
        }
        for(int i = 0 ; i < listOfClubs.size() - 1 ; i++) {
            for(int j = 0 ; j < listOfClubs.size() - 1 ; j++) {
                if(listOfClubs.get(j).getUefaCoefficient() < listOfClubs.get(j+1).getUefaCoefficient()) {
                    TeamChampionsLeague storage = listOfClubs.get(j);
                    listOfClubs.set(j, listOfClubs.get(j+1));
                    listOfClubs.set(j+1, storage);
                }
            }
        }
        for (TeamChampionsLeague club: listOfClubs) {
            if(!sortedTeams.contains(club)) sortedTeams.add(club);
        }
        return new ArrayList<>(sortedTeams);
    }

    @Override
    public TeamChampionsLeague[][] preparePots(List<TeamChampionsLeague> sortedTeams) {
        TeamChampionsLeague[][] pots = new TeamChampionsLeague[4][8];
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
    public TeamChampionsLeague[][] draw(TeamChampionsLeague[][] pots) throws SQLException, IOException {
        this.mixBalls(pots);
        TeamChampionsLeague[][] groups = firstPotDraw(pots[0]);
        TeamChampionsLeague[][] result = null;
        for (int i = 1 ; i < pots.length ; i++) {
            result = otherPotsDraw(groups, pots[i], i);
        }
        return result;
    }

    private void mixBalls(TeamChampionsLeague[][] pots) {
        int potIndex = pots.length;
        int teamIndex = pots[0].length;
        Random randomIndex = new Random();
        int firstIndex, secondIndex;
        TeamChampionsLeague firstTeam;
        TeamChampionsLeague secondTeam;
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

    private boolean isEnemyIn(TeamChampionsLeague team, TeamChampionsLeague[] group) throws SQLException, IOException {
        List<String> listOfEnemies = conflictDAO.getEnemies(team.getCountry());
        if (!listOfEnemies.isEmpty()) {
            for (TeamChampionsLeague rival : group) {
                if(rival != null && !rival.equals(team)) {
                    if (listOfEnemies.contains(rival.getCountry())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isFromSameCountry(TeamChampionsLeague team, TeamChampionsLeague[] group) {
        for (TeamChampionsLeague rival: group) {
            if(rival != null && !rival.equals(team) && rival.getCountry().equals(team.getCountry())) return true;
        }
        return false;
    }

    private TeamChampionsLeague[][] firstPotDraw(TeamChampionsLeague[] firstPot) {
        TeamChampionsLeague[][] groups = new TeamChampionsLeague[8][4];
        for(int i = 0 ; i < groups.length ; i++) {
            groups[i][0] = firstPot[i];
        }
        return groups;
    }

    private TeamChampionsLeague[][] otherPotsDraw(TeamChampionsLeague[][] groups, TeamChampionsLeague[] pot, int potIndex) throws SQLException, IOException {
        Random random = new Random();
        List<TeamChampionsLeague> clubsList = new ArrayList<>(Arrays.asList(pot));
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
                TeamChampionsLeague storage = groups[trueIndex][potIndex];
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
