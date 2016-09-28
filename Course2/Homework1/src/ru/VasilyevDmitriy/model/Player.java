package ru.VasilyevDmitriy.model;

/**
 * Created by VasilyevD on 22.09.2016.
 */
public class Player {

    private String name;
    private int result;
    private int type; //abstract type of players

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Player(String name, int i){
        this.name=name;
        this.result = 0;
        this.type = i;
    }
    public void doBarrier(int type){
        if(this.getType()>=type) result+=Course.POINTS*type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
