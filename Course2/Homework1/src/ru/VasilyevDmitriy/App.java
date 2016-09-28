package ru.VasilyevDmitriy;

import ru.VasilyevDmitriy.model.Course;
import ru.VasilyevDmitriy.model.Player;
import ru.VasilyevDmitriy.model.Team;

import java.util.Random;

/**
 * Created by VasilyevD on 22.09.2016.
 */
public class App {
    public static Player[] p1, p2;
    public static String[] names={"Tanya","Petya", "Tolya","Lena"};
    public static String[] names2={"Pasha","Sasha","Dima","Olya"};
    public static Random r =new Random();

    public static void main(String[] args) {
        p1 = initTeam(names);
        p2 = initTeam(names2);
        Team team1 = new Team("Strela",p1);
        Team team2 = new Team("Raketa",p2);
        Course c = new Course();
        c.doIt(team1);
        c.doIt(team2);
        team1.teamInfo();
        team2.teamInfo();
        System.out.println("To win team must have "+c.getWinPoints());
        printTeamResult(team1,c);
        printTeamResult(team2,c);

    }
    public static  Player[] initTeam(String[] names){
        Player[] p = new Player[Team.TEAM_SIZE];
        for (int i=0;i<Team.TEAM_SIZE;i++){
            p[i] = new Player(names[i],r.nextInt(4)+1);
        }
        return p;
    }
    public static void printTeamResult(Team t, Course c){
        String no="";
        if (!c.isCoursePassed(t)) {
            no=no+" not";
        }
        System.out.println("Team "+t.getNameTeam() +no+" passed course with "+t.getAllPoints()+" points");
    }
}
