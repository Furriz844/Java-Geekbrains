package ru.VasilyevDmitriy.model;

import java.util.Random;

/**
 * Created by VasilyevD on 22.09.2016.
 */
public class Team {

    public static final int TEAM_SIZE = 4;
    private Player[] players;
    private String nameTeam;

    public Team(String nameTeam, Player[] players) {
        this.nameTeam = nameTeam;
        this.players = players;
    }

    public void whoPassed(int maxPoint) {
        for (int i = 0; i < TEAM_SIZE; i++) {
            if (players[i].getResult() > maxPoint * 2 / 3) System.out.println(players[i].getName() + " passed course");
        }
    }

    public void teamInfo() {
        System.out.println(nameTeam);
        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.print(i + 1 + " player info:\n" +
                    "   Name " + players[i].getName() + "\n" +
                    "   Type Player " + players[i].getType() + "\n" +
                    "   Results " + players[i].getResult() + "\n");
        }
    }

    public Player getPlayer(int p) {
        return players[p];
    }

    public int getAllPoints() {
        int allPoints = 0;
        for (int i = 0; i < TEAM_SIZE; i++) {
            allPoints += players[i].getResult();
        }
        return allPoints;
    }
    public String getNameTeam(){
        return nameTeam;
    }
}
