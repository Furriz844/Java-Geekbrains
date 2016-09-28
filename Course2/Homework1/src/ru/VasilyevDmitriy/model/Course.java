package ru.VasilyevDmitriy.model;

import java.util.Random;

/**
 * Created by VasilyevD on 22.09.2016.
 */
public class Course {
    private int[] barrier={1,2,3,4}; //difficulty level of barriers
    public static int POINTS = 10;
    private int maxPoints=0;

    public Course(){
        for(int i=0;i<barrier.length;i++) {
            maxPoints+=POINTS*barrier[i];
        }
    }

    public void doIt(Team t){
        for(int i=0;i<barrier.length;i++){
            for (int j=0;j<Team.TEAM_SIZE;j++){
                t.getPlayer(j).doBarrier(barrier[i]);
            }
        }
    }
    public boolean isCoursePassed(Team t) {
        if(t.getAllPoints()>getWinPoints()) {
            return true;
        }
        return false;
    }
    public int getWinPoints(){
        return maxPoints*Team.TEAM_SIZE/3;
    }
}
